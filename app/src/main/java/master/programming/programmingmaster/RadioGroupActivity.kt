package master.programming.programmingmaster

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_radio_group.*

class RadioGroupActivity : AppCompatActivity() {

    var radioProfesi = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_group)

        radio_developer.setOnClickListener {
            radioProfesi = "Developer"
            Toast.makeText(applicationContext, "Ini $radioProfesi", Toast.LENGTH_LONG).show()

        }

        radio_programmer.setOnClickListener {
            radioProfesi = "Programmer"
            Toast.makeText(applicationContext, "Ini $radioProfesi", Toast.LENGTH_LONG).show()

        }

        btn.setOnClickListener {
            if (radioProfesi.equals("")){
                Toast.makeText(applicationContext, "Masih Kosong", Toast.LENGTH_LONG).show()
            } else {
                //.val intent = Intent()
            }
        }
    }

    fun onRadioButtonClicked(v : View) {
        if (v is RadioButton) {
            val checked = v.isChecked

            when(v.id)
            {
                R.id.radio_pirates -> if (checked) {
                    Toast.makeText(applicationContext, "Ini Pirates", Toast.LENGTH_LONG).show()
                }
                R.id.radio_ninjas -> if(checked) {
                    Toast.makeText(applicationContext, "ini ninjas", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
