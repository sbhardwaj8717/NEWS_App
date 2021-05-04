package com.example.worldsnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), ClickItem {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recView.layoutManager = LinearLayoutManager(this)

        val item = fetch()


        val adapter : NewsAdapter= NewsAdapter(item,this)
        recView.adapter = adapter

    }
    private fun fetch() :ArrayList<String>  {
        val list = ArrayList<String>()
        for (i in 0 until 100)
            list.add("item $i")
        return list
    }

    override fun onEachClick(item: String) {
        Toast.makeText(this,"item clicked $item" , Toast.LENGTH_LONG).show()
    }
}