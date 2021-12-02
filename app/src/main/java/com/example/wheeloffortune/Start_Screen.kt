package com.example.wheeloffortune

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class Start_Screen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_start_screen, container, false)
        val nextBtn : Button = view.findViewById(R.id.start)
        nextBtn.setOnClickListener {
            val fragment = Game_Fragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nac_container,fragment)?.commit()
        }
        return view

    }

}
