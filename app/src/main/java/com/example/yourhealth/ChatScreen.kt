package com.example.yourhealth

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.yourhealth.ui.Message

class ChatScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_screen)
       val btnSend: ImageView = findViewById<ImageView>(R.id.btnSend) as ImageView
        val chatActivityEditText: TextView = findViewById(R.id.textInput)
        btnSend.setOnClickListener {
            if (!chatActivityEditText.text.toString().isEmpty()) {
                chatActivityEditText.text=""
            } else {
                Toast.makeText(this, "Please enter a message", Toast.LENGTH_SHORT).show()
            }
        }
    }

   /* val btnSend:Button=findViewById(R.id.btnSend)
    val chatActivityEditText:TextView=findViewById(R.id.textInput)
    val chat:TextView=findViewById(R.id.textOutput)
    private fun setupSendButton() {

        btnSend.setOnClickListener {
            if (!chatActivityEditText.text.toString().isEmpty()){
                sendData()
            }else{
                Toast.makeText(this, "Please enter a message", Toast.LENGTH_SHORT).show()
            }
        }
    }

    /**
     * Send data to firebase
     */
    private fun sendData(){
        /*databaseReference?.
        child("messages")?.
        child(java.lang.String.valueOf(System.currentTimeMillis()))?.
        setValue(Message(chatActivityEditText.text.toString()))*/

        //clear the text
        chatActivityEditText.text=""
        chat.text=chatActivityEditText.text
    }*/

}