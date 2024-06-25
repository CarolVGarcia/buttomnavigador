package com.example.appmenubuttom92

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AlertDialog


class ListaFragment : Fragment() {

    private lateinit var listView: ListView
    private lateinit var arrayList: ArrayList<String>
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_lista, container, false)
        listView = view.findViewById(R.id.lstAlumnos)

        val items = resources.getStringArray(R.array.alumnos)

        arrayList = java.util.ArrayList()
        arrayList.addAll(items)

        adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, arrayList)

        listView.adapter = adapter

        listView.setOnItemClickListener({parent, view, position, id ->
            var alumno:String = parent.getItemIdAtPosition(position).toString()
            var builder = AlertDialog.Builder(requireContext())

            builder.setTitle("Lista de alumnos")
            builder.setMessage(position.toString() + ":" + alumno)
            builder.setPositiveButton("OK"){ dialog, which ->

            }

        })

        return view
    }

}