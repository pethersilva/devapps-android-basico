package com.pethersilva.devapps20201_helloworld

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pethersilva.devapps20201_helloworld.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

		binding = ActivityMainBinding.inflate(layoutInflater)
		val view = binding.root
        setContentView(view)

		binding.button.setOnClickListener {
			Toast.makeText(this, "Utilizando o view binding",
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
