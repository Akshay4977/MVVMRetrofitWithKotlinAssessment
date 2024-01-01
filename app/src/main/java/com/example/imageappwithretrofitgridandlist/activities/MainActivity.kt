package com.example.imageappwithretrofitgridandlist.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.imageappwithretrofitgridandlist.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupActionBarWithNavController(findNavController(R.id.fragment))
    }

}