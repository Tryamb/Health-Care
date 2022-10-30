package com.example.yourhealth.ui


    class Message {

         //empty for firebase

        constructor(messageText: String){
            text = messageText
        }
        var text: String? = null
        var timestamp: Long = System.currentTimeMillis()
    }
