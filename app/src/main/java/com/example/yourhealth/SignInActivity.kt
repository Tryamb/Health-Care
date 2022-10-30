package com.example.yourhealth
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.yourhealth.MainActivity
import com.example.yourhealth.SignUpActivity
import com.example.yourhealth.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth

 class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)


        firebaseAuth = FirebaseAuth.getInstance()

        val progressBar:ProgressBar = findViewById<ProgressBar>(R.id.progressBar) as ProgressBar
        val btn:Button = findViewById<Button>(R.id.button)

        binding.textView.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        binding.button.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val pass = binding.passET.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {
                btn.visibility=View.GONE
                progressBar.visibility=View.VISIBLE

                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {

                    if (it.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        btn.visibility=View.VISIBLE
                        progressBar.visibility=View.GONE
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                    }
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed", Toast.LENGTH_SHORT).show()

            }
        }
    }

    override fun onStart() {
        super.onStart()

        if(firebaseAuth.currentUser != null){
            val name = firebaseAuth.currentUser!!.displayName
            val email = firebaseAuth.currentUser!!.email
            val photoUrl = firebaseAuth.currentUser!!.photoUrl
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}