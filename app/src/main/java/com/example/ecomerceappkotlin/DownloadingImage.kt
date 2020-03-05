package com.example.ecomerceappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_downloading_image.*

class DownloadingImage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_downloading_image)
        imgShowServerImage.setOnClickListener{

            Picasso.get().load("http://192.168.1.8/placeholder.jpg").into(imgShowServerImage)

        }

    }
}
