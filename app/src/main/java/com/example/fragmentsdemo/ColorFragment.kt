package com.example.fragmentsdemo

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner

class ColorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color, container, false)
    }


    override fun onViewCreated(v: View, savedInstanceState: Bundle?) {
        v.apply {
            findViewById<Spinner>(R.id.spinner).apply {
                adapter = ArrayAdapter(
                    this.context, android.R.layout.simple_spinner_dropdown_item,
                    arrayOf("Red", "Green", "Blue"))
                onItemSelectedListener = object : OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        parent?.run {
                            v.setBackgroundColor(Color.parseColor(getItemAtPosition(position).toString()))
                        }
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }

                }
            }
        }
    }
}