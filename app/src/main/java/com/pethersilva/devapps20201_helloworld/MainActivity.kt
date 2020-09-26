package com.pethersilva.devapps20201_helloworld

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

		button.setOnClickListener {
			Toast.makeText(this, "Dessa forma é no Kotlin",
				Toast.LENGTH_SHORT).show()
		}

		val myButton = findViewById<Button>(R.id.buttonFindViewById)
		myButton.setOnClickListener { Toast.makeText(this@MainActivity,
			"Usando findViewById", Toast.LENGTH_SHORT).show() }
	}

	fun handleOnClickEvent(view: View) {
		Toast.makeText(this, "onClickEvent",
			Toast.LENGTH_SHORT).show()
	}
}
