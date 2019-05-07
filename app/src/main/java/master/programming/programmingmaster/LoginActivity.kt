package master.programming.programmingmaster

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private var editUsername : String = ""
    private var editPassword : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login.setOnClickListener {
            editUsername = username.text.toString()
            editPassword = password.text.toString()

            if (checkLogin(editUsername,editPassword)) {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.putExtra("username", editUsername)
                intent.putExtra("password", editPassword)
                startActivity(intent)
            }
        }
    }

    private fun checkLogin(username : String, password : String) : Boolean =
            username == "admin" && password == ("admin")
}
