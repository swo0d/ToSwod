package com.example.toswod.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.toswod.presentation.passwords.PasswordsFragment
import com.example.toswod.presentation.recipes.RecipesListFragment
import com.example.toswod.presentation.todo.TodoListFragment
import com.example.toswod.presentation.v24.V24Fragment
import com.example.toswod.R
import com.example.toswod.databinding.FragmentMainBinding
import com.example.toswod.domain.entity.Features

class MainFragment: Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding ?: throw RuntimeException("FragmentMainBinding == null")

    private lateinit var features: Features

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tV24.setOnClickListener{
            launchMFragment(Features.VIDEO24)
        }
        binding.tPassword.setOnClickListener{
            launchMFragment(Features.PASSWORDS)
        }
        binding.tTodoList.setOnClickListener{
            launchMFragment(Features.TODO)
        }
        binding.tEda.setOnClickListener{
            launchMFragment(Features.RECIPES)
        }
    }

    private fun launchMFragment(features: Features) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container,
                when (features.toString()) {
                "VIDEO24" -> V24Fragment.newInstance(features)
                "PASSWORDS"  ->  PasswordsFragment.newInstance(features)
                "RECIPES" -> RecipesListFragment.newInstance(features)
                "TODO" -> TodoListFragment.newInstance(features)
                else -> TodoListFragment.newInstance(features)
            })
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }
}