package com.example.yourhealth

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Bitmap

import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log.e
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
import java.io.InputStream
import java.lang.Exception
import java.net.URL


class skinDisease : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skin_disease)


         val img1:ImageView=findViewById(R.id.D_img1)
        DownloadImageFromInternet(findViewById(R.id.D_img1)).execute("https://img.webmd.com/dtmcms/live/webmd/consumer_assets/site_images/articles/health_tools/adult_skin_problems_slideshow/dermnet_rf_photo_of_eczema_on_hand.jpg?resize=652px:*&output-quality=75")
        DownloadImageFromInternet(findViewById(R.id.D_img2)).execute("https://img.webmd.com/dtmcms/live/webmd/consumer_assets/site_images/articles/health_tools/adult_skin_problems_slideshow/getty_rm_photo_of_poison_ivy_rash.jpg?resize=652px:*&output-quality=75")
        DownloadImageFromInternet(findViewById(R.id.D_img3)).execute("https://img.webmd.com/dtmcms/live/webmd/consumer_assets/site_images/articles/health_tools/adult_skin_problems_slideshow/dermnet_rf_photo_of_polycyclic_hives.jpg?resize=652px:*&output-quality=75")
        DownloadImageFromInternet(findViewById(R.id.D_img4)).execute("https://img.webmd.com/dtmcms/live/webmd/consumer_assets/site_images/articles/health_tools/adult_skin_problems_slideshow/dermnet_duo_acne_whitehead_blackhead.jpg?resize=652px:*&output-quality=75")
        DownloadImageFromInternet(findViewById(R.id.D_img5)).execute("https://img.webmd.com/dtmcms/live/webmd/consumer_assets/site_images/articles/health_tools/adult_skin_problems_slideshow/dermnet_rf_photo_of_psoriasis_plaque.jpg?resize=652px:*&output-quality=75")




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


