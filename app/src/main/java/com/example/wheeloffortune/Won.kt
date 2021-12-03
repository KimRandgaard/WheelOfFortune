package com.example.wheeloffortune

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.wheeloffortune.databinding.FragmentLoseBinding
import com.example.wheeloffortune.databinding.FragmentWonBinding

class Won : Fragment() {

    private var _binding: FragmentWonBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWonBinding.inflate(inflater,container,false)
        val root : View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.startAgain.setOnClickListener {

            findNavController().navigate(R.id.action_won_to_start_Screen)
        }

    }

}