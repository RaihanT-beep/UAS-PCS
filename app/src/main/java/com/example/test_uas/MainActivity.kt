package com.example.test_uas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.test_uas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        init()
    }

    private fun init() {
        binding.bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.ic_home -> navigate(R.id.homeFragment2)
                else ->false
            }
        }
    }

    private fun navigate(id: Int): Boolean {
        findNavController(R.id.navHost).navigate(id)
        return true
    }
}