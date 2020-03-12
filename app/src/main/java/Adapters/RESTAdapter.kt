package Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.lui2mi.android_kotlin_demo.R
import org.json.JSONArray
import org.json.JSONObject

class RESTAdapter(val context : Context) : BaseAdapter() {
    var data: JSONArray = JSONArray()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val v : View = LayoutInflater.from(context).inflate(R.layout.adapter_rest,null,true)
        val post : JSONObject = getItem(position) as JSONObject
        v.findViewById<TextView>(R.id.tv_title).text = post.optString("title")
        v.findViewById<TextView>(R.id.tv_body).text = post.optString("body")
        return v
    }

    override fun getItem(position: Int): Any = data[position]

    override fun getItemId(position: Int): Long = 0

    override fun getCount(): Int = data.length()

}