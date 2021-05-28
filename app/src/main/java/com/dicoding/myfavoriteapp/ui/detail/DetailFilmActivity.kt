package com.dicoding.myfavoriteapp.ui.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.dicoding.myfavoriteapp.R
import com.dicoding.core.domain.model.Film
import com.dicoding.myfavoriteapp.databinding.ActivityDetailFilmBinding
import com.dicoding.myfavoriteapp.databinding.ContentDetailFilmBinding
import com.dicoding.core.vo.Status
import org.koin.android.viewmodel.ext.android.viewModel

class DetailFilmActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_FILM = "extra_film"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var _detailContentBinding: ContentDetailFilmBinding
    private var menu: Menu? = null
    private var type: String? = null
    private val viewModel: DetailFilmViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailFilmBinding = ActivityDetailFilmBinding.inflate(layoutInflater)
        _detailContentBinding = activityDetailFilmBinding.detailContent

        setContentView(activityDetailFilmBinding.root)

        setSupportActionBar(activityDetailFilmBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val extras = intent.extras
        if (extras != null) {
            val id= extras.getInt(EXTRA_FILM)
            type = extras.getString(EXTRA_TYPE)
            if (id != 0) {
                viewModel.setSelectedFilm(id)
                if(type == "film"){
                    viewModel.getFilm.observe(this, Observer{ film ->
                        if(film!=null){
                            when(film.status){
                                Status.LOADING ->  _detailContentBinding.progressBar.visibility = View.VISIBLE
                                Status.SUCCESS -> if (film.data != null) {
                                    _detailContentBinding.progressBar.visibility = View.GONE
                                    populateFilm(film.data!!)
                                }
                                Status.ERROR ->   {
                                    _detailContentBinding.progressBar.visibility = View.GONE
                                    Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    })
                }
                else{
                    viewModel.getTvShow.observe(this, Observer{ film ->
                        if(film != null){
                            when(film.status){
                                Status.LOADING ->  _detailContentBinding.progressBar.visibility = View.VISIBLE
                                Status.SUCCESS -> if (film.data != null) {
                                    _detailContentBinding.progressBar.visibility = View.GONE
                                    populateFilm(film.data!!)
                                }
                                Status.ERROR ->   {
                                    _detailContentBinding.progressBar.visibility = View.GONE
                                    Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    })
                }
            }
        }
    }

    private fun populateFilm(film: Film) {

        val genre = StringBuilder()
        for(i in film.genre){
            genre.append(i.name.toString()).append(" ")
        }

        _detailContentBinding.apply {
            textTitle.text = film.title
            textDescription.text = film.overview
            textGenrefilm.text = genre.toString()
            (film.imdbScore.toString()+"/10").also { textRating.text = "rating: $it" }
            textDuration.text = if (film.duration == 0) "duration: -"  else "duration: " + film.duration.toString() + "minutes"
            textDate.text = film.releaseYear

            Glide.with(this@DetailFilmActivity)
                .load(film.photo)
                .transform(RoundedCorners(20))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(imagePoster)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_favorite, menu)
        this.menu = menu
        if(type == "film"){
            viewModel.getFilm.observe(this, Observer{ film ->
                if(film!=null){
                    when(film.status){
                        Status.LOADING ->  _detailContentBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> if (film.data != null) {
                            _detailContentBinding.progressBar.visibility = View.GONE
                            val state = film.data!!.favorited
                            setFavoriteState(state)
                        }
                        Status.ERROR ->   {
                            _detailContentBinding.progressBar.visibility = View.GONE
                            Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
        }
        else{
            viewModel.getTvShow.observe(this, Observer{ film ->
                if(film!=null){
                    when(film.status){
                        Status.LOADING ->  _detailContentBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> if (film.data != null) {
                            _detailContentBinding.progressBar.visibility = View.GONE
                            val state = film.data!!.favorited
                            setFavoriteState(state)
                        }
                        Status.ERROR ->   {
                            _detailContentBinding.progressBar.visibility = View.GONE
                            Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_favorite) {
            if(type == "film"){
                viewModel.setFavoriteFilm()
            }
            else{
                viewModel.setFavoriteTv()
            }
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setFavoriteState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_favorite)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorited)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite)
        }
    }
}