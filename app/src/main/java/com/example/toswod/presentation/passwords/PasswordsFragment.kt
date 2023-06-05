package com.example.toswod.presentation.passwords

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.toswod.databinding.FragmentPasswordsBinding
import com.example.toswod.domain.entity.Features

class PasswordsFragment : Fragment() {

    private lateinit var features: Features

    private var _binding: FragmentPasswordsBinding? = null
    private val binding: FragmentPasswordsBinding
        get() = _binding ?: throw RuntimeException("FragmentPasswordsBinding == null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPasswordsBinding.inflate(inflater, container, false)
        return binding.root
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

        fun newInstance(features: Features): PasswordsFragment {
            return PasswordsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(KEY_FEATURES, features)
                }
            }
        }
    }
}