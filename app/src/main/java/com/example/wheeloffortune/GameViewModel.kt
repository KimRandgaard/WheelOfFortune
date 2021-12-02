package com.example.wheeloffortune

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.wheeloffortune.data.GameConstants

class GameViewModel : ViewModel() {

    private var input = ""
    val getWords = GameConstants.words

    private val _words = MutableLiveData<String>()
    val words : LiveData<String> = _words

    fun generateWord(){
        var generate = getWords.random()

        _words.value = generate.words.random()
    }


    fun generateUnderscores(): String {
        val sb = StringBuilder()
        words.value?.forEach { char ->
            if (char == '/') {
                sb.append(' ')
            } else {
                if (input.contains(char,ignoreCase = true)){
                    sb.append(char)
                }else{
                    sb.append("_")
                }
            }
        }

        return sb.toString()
    }

    fun checkLetter(Letter : String){
        var inputLetter = Letter
        input += inputLetter
        var wordToGuess = words.value

        var letterInWord = wordToGuess?.contains(
            inputLetter.toCharArray().first()
        ,ignoreCase = true
        )

        val letterCount = wordToGuess?.count{
            Letter.contains(it)
        }

        if (letterInWord!!){
            var point = letterCount!!*100
            }
    }


}