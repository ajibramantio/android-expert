package com.dicoding.favorite.favorite.film

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.myfavoriteapp.R
import com.dicoding.core.domain.model.Film
import com.dicoding.myfavoriteapp.databinding.ItemsFilmBinding

class FilmFavoriteAdapter: RecyclerView.Adapter<FilmFavoriteAdapter.FilmViewHolder>() {
    private var listData = ArrayList<Film>()

    fun setData(newListData: List<Film>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val itemsFilmBinding = ItemsFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmViewHolder(itemsFilmBinding)
    }



    fun getSwipedData(swipedPosition: Int): Film = listData[swipedPosition]

    class FilmViewHolder(private val binding: ItemsFilmBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(film: Film) {
            with(binding) {
                tvItemTitle.text = film.title
                tvItemDate.text =film.releaseYear
                Glide.with(itemView.context)
                    .load(film.photo)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                    .into(imgPoster)
            }
        }
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = listData[position]
        if(film !=null){
            holder.bind(film)
        }
    }

    override fun getItemCount(): Int {
       return listData.size
    }


}