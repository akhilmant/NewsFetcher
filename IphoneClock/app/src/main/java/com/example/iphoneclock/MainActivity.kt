package com.example.iphoneclock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.iphoneclock.databinding.ActivityMainBinding
import com.example.iphoneclock.ui.AlarmFragment
import com.example.iphoneclock.ui.StopwatchFragment
import com.example.iphoneclock.ui.TimerFragment
import com.example.iphoneclock.ui.WorldClock
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navView:BottomNavigationView=binding.bottomNavBar
        val navController=findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration= AppBarConfiguration(
            setOf(R.id.alarmFragment,R.id.stopwatchFragment,R.id.worldClock,R.id.timerFragment)
        )
        setupActionBarWithNavController(navController,appBarConfiguration)
        navView.setupWithNavController(navController)
    }
    }

