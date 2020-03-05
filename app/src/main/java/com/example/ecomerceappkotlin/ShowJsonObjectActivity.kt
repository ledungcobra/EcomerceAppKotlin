package com.example.ecomerceappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_show_json_object.*

class ShowJsonObjectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_json_object)

        btnSubmit.setOnClickListener {
            val url = "http://192.168.1.8/Ecomerce/present_json.php?id=${edtProductID.text}"
            val requestQ = Volley.newRequestQueue(this@ShowJsonObjectActivity)
            val jsonOR: JsonObjectRequest =
                JsonObjectRequest(Request.Method.GET, url, null, Response.Listener {

                    txtProductPrice.text = it.getInt("price").toString();
                    txtProductName.text = it.getString("name")

                }, Response.ErrorListener {

                    Log.i("errorX",it.toString())

                })
            requestQ.add(jsonOR)
        }
    }
}
