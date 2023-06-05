package com.example.toswod.presentation.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.toswod.databinding.FragmentTodoListBinding
import com.example.toswod.domain.entity.Features


class TodoListFragment : Fragment() {

    private lateinit var features: Features

    private var _binding: FragmentTodoListBinding? = null
    private val binding: FragmentTodoListBinding
        get() = _binding ?: throw RuntimeException("FragmentTodoListBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTodoListBinding.inflate(inflater, container, false)
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

        fun newInstance(features: Features): TodoListFragment {
            return TodoListFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(KEY_FEATURES, features)
                }
            }
        }
    }
}