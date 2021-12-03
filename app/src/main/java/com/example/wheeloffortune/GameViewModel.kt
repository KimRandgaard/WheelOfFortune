package com.example.wheeloffortune

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.wheeloffortune.data.GameConstants

class GameViewModel : ViewModel() {

    private var input = ""
    val getWords = GameConstants.words

    var points = 0
    var life = 5

    var updatePoints = 0
    var guesedLetters = mutableListOf<Char>()


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
            Letter.lowercase().contains(it.lowercase())
        }

        if (letterInWord!!){
            points += letterCount!!*updatePoints
            }else{
                life -= 1
            }
    }

    fun spinWheel() {
        updatePoints = listOf<Int>(0,100,250,500,1000,1500).random()
    }

    fun sameLetterUsed(Letter: String): Boolean {

        var sameLetter = false
        if (guesedLetters.contains(Letter.lowercase().single())){
            sameLetter = true
        }
        guesedLetters.add(Letter.lowercase().single())
        return sameLetter
    }

    fun gameWon(): Boolean{
       var allLetters = words.value?.lowercase()?.toList()
       if(guesedLetters.containsAll(allLetters!!)){
           return true
       } else{
           return false
       }
    }

    fun gameLost(): Boolean{
        if(life <= 0){
            return true
        } else{
            return false
        }
    }


}