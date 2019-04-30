package master.programming.programmingmaster

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.penjumlahan.*

class MainActivity : AppCompatActivity() {

    private var bilSatu : Int = 0
    private var bilDua : Int = 0
    private var has : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.penjumlahan)


        jumlah.setOnClickListener {
            bilSatu = bilanganSatu.text.toString().toInt()
            bilDua = bilanganDua.text.toString().toInt()
            has = bilSatu + bilDua
            hasil.setText("$has")
        }


    }
}
