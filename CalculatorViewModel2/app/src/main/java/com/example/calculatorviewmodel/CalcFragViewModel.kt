package com.example.calculatorviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalcFragViewModel:ViewModel() {
    val editTextThing = MutableLiveData<String>("0")
    var operator = ""
    var resultText = ""

    fun addText(textValue:String) {
        if(editTextThing.value=="0"){
            editTextThing.value=textValue
        }
        else{
            editTextThing.value+=textValue
        }
    }

    fun clear(){
        editTextThing.value = "0"
    }



    fun expression(x:String){
        operator=x
        resultText= editTextThing.value.toString()
        editTextThing.value="0"
    }

    fun calc(){
        var temp = mutableListOf<String>(resultText,editTextThing.value.toString())
        var ans = 0.0
        if (operator=="+"){
            ans = temp[0].toDouble() + temp[1].toDouble()
            editTextThing.value=ans.toString()
        }
        else if(operator=="-"){
            ans = temp[0].toDouble() - temp[1].toDouble()
            editTextThing.value=ans.toString()
        }
        else if(operator=="*"){
            ans = temp[0].toDouble() * temp[1].toDouble()
            editTextThing.value=ans.toString()
        }
        else if(operator=="/"){
            ans = temp[0].toDouble() / temp[1].toDouble()
            editTextThing.value=ans.toString()
        }
        else if(operator=="%"){
            ans = temp[0].toDouble() % temp[1].toDouble()
            editTextThing.value=ans.toString()
        }
    }

}