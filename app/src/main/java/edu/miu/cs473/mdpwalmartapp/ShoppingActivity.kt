package edu.miu.cs473.mdpwalmartapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import edu.miu.cs473.mdpwalmartapp.databinding.ActivityShoppingBinding

class ShoppingActivity : ComponentActivity() {
    private lateinit var binding: ActivityShoppingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val username = intent.getStringExtra("username")
        binding.welcomeText.text = "Welcome, $username"
    }
}