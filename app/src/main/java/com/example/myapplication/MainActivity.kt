package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Adapters.RecyclerViewAdapter
import com.example.myapplication.models.User
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private val mArrayListUser = ArrayList<User>()

    private val fname = arrayOf("First name User 1", "First name User 2", "First name User 3", "First name User 4")
    private val lname = arrayOf("Last name User 1", "Last name User 2", "Last name User 3", "Last name User 4")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setup recyclerview
        val mRecyclerView = findViewById(R.id.recyclerView) as RecyclerView
        mRecyclerView.layoutManager = LinearLayoutManager(this)

        val mAdapter = RecyclerViewAdapter(this)
        mRecyclerView.adapter = mAdapter

        //add data to arraylist
        for (i in fname.indices) {
            val mUser = User()
            mUser.fname = fname[i]
            mUser.lname = lname[i]
            mArrayListUser.add(mUser)
        }
        mAdapter.setArrayListUser(mArrayListUser)

    }
}
