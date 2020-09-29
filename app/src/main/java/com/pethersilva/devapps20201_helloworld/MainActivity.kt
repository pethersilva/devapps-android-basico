package com.pethersilva.devapps20201_helloworld

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
	companion object {
		const val MAIN_ACTIVITY_NAME_EXTRA_ID = "name"
		const val TAG = "lifecycle"
		const val SAVED_INSTANCE_EXTRA_ID = "saved_instance_extra_id"
	}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

		if (savedInstanceState != null) {
			val saved = savedInstanceState.getFloat(SAVED_INSTANCE_EXTRA_ID)
			Log.d(TAG, "onCreate not null: $saved")
		}

		button.setOnClickListener {
			val name = editTextTextPersonName.text.toString()
			if (isNameValid(name)) {
				val secondActivity = Intent(this, SecondActivity::class.java)
				secondActivity.putExtra(MAIN_ACTIVITY_NAME_EXTRA_ID, name)
				startActivity(secondActivity)
			} else {
				Toast.makeText(this, "Please fill your name", Toast.LENGTH_SHORT).show()
			}
		}
		Log.d(TAG, "onCreate()")
	}

	override fun onStart() {
		super.onStart()
		Log.d(TAG, "onStart()")
	}

	override fun onResume() {
		super.onResume()
		Log.d(TAG, "onResume()")
	}

	override fun onRestart() {
		super.onRestart()
		Log.d(TAG, "onRestart()")
	}

	override fun onPause() {
		super.onPause()
		Log.d(TAG, "onPause()")
	}

	override fun onStop() {
		super.onStop()
		Log.d(TAG, "onStop()")
	}

	override fun onDestroy() {
		super.onDestroy()
		Log.d(TAG, "onDestroy()")
	}

	override fun onSaveInstanceState(outState: Bundle) {
		super.onSaveInstanceState(outState)
		outState.putFloat(SAVED_INSTANCE_EXTRA_ID, 10.1f)
		Log.d(TAG, "onSaveInstanceState()")
	}

	override fun onRestoreInstanceState(savedInstanceState: Bundle) {
		super.onRestoreInstanceState(savedInstanceState)
		val saved = savedInstanceState.getFloat(SAVED_INSTANCE_EXTRA_ID)
		Log.d(TAG, "onRestoreInstanceState(): $saved")

	}
	private fun isNameValid(name: String): Boolean = !name.isNullOrEmpty()
}
