package edu.temple.dicethrow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DieViewModel : ViewModel() {
    private val currentRoll : MutableLiveData<Int> by lazy {
        MutableLiveData()
    }
    fun getCurrentRoll(): LiveData<Int> {
        return currentRoll
    }
    fun setCurrentROll(roll: Int) {
        currentRoll.value = roll
    }
}