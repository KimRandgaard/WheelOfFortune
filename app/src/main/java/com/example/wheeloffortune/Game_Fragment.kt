package com.example.wheeloffortune

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.wheeloffortune.databinding.FragmentGameBinding

class Game_Fragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get()=_binding!!
    private val GameViewModel : GameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGameBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        GameViewModel.generateWord()
        binding.apply {

            wordtoguess.text = GameViewModel.generateUnderscores()
        }

        binding.Guess.setOnClickListener {
            GameViewModel.checkLetter(Letter = binding.inputGuess.text.toString())

            binding.wordtoguess.text = GameViewModel.generateUnderscores()

        }

    }

}