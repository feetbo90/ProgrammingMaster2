package master.programming.programmingmaster

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import master.programming.programmingmaster.model.Buah
import master.programming.programmingmaster.network.RestClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BelajarSpinner : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private var nilaiPlanet : String? = ""

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }


    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(applicationContext, "${parent!!.getItemAtPosition(position)}", Toast.LENGTH_LONG).show()
        nilaiPlanet = parent.getItemAtPosition(position).toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_belajar_spinner)


        /*
           ambil data dengan retrofit

        */
        val getData = RestClient.DataRepository.creating()
        getData.ambilData().enqueue(object : Callback<Buah> {
            override fun onFailure(call: Call<Buah>, t: Throwable) {

            }

            override fun onResponse(call: Call<Buah>, response: Response<Buah>) {
                val data = response.body()
                //Toast.makeText(applicationContext, data!!.fruit, Toast.LENGTH_LONG).show()
                Log.d("ini data ", ""+data!!.fruit)
            }

        })







        val spinner = findViewById<Spinner>(R.id.planets_spinner)

        val adapter = ArrayAdapter.createFromResource(this, R.array.planets_array,
                android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this


        // cara II

        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        val list = mutableListOf("AC Milan", "Real Madrid", "Chelsea")
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, list)
        spinner2.adapter = arrayAdapter
        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(applicationContext, "${parent!!.getItemAtPosition(position)}", Toast.LENGTH_LONG).show()
            }

        }

    }
}
