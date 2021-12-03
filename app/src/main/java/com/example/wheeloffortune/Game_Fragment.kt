package com.example.wheeloffortune

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.wheeloffortune.adapter.Adapter
import com.example.wheeloffortune.databinding.FragmentGameBinding

class Game_Fragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    private val GameViewModel: GameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        GameViewModel.generateWord()
        binding.apply {

            wordtoguess.text = GameViewModel.generateUnderscores()
        }

        binding.Guess.setOnClickListener {
            if (!GameViewModel.sameLetterUsed(Letter = binding.inputGuess.text.toString())) {

                GameViewModel.checkLetter(Letter = binding.inputGuess.text.toString())

                binding.wordtoguess.text = GameViewModel.generateUnderscores()

                uiUpdate()
            }
        }

        binding.SpinWheel.setOnClickListener {
            GameViewModel.spinWheel()
            uiUpdate()

        }

        binding.currentLife


    }


    fun uiUpdate() {

        binding.apply {

            currentLife.text = GameViewModel.life.toString()

            currentPoints.text = GameViewModel.points.toString()

            wordtoguess

            wheelPoints.text = GameViewModel.updatePoints.toString()

            binding.usedLetters.adapter = Adapter(requireContext(), GameViewModel.guesedLetters)

        }

        if (GameViewModel.gameWon()) {

            findNavController().navigate(R.id.action_game_Fragment_to_won)

        }

        if (GameViewModel.gameLost()) {

            findNavController().navigate(R.id.action_game_Fragment_to_lose)
        }

    }
}