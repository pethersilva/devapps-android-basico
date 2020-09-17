package com.pethersilva.devapps20201_helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.pethersilva.devapps20201_helloworld.model.Operation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

		button.setOnClickListener {
			Toast.makeText(this, "Resultado", Toast.LENGTH_SHORT).show()

			//verificando se o primeiro valor é correto
			if (editTextNumberFirst.text.isNullOrEmpty()) {

			}
			//verificando se o segundo valor é correto
			if (editTextNumberSecond.text.isNullOrEmpty()) {

			}

			val operation = Operation()
			val resultado = operation.sum(editTextNumberFirst.text.toString().toDouble(),
				editTextNumberFirst.text.toString().toDouble())

			Toast.makeText(this, "$resultado", Toast.LENGTH_SHORT).show()
		}
    }
}
