package com.dicoding.myfavoriteapp.ui.home.film

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.myfavoriteapp.R
import com.dicoding.core.domain.model.Film
import com.dicoding.myfavoriteapp.databinding.ItemsFilmBinding
import com.dicoding.myfavoriteapp.ui.detail.DetailFilmActivity

class FilmAdapter: RecyclerView.Adapter<FilmAdapter.FilmViewHolder>() {
    private var listData = ArrayList<Film>()

    fun setData(newListData: List<Film>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):FilmViewHolder {
        val itemsFilmBinding = ItemsFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmViewHolder(itemsFilmBinding)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = listData[position]
        if(film !=null){
            holder.bind(film)
        }

    }

    class FilmViewHolder(private val binding: ItemsFilmBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(film: Film) {
            with(binding) {
                tvItemTitle.text = film.title
                tvItemDate.text =film.releaseYear.toString()
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailFilmActivity::class.java)
                    intent.putExtra(DetailFilmActivity.EXTRA_FILM, film.id)
                    intent.putExtra(DetailFilmActivity.EXTRA_TYPE, "film")
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(film.photo)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                    .into(imgPoster)
            }
        }
    }

    override fun getItemCount(): Int {
        return listData.size
    }


}