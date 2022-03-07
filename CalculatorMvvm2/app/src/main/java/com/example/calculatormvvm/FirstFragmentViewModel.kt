package com.example.calculatormvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirstFragmentViewModel:ViewModel() {
    val answer=MutableLiveData<String>()
    var res=""
    var exp=""
    init {
        answer.value=""
    }
    fun addText(string: String) {
        if(answer.value=="0"){
            answer.value=string
        }
        else{
            answer.value+=string
        }
    }
    fun onClear() {
        answer.value="0"
    }
fun operator(string:String){
    exp=string
    res=answer.value.toString()
    Log.i("some",res)
        answer.value="0"

}
    fun onEqualsClicked() {
        var temp = mutableListOf<String>(res, answer.value.toString())
        var ans = 0.0
        for (i in temp) {
            if (exp == "+") {
                Log.i("someeee", "${answer.value.toString()},$res,$temp")
                ans = i.toDouble() + i.toDouble()
                answer.value = ans.toString()
            } else if (exp == "-") {
                ans = i.toDouble() - i.toDouble()
                answer.value = ans.toString()
            } else if (exp == "*") {
                ans = i.toDouble() * i.toDouble()
                answer.value = ans.toString()
            } else if (exp == "/") {
                ans = i.toDouble() / i.toDouble()
                answer.value = ans.toString()
            } else if (exp == "%") {
                ans = i.toDouble() % i.toDouble()
                answer.value = ans.toString()
            }
        }
    }

    }
