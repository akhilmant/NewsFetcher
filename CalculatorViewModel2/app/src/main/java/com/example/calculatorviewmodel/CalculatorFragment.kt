package com.example.calculatorviewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.calculatorviewmodel.databinding.FragmentCalculatorBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
class CalculatorFragment : Fragment() {
private lateinit var binding:FragmentCalculatorBinding
private lateinit var viewModel:CalcFragViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_calculator,container,false)
        viewModel=ViewModelProvider(this).get(CalcFragViewModel::class.java)
        binding.zeroButton.setOnClickListener {
            viewModel.addText("0")
        }
        binding.oneButton.setOnClickListener {
            viewModel.addText("1")
        }
        binding.twoButton.setOnClickListener {
            viewModel.addText("2")
        }
        binding.threeButton.setOnClickListener {
            viewModel.addText("3")
        }
        binding.fourButton.setOnClickListener {
            viewModel.addText("4")
        }
        binding.fiveButton.setOnClickListener {
            viewModel.addText("5")
        }
        binding.sixButton.setOnClickListener {
            viewModel.addText("6")
        }
        binding.sevenButton.setOnClickListener {
            viewModel.addText("7")
        }
        binding.eightButton.setOnClickListener {
            viewModel.addText("8")
        }
        binding.nineButton.setOnClickListener {
            viewModel.addText("9")
        }
        binding.pointButton.setOnClickListener {
            viewModel.addText(".")
        }
        binding.acButton.setOnClickListener {
            viewModel.clear()
        }
        binding.plusButton.setOnClickListener {
            viewModel.expression("+")
        }
        binding.minusButton.setOnClickListener {
            viewModel.expression("-")
        }
        binding.mulButton.setOnClickListener {
            viewModel.expression("*")
        }
        binding.divButton.setOnClickListener {
            viewModel.expression("/")
        }


        binding.equalsButton.setOnClickListener {
            viewModel.calc()
        }

        viewModel.editTextThing.observe(viewLifecycleOwner, Observer {
            binding.editTextNumberDecimal2.text=viewModel.editTextThing.value
        })

        return binding.root
    }
}