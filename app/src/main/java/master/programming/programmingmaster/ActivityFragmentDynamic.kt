package master.programming.programmingmaster

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fragment_dynamic.*
import master.programming.programmingmaster.fragment.FragmentDynamic
import master.programming.programmingmaster.fragment.FragmentDynamic2

class ActivityFragmentDynamic : AppCompatActivity() {

    private var isFragmentDisplayed = false

    private val STATE_FRAGMENT = "state_of_fragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_dynamic)

        if (savedInstanceState != null) {
            isFragmentDisplayed =
                    savedInstanceState.getBoolean(STATE_FRAGMENT)
            if (isFragmentDisplayed) {
                // If the fragment is displayed, change button to "close".
                button.setText(R.string.close)
            }
        }

        button.setOnClickListener {
            if (!isFragmentDisplayed) {
                displayFragment()
            } else {
                closeFragment()
            }
        }

        replace.setOnClickListener {
            replaceFragment()
        }
    }

    private fun displayFragment() {

        val fragmentDynamic = FragmentDynamic().newInstance()
        val fragmentManage = supportFragmentManager
        val fragmentTransaksi = fragmentManage.beginTransaction()

        fragmentTransaksi.add(R.id.fragment_container, fragmentDynamic).addToBackStack(null).commit()
        button.setText(R.string.close)
        isFragmentDisplayed = true
    }

    private fun replaceFragment() {
        val fragmentManage = supportFragmentManager
        val fragmentDynamic2 = FragmentDynamic2().newInstance()
        //val fragmentDynamic = FragmentDynamic().newInstance()
        //val fragmentDynamic = fragmentManage
               // .findFragmentById(R.id.fragment_container) as FragmentDynamic2

        val fragmentTransaksi = fragmentManage.beginTransaction()
        fragmentTransaksi.replace(R.id.fragment_container,fragmentDynamic2).addToBackStack(null).commit()

    }

    private fun closeFragment() {
        val fragmentManage = supportFragmentManager
                //val fragmentDynamic = FragmentDynamic().newInstance()
        val fragmentDynamic = fragmentManage
                .findFragmentById(R.id.fragment_container) as FragmentDynamic


        val fragmentTransaksi = fragmentManage.beginTransaction()
        fragmentTransaksi.remove(fragmentDynamic).commit()
        button.setText(R.string.open)
        isFragmentDisplayed = false
    }

    public override fun onSaveInstanceState(savedInstanceState: Bundle) {
        // Save the state of the fragment (true=open, false=closed).
        savedInstanceState.putBoolean(STATE_FRAGMENT, isFragmentDisplayed)
        super.onSaveInstanceState(savedInstanceState)
    }
}
