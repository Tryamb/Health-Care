package com.example.yourhealth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase


public class profile_view : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_view)
       /* val user = Firebase.auth.currentUser
        user?.let {
            // Name, email address, and profile photo Url
            val name = user.displayName
            val email = user.email
            val photoUrl = user.photoUrl

            // Check if user's email is verified
            val emailVerified = user.isEmailVerified

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getToken() instead.
            val uid = user.uid
        }*/
        val user=FirebaseAuth.getInstance().currentUser

        val emailId: String = FirebaseAuth.getInstance().currentUser!!.email!!
         val displayFullName: TextView = findViewById<TextView>(R.id.displayName) as TextView
        val avatarText:TextView=findViewById<TextView>(R.id.avatar) as TextView
       // val fullName: String =FirebaseAuth.getInstance().currentUser!!.displayName!!
        val displayUserId: TextView = findViewById<TextView>(R.id.profile) as TextView

        val firstChar:Char=emailId[0]
        val firstStringChar:String=firstChar.toString()

        avatarText.text=firstStringChar
        displayUserId.text = emailId

        if(user!=null)
        {
            val name=user.displayName
            displayFullName.text=name
        }


    }
    public fun signedOut(view: View)
    {
        FirebaseAuth.getInstance().signOut()
        val intent = Intent(this@profile_view, SignInActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
    /*public fun viewUserId(view: View)
    {
        val userId: String = FirebaseAuth.getInstance().currentUser!!.email!!
        val displayUserId: TextView = findViewById<TextView>(R.id.profile) as TextView
        displayUserId.text = userId

    }*/


}