package com.dicoding.favorite.favorite.film

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
import com.dicoding.myfavoriteapp.favorite.databinding.FragmentFilmFavoriteBinding
import com.google.android.material.snackbar.Snackbar
import org.koin.android.viewmodel.ext.android.viewModel

class FilmFavoriteFragment : Fragment() {

    private lateinit var _fragmentFilmFavoriteBinding: FragmentFilmFavoriteBinding
    private val viewModel: FilmFavoriteViewModel by viewModel()
    private lateinit var filmAdapter: FilmFavoriteAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _fragmentFilmFavoriteBinding = FragmentFilmFavoriteBinding.inflate(layoutInflater, container, false)
        return _fragmentFilmFavoriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(_fragmentFilmFavoriteBinding.rvFilmFavorite)
        if (activity != null) {

            filmAdapter = FilmFavoriteAdapter()
            _fragmentFilmFavoriteBinding.progressBarFavorite.visibility = View.VISIBLE
            viewModel.getFavoriteFilm().observe(this, Observer{ films ->
                if(films != null){
                    _fragmentFilmFavoriteBinding.progressBarFavorite.visibility = View.GONE
                    filmAdapter.setData(films)
                    filmAdapter.notifyDataSetChanged()
                }

            })

            with(_fragmentFilmFavoriteBinding.rvFilmFavorite) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = filmAdapter
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
                val filmEntity = filmAdapter.getSwipedData(swipedPosition)
                filmEntity?.let { viewModel.setFavorite(it) }
                val snackbar = Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.message_ok) { v ->
                    filmEntity?.let { viewModel.setFavorite(it) }
                }
                snackbar.show()
            }
        }
    })
}