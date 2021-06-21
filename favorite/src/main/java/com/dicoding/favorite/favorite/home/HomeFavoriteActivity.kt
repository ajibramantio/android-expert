package com.dicoding.favorite.favorite.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.myfavoriteapp.favorite.databinding.ActivityHomeFavoriteBinding
import org.koin.core.context.loadKoinModules
import com.dicoding.favorite.di.favoritesModule

class HomeFavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val activityHomeFavoriteBinding = ActivityHomeFavoriteBinding.inflate(layoutInflater)
        setContentView(activityHomeFavoriteBinding.root)

        val sectionsPagerAdapter = SectionsPagerFavoriteAdapter(this, supportFragmentManager)
        activityHomeFavoriteBinding.viewPagerFavorite.adapter = sectionsPagerAdapter
        activityHomeFavoriteBinding.tabsFavorite.setupWithViewPager(activityHomeFavoriteBinding.viewPagerFavorite)

        supportActionBar?.elevation = 0f
        supportActionBar?.title = "Favorite List"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        loadKoinModules(favoritesModule)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}