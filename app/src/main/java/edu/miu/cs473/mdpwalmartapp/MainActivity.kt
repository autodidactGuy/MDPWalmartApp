package edu.miu.cs473.mdpwalmartapp

import android.content.Intent
import android.net.Uri
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

        val newFirstName = intent.getStringExtra("firstName").orEmpty()
        val newLastName = intent.getStringExtra("lastName").orEmpty()
        val newEmailAddress = intent.getStringExtra("emailAddress").orEmpty()
        val newPassword = intent.getStringExtra("password").orEmpty()
        if(newFirstName.isNotEmpty() && newLastName.isNotEmpty() && newEmailAddress.isNotEmpty() && newPassword.isNotEmpty()){
            users.add(User(newFirstName,newLastName,newEmailAddress,newPassword))
        }

        binding.signinBtn.setOnClickListener {
            val emailAddress = binding.emailAddressText.text.toString()
            val password = binding.passwordText.text.toString()
            if (emailAddress.isNotEmpty() && password.isNotEmpty()) {
                if (users.any { it.emailAddress == emailAddress && it.password == password }) {
                    //save user here and goto next activity
                    val intent = Intent(this@MainActivity, ShoppingActivity::class.java)
                    val authenticatedUser = users.filter { it.emailAddress == emailAddress && it.password == password }[0]
                    intent.putExtra("username",authenticatedUser.firstName + " " +authenticatedUser.lastName)
                    startActivity(intent)
                    finish()
                }
                else {
                    Toast.makeText(this, "Email address & password is invalid!", Toast.LENGTH_LONG).show()
                }
            }
            else {
                Toast.makeText(this, "Please enter valid email address & password!", Toast.LENGTH_LONG).show()
            }
        }

        binding.createAccountBtn.setOnClickListener{
            val intent = Intent(this@MainActivity, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.forgotPasswordBtn.setOnClickListener {
            val emailAddress = binding.emailAddressText.text.toString()
            if(emailAddress.isNotEmpty()){
                val searchedUsers = users.filter { it.emailAddress == emailAddress }
                if(searchedUsers.isNotEmpty()){
                    var user = searchedUsers[0]
                    val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:${user.emailAddress}"))
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Reset Password")
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "Hi ${user.firstName} ${user.lastName},\nYour password is : ${user.password} \nThank you!")
                    startActivity(Intent.createChooser(emailIntent, "Send forgot password email!"))
                }
                else{
                    Toast.makeText(this, "Email address not found!", Toast.LENGTH_LONG).show()
                }
            }
            else{
                Toast.makeText(this, "Please enter valid email address!", Toast.LENGTH_LONG).show()
            }
        }
    }
}