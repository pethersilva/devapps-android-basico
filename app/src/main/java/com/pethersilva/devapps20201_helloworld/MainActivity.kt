package com.pethersilva.devapps20201_helloworld

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
	companion object {
		const val MAIN_ACTIVITY_NAME_EXTRA_ID = "name"
	}
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		button.setOnClickListener {
			createAlarm("Reunião Pedagógica", 18, 30)
		}
	}

	private fun createAlarm(mensagem: String, hora: Int, minutos: Int) {
		val intentAlarme = Intent(AlarmClock.ACTION_SET_ALARM)
		intentAlarme.putExtra(AlarmClock.EXTRA_MESSAGE, mensagem)
		intentAlarme.putExtra(AlarmClock.EXTRA_HOUR, hora)
		intentAlarme.putExtra(AlarmClock.EXTRA_MINUTES, minutos)

		if (intentAlarme.resolveActivity(packageManager) != null) {
			startActivity(intentAlarme)
		} else {
			Toast.makeText(this, "Não foi encontrado uma activity para o " +
					"intent filter escolhido",Toast.LENGTH_SHORT).show()
		}

	}
}
