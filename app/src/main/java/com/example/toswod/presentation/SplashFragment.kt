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
import com.example.toswod.databinding.FragmentSplashBinding
import com.example.toswod.domain.entity.Features


class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding: FragmentSplashBinding
        get() = _binding ?: throw RuntimeException("FragmentSplashBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ibGetPhoto.setOnClickListener{
            launchMainFragment()
        }
        binding.ibGetPass.setOnClickListener{
          launchMFragment(Features.PASSWORDS)
        }
        binding.ibGetSpeak .setOnClickListener{
            launchMainFragment()
        }
        binding.ibGetText .setOnClickListener{
            launchMainFragment()
        }
    }

    // cдесь эта функция для тестирования выбора в будущем диалогов
    private fun launchMFragment(features: Features) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, when (features.toString()) {
               "VIDEO24" -> V24Fragment.newInstance(features)
                "PASSWORDS"  ->  PasswordsFragment.newInstance(features)
                "RECIPES" -> RecipesListFragment.newInstance(features)
                "TODO" -> TodoListFragment.newInstance(features)
                else -> TodoListFragment.newInstance(features)
            })
            .addToBackStack(null)
            .commit()
    }

    private fun launchMainFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, MainFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}