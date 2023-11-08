package edu.miu.cs473.mdpwalmartapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import edu.miu.cs473.mdpwalmartapp.databinding.ActivityRegisterBinding

class RegisterActivity : ComponentActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.createAccountBtn.setOnClickListener{
            var firstName = binding.firstNameText.text.toString()
            var lastName = binding.lastNameText.text.toString()
            var emailAddress = binding.emailAddressText.text.toString()
            var password = binding.passwordText.text.toString()

            if(firstName.isNotEmpty() && lastName.isNotEmpty() && emailAddress.isNotEmpty() && password.isNotEmpty()){
                Toast.makeText(this, "Account created successfully, Please login to continue!", Toast.LENGTH_LONG).show()
                val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                intent.putExtra("firstName",firstName)
                intent.putExtra("lastName",lastName)
                intent.putExtra("emailAddress",emailAddress)
                intent.putExtra("password",password)
                startActivity(intent)
                finish()
            }
            else {
                Toast.makeText(this, "Please enter all required field and try again!", Toast.LENGTH_LONG).show()
            }
        }

    }
}