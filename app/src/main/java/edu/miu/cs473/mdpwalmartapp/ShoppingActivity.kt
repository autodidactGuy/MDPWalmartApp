package edu.miu.cs473.mdpwalmartapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import edu.miu.cs473.mdpwalmartapp.adapter.CustomAdapter
import edu.miu.cs473.mdpwalmartapp.databinding.ActivityShoppingBinding

class ShoppingActivity : ComponentActivity() {
    private lateinit var binding: ActivityShoppingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val username = intent.getStringExtra("username")
        binding.welcomeText.text = "Welcome, $username"


        val arrayListImage = ArrayList<Int>()
        arrayListImage.add(R.drawable.electronics)
        arrayListImage.add(R.drawable.clothing)
        arrayListImage.add(R.drawable.beauty)
        arrayListImage.add(R.drawable.food)

        val name = arrayOf("Electronics", "Clothing", "Beauty", "Food")

        val customAdapter = CustomAdapter(this@ShoppingActivity, arrayListImage, name)

        binding.gridView.adapter = customAdapter

        binding.gridView.setOnItemClickListener { adapterView, parent, position, l ->
            Toast.makeText(this@ShoppingActivity, "You have chosen the " + name[position] + " category of shopping", Toast.LENGTH_SHORT).show()
        }
    }
}
