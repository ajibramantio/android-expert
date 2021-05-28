package com.dicoding.favorite.favorite.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.myfavoriteapp.R
import com.dicoding.myfavoriteapp.favorite.databinding.FragmentTvShowFavoriteBinding
import com.google.android.material.snackbar.Snackbar
import org.koin.android.viewmodel.ext.android.viewModel

class TvShowFavoriteFragment : Fragment() {
    private lateinit var _fragmentTvShowFavoriteBinding: FragmentTvShowFavoriteBinding
    private val viewModel: TvShowFavoriteViewModel by viewModel()
    private lateinit var tvShowAdapter: TvShowFavoriteAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _fragmentTvShowFavoriteBinding = FragmentTvShowFavoriteBinding.inflate(layoutInflater, container, false)
        return _fragmentTvShowFavoriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(_fragmentTvShowFavoriteBinding.rvTvshowFavorite)
        if (activity != null) {
            tvShowAdapter = TvShowFavoriteAdapter()
            _fragmentTvShowFavoriteBinding.progressBarFavorite.visibility = View.VISIBLE
            viewModel.getTvShowFavorite().observe(this, Observer{ films ->
                if(films != null){
                    _fragmentTvShowFavoriteBinding.progressBarFavorite.visibility = View.GONE
                    tvShowAdapter.setData(films)
                    tvShowAdapter.notifyDataSetChanged()
                }
            })

            with(_fragmentTvShowFavoriteBinding.rvTvshowFavorite) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }
    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean = true
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val courseEntity = tvShowAdapter.getSwipedData(swipedPosition)
                courseEntity?.let { viewModel.setFavorite(it) }
                val snackbar = Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.message_ok) { v ->
                    courseEntity?.let { viewModel.setFavorite(it) }
                }
                snackbar.show()
            }
        }
    })
}





















