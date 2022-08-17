package com.example.cleanarchitecture.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecture.R

class MainActivity : AppCompatActivity() {
    lateinit var userName: TextView
    lateinit var getUserNameBtn: Button
    lateinit var editTextUserName: EditText
    lateinit var saveUserName: Button

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userName = findViewById(R.id.userName)
        getUserNameBtn = findViewById(R.id.getUserName)
        editTextUserName = findViewById(R.id.userName_ET)
        saveUserName = findViewById(R.id.saveUserName)

        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(this)
        )[MainViewModel::class.java]

        viewModel.resultLiveData.observe(this, Observer {
            userName.text = it
        })

        getUserNameBtn.setOnClickListener {
            viewModel.get()
        }

        saveUserName.setOnClickListener {
            val name = editTextUserName.text.toString()
            viewModel.save(name)
        }
    }

}