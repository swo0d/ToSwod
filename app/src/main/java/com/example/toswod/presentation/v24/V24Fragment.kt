package com.example.toswod.presentation.v24

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.toswod.R
import com.example.toswod.databinding.FragmentV24Binding
import com.example.toswod.domain.entity.Features
import com.example.toswod.domain.entity.V24Data
import com.example.toswod.presentation.MainFragment
import com.example.toswod.presentation.passwords.PasswordsFragment
import java.util.*


class V24Fragment : Fragment() {

    private lateinit var features: Features
    private lateinit var titleEvent: EditText
    private lateinit var v24data: V24Data
    private lateinit var eventDateButton: Button


    private var _binding: FragmentV24Binding? = null
    private val binding: FragmentV24Binding
        get() = _binding ?: throw RuntimeException("FragmentV24Binding == null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        v24data = V24Data()
        parseArgs()


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentV24Binding.inflate(inflater, container, false)
       //titleEvent
      // eventDateButton.
      //  eventDateButton.apply {
       //     text = v24data.dateV24.toString()
      //      isEnabled = false
       // }
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val titleWatcher = object  : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // это пространство оставлено пустым специально
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                v24data.v24Title = p0.toString()
            }

            override fun afterTextChanged(p0: Editable?) {
                // и это
            }
        }
        //titleEvent.addTextChangedListener(titleWatcher)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun parseArgs(){
        features = requireArguments().getSerializable(KEY_FEATURES) as Features

   }

   companion object {

       private const val KEY_FEATURES = "feature"

       fun newInstance(features: Features): V24Fragment {
           return V24Fragment().apply {
               arguments = Bundle().apply {
                   putSerializable(KEY_FEATURES, features)
               }
           }
       }


   }



}