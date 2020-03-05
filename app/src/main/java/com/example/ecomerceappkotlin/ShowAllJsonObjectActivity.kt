package com.example.ecomerceappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_show_all_json_object.*
import org.json.JSONArray
import org.json.JSONObject

class ShowAllJsonObjectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_all_json_object)
        txtShowAllProduct.setOnClickListener {

            val allProductsURL = "http://192.168.1.8/Ecomerce/present_json_array.php"
            var allProducts: String = ""
            val requestQ = Volley.newRequestQueue(this)

            val jsonArrayObjectRequest = JsonArrayRequest(Request.Method.GET, allProductsURL, null,
                Response.Listener<JSONArray> {

                    for (productIndex in 0.until(it.length())) {
                            allProducts+=(it[productIndex] as JSONObject).getString("name")

                    }

                    txtShowAllProduct.text = allProducts


                }, Response.ErrorListener {

                })

            requestQ.add(jsonArrayObjectRequest)


        }
    }
}
