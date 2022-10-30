package com.example.yourhealth

import android.content.Intent
import android.graphics.drawable.Icon
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.TextView
import android.widget.EditText
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.drawerlayout.widget.DrawerLayout
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import org.w3c.dom.Text
import java.text.DecimalFormat
import androidx.annotation.NonNull

import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn=findViewById<LinearLayout>(R.id.help)
        var btnSkin=findViewById<LinearLayout>(R.id.skinScan)
        btn.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://consult-doctor.netlify.app/")
            startActivity(openURL)
        }
        btnSkin.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://skin-disease-test.netlify.app/")
            startActivity(openURL)
        }

    }
    public fun orderMedicine(view: View) {
        var intent=Intent(this@MainActivity, MedicineOrder::class.java)
        startActivity(intent)
    }
    public fun skinDiseaseImages(view: View) {
        var intent=Intent(this@MainActivity, skinDisease::class.java)
        startActivity(intent)
    }
    public fun mentalHealth(view: View) {
        var intent=Intent(this@MainActivity, MentalHealth::class.java)
        startActivity(intent)
    }
    public fun chatDoctor(view: View) {
        var intent=Intent(this@MainActivity, ChatScreen::class.java)
        startActivity(intent)
    }



    public fun viewProfile(view: View)
    {
        var i=Intent(this@MainActivity,profile_view::class.java)
        startActivity(i)
    }




}

