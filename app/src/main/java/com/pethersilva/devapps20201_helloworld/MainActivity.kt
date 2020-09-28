package com.pethersilva.devapps20201_helloworld

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pethersilva.devapps20201_helloworld.model.Car
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
	companion object {
		const val MAIN_ACTIVITY_NAME_EXTRA_ID = "name"
		const val MAIN_ACTIVITY_CAR_EXTRA_ID = "name"
	}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
		button.setOnClickListener {
			val name = editTextTextPersonName.text.toString()
			if (isNameValid(name)) {
				val secondActivity = Intent(this, SecondActivity::class.java)
				secondActivity.putExtra(MAIN_ACTIVITY_NAME_EXTRA_ID, name)

				//Creating a car instance
				val myCar = Car("Ferrari", "Ferrari", 2020)
				secondActivity.putExtra(MAIN_ACTIVITY_CAR_EXTRA_ID, myCar)
				startActivity(secondActivity)
			} else {
				Toast.makeText(this, "Please fill your name", Toast.LENGTH_SHORT).show()
			}
		}
	}
	private fun isNameValid(name: String): Boolean = !name.isNullOrEmpty()
}
