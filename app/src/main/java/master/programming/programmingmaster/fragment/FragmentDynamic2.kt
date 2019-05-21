package master.programming.programmingmaster.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import master.programming.programmingmaster.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER



class FragmentDynamic2 : Fragment() {
    // TODO: Rename and change types of parameters

    fun newInstance(): FragmentDynamic2 {
        return FragmentDynamic2()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_fragment_dynamic2, container, false)


        return rootView
    }




}
