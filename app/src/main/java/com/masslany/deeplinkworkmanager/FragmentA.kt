package com.masslany.deeplinkworkmanager

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class FragmentA : Fragment(R.layout.fragment_a_layout) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = "XDD"

        val btn = view.findViewById<Button>(R.id.button)

        btn.setOnClickListener {
            findNavController().navigate("xbc://details/$id".toUri())
        }


    }
}