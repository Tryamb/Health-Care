package com.example.yourhealth

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import java.lang.Exception

class MentalHealth : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mental_health)
        DownloadImageFromInternet(findViewById(R.id.D_img1)).execute("https://www.helpguide.org/wp-content/uploads/illustration-gears-in-head-768.jpg")
        DownloadImageFromInternet(findViewById(R.id.D_img2)).execute("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQAIN5o6EyqnEMd9QmXedBZXbgYy_aaIj5xAmG1SSC5GKjMiIHHZMUiNSU7xrREoMpw-fY&usqp=CAU")

    }
    @SuppressLint("StaticFieldLeak")
    @Suppress("DEPRECATION")
    private inner class DownloadImageFromInternet(var imageView: ImageView) : AsyncTask<String, Void, Bitmap?>() {

        override fun doInBackground(vararg urls: String): Bitmap? {
            val imageURL = urls[0]
            var image: Bitmap? = null
            try {
                val `in` = java.net.URL(imageURL).openStream()
                image = BitmapFactory.decodeStream(`in`)
            }
            catch (e: Exception) {
                android.util.Log.e("Error Message", e.message.toString())
                e.printStackTrace()
            }
            return image
        }
        override fun onPostExecute(result: Bitmap?) {
            imageView.setImageBitmap(result)
        }
    }

}