package com.example.android.guesstheword.screens.game

import android.os.CountDownTimer
import android.text.format.DateUtils
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    companion object {
        // These represent different important times
        // This is when the game is over
        const val DONE = 0L

        // This is the number of milliseconds in a second
        const val ONE_SECOND = 1000L

        // This is the total time of the game
        const val COUNTDOWN_TIME = 60000L
    }

    // The current word
    private val _word = MutableLiveData<String>()
    val word: LiveData<String>
        get() = _word

    // The current score
    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>

    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish: LiveData<Boolean>
        get() = _eventGameFinish

    private val timer: CountDownTimer

    private val _timerString = MutableLiveData<Long>()
    val timerString: LiveData<Long>
        get() = _timerString

//    private val _timerFinished = MutableLiveData<Boolean>()
//    val timerFinished: LiveData<Boolean>
//        get() = _timerFinished

    init {
        Log.i("GameViewModel", "GameViewModel created")
        _eventGameFinish.value = false
//        _timerFinished.value = true
        resetList()
        nextWord()
        _score.value = 0
        _word.value = wordList.removeAt(0)

        timer = object : CountDownTimer(COUNTDOWN_TIME, ONE_SECOND) {
            override fun onTick(millisUntilFinished: Long) {
//                Log.i("GameTimer", "millisUntilFinished = " + millisUntilFinished)
//                Log.i("GameTimer", DateUtils.formatElapsedTime(millisUntilFinished))
                _timerString.value = millisUntilFinished / ONE_SECOND
            }

            override fun onFinish() {
//                onTimerFinished()
                _timerString.value = DONE
                _eventGameFinish.value = true
            }
        }
        timer.start()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed")
        timer.cancel()
    }

    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )
        wordList.shuffle()
    }

    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        //Select and remove a word from the list
        if (wordList.isEmpty()) {
            //reset the words list
            resetList()
        }
//            _eventGameFinish.value = true
//        } else {
        _word.value = wordList.removeAt(0)
//        }
    }

    fun onSkip() {
        _score.value = (score.value)?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        _score.value = (score.value)?.plus(1)
        nextWord()
    }

    fun onGameFinishComplete() {
        _eventGameFinish.value = false
    }

//    fun onTimerFinished() {
//        _timerFinished.value = true
//    }
}