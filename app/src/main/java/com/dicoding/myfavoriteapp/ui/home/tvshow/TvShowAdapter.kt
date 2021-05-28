package com.dicoding.myfavoriteapp.ui.home.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.myfavoriteapp.R
import com.dicoding.core.domain.model.Film
import com.dicoding.myfavoriteapp.databinding.ItemsTvshowBinding
import com.dicoding.myfavoriteapp.ui.detail.DetailFilmActivity

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    private var listData = ArrayList<Film>()

    fun setData(newListData: List<Film>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):TvShowViewHolder {
        val itemsTvShowBinding = ItemsTvshowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemsTvShowBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val film = listData[position]
        if(film !=null){
            holder.bind(film)
        }
    }

    class TvShowViewHolder(private val binding: ItemsTvshowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(film: Film) {
            with(binding) {
                tvItemTitle.text = film.title
                tvItemDate.text =film.releaseYear
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailFilmActivity::class.java)
                    intent.putExtra(DetailFilmActivity.EXTRA_FILM, film.id)
                    intent.putExtra(DetailFilmActivity.EXTRA_TYPE, "tvshow")
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