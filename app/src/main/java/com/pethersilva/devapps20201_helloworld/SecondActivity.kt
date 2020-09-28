package com.pethersilva.devapps20201_helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pethersilva.devapps20201_helloworld.model.Car
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_second)
		val name = intent.getStringExtra(MainActivity.MAIN_ACTIVITY_NAME_EXTRA_ID)

		val myCar = intent.getParcelableExtra<Car>(MainActivity.MAIN_ACTIVITY_CAR_EXTRA_ID)
		val result = getString(R.string.second_activity_message, name, myCar?.nome)

		textView.text = result
	}
}
