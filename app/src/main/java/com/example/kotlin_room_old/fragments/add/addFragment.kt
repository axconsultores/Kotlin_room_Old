package com.example.kotlin_room_old.fragments.add

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContentProviderCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.kotlin_room_old.R
import com.example.kotlin_room_old.data.users.User
import com.example.kotlin_room_old.data.users.UserViewModel
import com.google.android.material.snackbar.Snackbar

class AddFragment : Fragment() {

     lateinit var mUserViewModel: UserViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_add, container, false)

        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        val fab = view.findViewById<Button>(R.id.buttonAdd)

        fab.setOnClickListener {

            insertDatatoDatabase(view)
        }

        return view
    }

    private fun insertDatatoDatabase(view: View) {


        var fab = view.findViewById<EditText>(R.id.editTextTextPersonaName)
        val firstName =  fab.text.toString()

        fab = view.findViewById<EditText>(R.id.editTextTextPersonaName2)
        val lastName =  fab.text.toString()

        fab = view.findViewById<EditText>(R.id.editTextNumero)
        val age =  fab.text.toString()

        val user = User(0,firstName,lastName,Integer.parseInt(age))


        mUserViewModel.addUser(user)

        Snackbar.make(view, "Insertado", Snackbar.LENGTH_LONG).show()



        findNavController().navigate(R.id.action_addFragment_to_listFragment)

    }



}


