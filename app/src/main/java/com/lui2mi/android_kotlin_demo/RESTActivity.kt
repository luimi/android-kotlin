package com.lui2mi.android_kotlin_demo

import Adapters.RESTAdapter
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception

class RESTActivity : AppCompatActivity() {

    lateinit var list: ListView
    lateinit var start: Button
    lateinit var loading: ProgressBar
    lateinit var response: TextView
    lateinit var adapter: RESTAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rest)

        list = findViewById(R.id.lv_rest)
        start = findViewById(R.id.btn_get)
        loading = findViewById(R.id.pb_loading)
        response = findViewById(R.id.tv_response)

        adapter = RESTAdapter(this)
        list.adapter = adapter
    }
    fun getData(v: View) {
        loading.visibility = View.VISIBLE
        val queue = Volley.newRequestQueue(this)
        val url = "http://jsonplaceholder.typicode.com/posts"

        val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener<String> { response ->
                loading.visibility = View.GONE
                try{
                    adapter.data = JSONArray(response)
                    adapter.notifyDataSetChanged()
                    this.response.text = "Loaded ${adapter.data.length()} posts"
                }catch (e: Exception){
                    this.response.text = "That didn't work!"
                }
            },
            Response.ErrorListener {
                response.text = "That didn't work!"
                loading.visibility = View.GONE
            })

        queue.add(stringRequest)
    }
    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, RESTActivity::class.java)
        }
    }

}
