package com.dicoding.myfavoriteapp.ui.home.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.myfavoriteapp.databinding.FragmentTvShowBinding
import com.dicoding.core.vo.Status
import org.koin.android.viewmodel.ext.android.viewModel

class TvShowFragment : Fragment() {
    private lateinit var _fragmentTvShowBinding: FragmentTvShowBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return _fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val viewModel:TvShowViewModel by viewModel()

            val tvShowAdapter = TvShowAdapter()
            viewModel.getTvShow().observe(this, Observer{ films ->
                if(films !=null){
                    when(films.status){
                        Status.LOADING ->   _fragmentTvShowBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS ->{
                            _fragmentTvShowBinding.progressBar.visibility = View.GONE
                            tvShowAdapter.setData(films.data)
                           tvShowAdapter.notifyDataSetChanged()

                        }
                        Status.ERROR->{
                            _fragmentTvShowBinding.progressBar.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(_fragmentTvShowBinding.rvTvshow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }
}