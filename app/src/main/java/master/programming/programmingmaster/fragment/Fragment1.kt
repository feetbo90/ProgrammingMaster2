package master.programming.programmingmaster.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup

import master.programming.programmingmaster.R
import android.widget.TextView
import android.widget.Toast


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER



class Fragment1 : Fragment() {
    // TODO: Rename and change types of parameters

    private val YES = 0
    private val NO = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_fragment1, container, false)
        val radioGroup = rootView.findViewById<RadioGroup>(R.id.radio_group)
        val button1 = rootView.findViewById<Button>(R.id.button)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = radioGroup.checkedRadioButtonId
            Toast.makeText(activity!!.applicationContext, "halo dari radio $radioButton", Toast.LENGTH_LONG).show()
            val textView = rootView.findViewById<TextView>(R.id.textFragment)
            when (radioButton) {
                YES // User chose "Yes."
                -> textView.setText(R.string.yes_message)
                NO // User chose "No."
                -> textView.setText(R.string.no_message)
                else // No choice made.
                -> {
                }
            }// Do nothing.
        }
        button1.setOnClickListener {
            Toast.makeText(activity!!.applicationContext, "halo dari button", Toast.LENGTH_LONG).show()
        }


        return rootView
    }




}
