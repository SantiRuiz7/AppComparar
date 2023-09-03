package com.example.primerapp.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.primerapp.model.ComparisonResult


class MainCompareViewModel : ViewModel() {
    private val _compare = MutableLiveData<ComparisonResult>()
    val compare: LiveData<ComparisonResult> = _compare

    fun compareStrings(firstInput: String, secondInput: String) {
        val areEqual = firstInput == secondInput
        val result = ComparisonResult(firstInput, secondInput, areEqual)
        _compare.value = result
    }
}
