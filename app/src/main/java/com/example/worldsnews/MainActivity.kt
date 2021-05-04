package com.example.worldsnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NewItemClicked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recView.layoutManager = LinearLayoutManager(this)

        val fetchedData = FetchData()
        val adaptar  = NewsListAdaptar(fetchedData,this)
        recView.adapter = adaptar

    }

    private  fun  FetchData() : ArrayList<String>{
        val list = ArrayList<String>()
        for (i in 0 until 100)
            list.add("Item numnber $i")
        return  list
    }

    override fun onItemClicked(item: String) {

        Toast.makeText(this,"Clicked item $item",Toast.LENGTH_SHORT).show()
    }
}