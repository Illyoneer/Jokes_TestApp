package ru.glushko.testingjokeapp.presentation.activity

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navDeepLink
import androidx.navigation.ui.setupWithNavController
import ru.glushko.testingjokeapp.R
import ru.glushko.testingjokeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var _mainActivityBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        _mainActivityBinding.bottomNavView.setupWithNavController(navController)

        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#6B5C87")))

        navController.addOnDestinationChangedListener {_, destination, _ ->
            when(destination.id) {
                R.id.jokes -> {
                    supportActionBar?.title = "Jokes"
                }

                R.id.web -> {
                    supportActionBar?.title = "API Info"
                }
            }
        }
        setContentView(_mainActivityBinding.root)
    }
}