package com.example.toswod.presentation.recipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.toswod.databinding.FragmentRecipesListBinding
import com.example.toswod.domain.entity.Features
import com.example.toswod.domain.entity.RecipesData

//import androidx.fragment.app.viewModels
//import com.example.todolist_swod.R
//import com.example.todolist_swod.databinding.ListItemRezepteBinding

class RecipesListFragment : Fragment() {

   // private  val viewModel: RezepteListViewModel by viewModels()
   private lateinit var features: Features

    private var _binding: FragmentRecipesListBinding? = null
    private val binding: FragmentRecipesListBinding
        get() = _binding ?: throw RuntimeException("FragmentRecipesListBinding == null")

    private lateinit var recipe: RecipesData
    private lateinit var titleField: EditText
    private lateinit var ingredientsField: EditText
    private lateinit var dateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()

    }

    // В функции onCreateView(...) мы явно заполняем представление фрагмента, вы-
    //зывая LayoutInflater.inflate(...) с передачей идентификатора ресурса макета
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecipesListBinding.inflate(inflater, container, false)
        return binding.root

    }

    // добавление слушателя в обратном вызове onStart() В функции onTextChanged(...)
    // мы вызываем toString() для объекта CharSequence, представляющего ввод
    // пользователя. Эта функция возвращает строку, которая затем используется для
    // задания заголовка Rezepte



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun parseArgs(){
        features = requireArguments().getSerializable(KEY_FEATURES) as Features

    }

    companion object {

        private const val KEY_FEATURES = "feature"

        fun newInstance(features: Features): RecipesListFragment {
            return RecipesListFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(KEY_FEATURES, features)
                }
            }
        }
    }
}