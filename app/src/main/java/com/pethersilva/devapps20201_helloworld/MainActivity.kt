package com.pethersilva.devapps20201_helloworld

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

		button.setOnClickListener {
			val secondActivity = Intent(this, SecondActivity::class.java)
			startActivity(secondActivity)
		}
	}
}
