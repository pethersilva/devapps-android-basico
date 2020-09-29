package com.pethersilva.devapps20201_helloworld

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
	companion object {
		const val MAIN_ACTIVITY_VALUE01_EXTRA_ID = "value01"
		const val MAIN_ACTIVITY_VALUE02_EXTRA_ID = "value02"
		const val MAIN_ACTIVITY_SUM_REQUEST_CODE = 1
		const val MAIN_ACTIVITY_SUM_RESULT_EXTRA_ID = "sum_result_extra"
	}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

		buttonSum.setOnClickListener {
			val value01 = editTextValue01.text.toString()
			val value02 = editTextValue02.text.toString()
			if (isValid(value01) && isValid(value02)) {
				val secondActivity = Intent(this, SecondActivity::class.java)
				secondActivity.putExtra(MAIN_ACTIVITY_VALUE01_EXTRA_ID, value01)
				secondActivity.putExtra(MAIN_ACTIVITY_VALUE02_EXTRA_ID, value02)
				startActivityForResult(secondActivity, MAIN_ACTIVITY_SUM_REQUEST_CODE)
			} else {
				Toast.makeText(this, "Please inform values", Toast.LENGTH_SHORT).show()
			}
		}
	}

	override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
		super.onActivityResult(requestCode, resultCode, data)
		if (resultCode == Activity.RESULT_OK) {
			if (MAIN_ACTIVITY_SUM_REQUEST_CODE == requestCode) {
				val result = data?.getStringExtra(MAIN_ACTIVITY_SUM_RESULT_EXTRA_ID)
				Toast.makeText(this, "Result: $result", Toast.LENGTH_SHORT).show()
			}
		}
	}

	private fun isValid(name: String): Boolean = !name.isNullOrEmpty()
}

