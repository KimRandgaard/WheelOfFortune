package com.example.wheeloffortune

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.wheeloffortune.databinding.FragmentGameBinding
import com.example.wheeloffortune.databinding.FragmentLoseBinding


class Lose : Fragment() {

    private var _binding: FragmentLoseBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoseBinding.inflate(inflater,container,false)
        val root : View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.startAgain.setOnClickListener {

            findNavController().navigate(R.id.action_lose_to_start_Screen)
        }

    }


}