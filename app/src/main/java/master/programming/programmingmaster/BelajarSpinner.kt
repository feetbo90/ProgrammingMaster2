package master.programming.programmingmaster

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast


class BelajarSpinner : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    @SuppressLint("ShowToast")
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(applicationContext, "$parent.getItemAtPosition(position)", Toast.LENGTH_LONG)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_belajar_spinner)

        val spinner = findViewById<Spinner>(R.id.planets_spinner)

        val adapter = ArrayAdapter.createFromResource(this, R.array.planets_array,
                android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this


        // cara II

        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        val list = mutableListOf<String>("AC Milan", "Real Madrid", "Chelsea")
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, list)
        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(applicationContext, "$parent.getItemAtPosition(position)", Toast.LENGTH_LONG)
            }

        }

    }
}
