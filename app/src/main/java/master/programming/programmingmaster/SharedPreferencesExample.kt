package master.programming.programmingmaster

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shared_preferences_example.*

class SharedPreferencesExample : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences_example)

        val sharedPref = applicationContext.getSharedPreferences(SharedPref.login, Context.MODE_PRIVATE) ?: return
        with(sharedPref.edit()){
            putString(SharedPref.username, "Iqbal").apply()
            putString(SharedPref.password, "blabla").apply()
        }

        val username = sharedPref.getString(SharedPref.username, SharedPref.defValueString)
        Toast.makeText(applicationContext, "ini username : $username", Toast.LENGTH_LONG).show()

        button.setOnClickListener {
            sharedPref.edit().remove(SharedPref.username).apply()
        }
        //sharedPref.edit().putString(SharedPref.username, "Iqbal").apply()
        //sharedPref.edit().putString(SharedPref.password, "blabla").apply()
    }
}
