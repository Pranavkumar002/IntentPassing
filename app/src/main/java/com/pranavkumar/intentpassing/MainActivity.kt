package com.pranavkumar.intentpassing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.pranavkumar.intentpassing.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)t
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etSetPassword.doOnTextChanged { text, _, _, _ ->
            if((text?.length ?:0) <6){
                binding.etSetPassword.error = resources.getString(R.string.at_least_6_numbers)

            }else{
                binding.etSetPassword.error = null
            }
        }

        binding.btnSubmit.setOnClickListener{
            System.out.println("clicked")
            var enteremail = binding.etEnterEmail.text.toString()
            var enterfirstname = binding.etFirstName.text.toString()
            var enterlastname = binding.etLastName.text.toString()
            var setpassword = binding.etSetPassword.text.toString()
            System.out.println("enteremail $enteremail")
            if (enterfirstname.isNullOrEmpty())
            {
                binding.etFirstName.error = resources.getString(R.string.enter_first_name)
                binding.etFirstName.requestFocus()
            }
            else if (enterlastname.isNullOrEmpty())
            {
                binding.etLastName.error = resources.getString(R.string.enter_last_name)
                binding.etLastName.requestFocus()
            }

            else if (enteremail.isNullOrEmpty())
            {
                binding.etEnterEmail.error = resources.getString(R.string.please_enter_email)
                binding.etEnterEmail.requestFocus()
            }
            else if (setpassword.isNullOrEmpty())
            {
                binding.etSetPassword.error = resources.getString(R.string.at_least_6_numbers)
            }
            else
            {
                Toast.makeText(this, resources.getString(R.string.submit_successfully), Toast.LENGTH_LONG).show()
                var intent = Intent(this,SecondPassActivity::class.java)
                intent.putExtra("firstname",binding.etFirstName.text.toString())
                intent.putExtra("lastname",binding.etLastName.text.toString())
                intent.putExtra("email",binding.etEnterEmail.text.toString())
                intent.putExtra("setpassword",binding.etSetPassword.text.toString())

                startActivity(intent)
            }
        }



    }
}