package com.example.kotlin_room_old.fragments.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_room_old.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_list, container, false)

        val fab = view.findViewById<RecyclerView>(R.id.recyclerView)

        val a : View = "a"


        fab.addView("a")

        fab.setOnClickListener {
             findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        return view
    }


}