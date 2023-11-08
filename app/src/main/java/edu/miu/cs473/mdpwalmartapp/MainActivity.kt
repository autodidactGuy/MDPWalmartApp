package edu.miu.cs473.mdpwalmartapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import edu.miu.cs473.mdpwalmartapp.databinding.ActivityMainBinding
import edu.miu.cs473.mdpwalmartapp.model.User

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding

    private val users = mutableListOf(
        User("Hello","World","helloworld@gmail.com","123"),
        User("Hassan","Raza","hassan@gmail.com","123456"),
        User("Walmart","","walmart@gmail.com","12345678"),
        User("MDP","","mdp@gmail.com","654321"),
        User("User","","user@gmail.com","1234"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signinBtn.setOnClickListener {
            val emailAddress = binding.emailAddressText.text.toString()
            val password = binding.passwordText.text.toString()
            if (emailAddress.isNotEmpty() && password.isNotEmpty()) {
                if (users.any { it.emailAddress == emailAddress && it.password == password }) {
                    //save user here and goto next activity
                    val intent = Intent(this@MainActivity, ShoppingActivity::class.java)
                    val authenticatedUser =  users.get(0);
                    intent.putExtra("username",authenticatedUser.firstName + " " +authenticatedUser.lastName)
                    startActivity(intent)
                }
                else {
                    Toast.makeText(this, "Email address & password is invalid!", Toast.LENGTH_LONG).show()
                }
            }
            else {
                Toast.makeText(this, "Please enter valid email address & password!", Toast.LENGTH_LONG).show()
            }
        }
    }
}