package master.programming.programmingmaster

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.penjumlahan.*
import master.programming.programmingmaster.model.Buah
import master.programming.programmingmaster.network.RestClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    //private var bilSatu: Int = 0
    //private var bilDua: Int = 02-tony-stark-caio-caldas.jpg
    private var has: Int = 0
    private var bool: Boolean = true
    private var username: String = ""
    private var pass: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.penjumlahan)

        val intent = intent!!.extras




        username = intent!!.getString("username", "")
        pass = intent.getString("password", "")

        Toast.makeText(applicationContext, "ini username : $username", Toast.LENGTH_LONG).show()

        jumlah.setOnClickListener {
            bool = cekKosongTidak(bilanganSatu.text.toString(), bilanganDua.text.toString())
            if (bool) {

                has = penjumlahan(bilanganSatu.text.toString(), bilanganDua.text.toString())
                hasil.setText("$has")

            }
        }

        button2.setOnClickListener {
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            finish()
        }
    }

    private fun penjumlahan(bilSatu: String, bilDua: String) = bilSatu.toInt() + bilDua.toInt()

    private fun cekKosongTidak(bilSatu: String, bilDua: String): Boolean {
        if (bilSatu.isNotEmpty() && bilDua.isNotEmpty()) {
            return true
        }
        return false
    }
}
