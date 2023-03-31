package com.example.challengetiga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.challengetiga.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentHuruf = HurufFragment()
        setCurrentFragment(fragmentHuruf)
    }

    private fun setCurrentFragment(fragment: Fragment) : FragmentTransaction =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fr_container, fragment)
            commit()
        }
}