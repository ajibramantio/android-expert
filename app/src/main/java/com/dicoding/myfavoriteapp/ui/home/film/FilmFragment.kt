package com.dicoding.myfavoriteapp.ui.home.film

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer

import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.myfavoriteapp.databinding.FragmentFilmBinding
import com.dicoding.core.vo.Status
import org.koin.android.viewmodel.ext.android.viewModel


class FilmFragment : Fragment() {
    private lateinit var fragmentFilmBinding: FragmentFilmBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentFilmBinding = FragmentFilmBinding.inflate(layoutInflater, container, false)
        return fragmentFilmBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val viewModel:FilmViewModel by viewModel()
            val filmAdapter = FilmAdapter()
            viewModel.getFilm().observe(this, Observer{ films ->
                if(films !=null){
                    Log.d("DATA_FILM",films.status.toString())
                    when(films.status){
                        Status.LOADING ->   fragmentFilmBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS ->{
                            fragmentFilmBinding.progressBar.visibility = View.GONE
                            filmAdapter.setData(films.data)
                            filmAdapter.notifyDataSetChanged()

                        }
                        Status.ERROR->{
                            fragmentFilmBinding.progressBar.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()

                        }

                    }
                }

            })

            with(fragmentFilmBinding.rvFilm) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = filmAdapter
            }
        }
    }
}