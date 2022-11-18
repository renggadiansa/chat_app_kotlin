package com.example.waclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.waclone.databinding.ActivityVerifiicationBinding
import com.google.firebase.auth.FirebaseAuth

class VerifiicationActivity : AppCompatActivity() {

    private val binding: ActivityVerifiicationBinding by lazy {
        ActivityVerifiicationBinding.inflate(layoutInflater)
    }
    var auth : FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        if (auth!!.currentUser != null){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        supportActionBar?.hide()
        binding.editNumber.requestFocus()
        binding.continueBtn.setOnClickListener {
            val intent = Intent(this@VerifiicationActivity, OTPActivity::class.java)
            intent.putExtra("phoneNumber", binding.editNumber.text.toString())
            startActivity(intent)

        }



    }
}