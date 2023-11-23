package com.example.refrigerator

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.refrigerator.databinding.ActivityAddBinding
import java.util.Calendar


class AddActivity : AppCompatActivity() {

    var refrigeratorFloor = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.enddatebtn.setOnClickListener{
            val cal = Calendar.getInstance()
            val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                binding.enddatebtn.text = "${year}년 ${month+1}월 ${dayOfMonth}일"
            }
            DatePickerDialog(this , dateSetListener, cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(
                Calendar.DAY_OF_MONTH)).show()
        }

        binding.checkboxLeft.setOnClickListener {
            if(binding.checkboxLeft.isChecked){}
        }

        binding.checkboxRight.setOnClickListener {
            if(binding.checkboxRight.isChecked){}
        }

        binding.chipgroup.setOnClickListener(View.OnClickListener {
            when(binding.chipgroup.checkedChipId) {
                R.id.Chip1 -> refrigeratorFloor = 1
                R.id.Chip2 -> refrigeratorFloor = 2
                R.id.Chip3 -> refrigeratorFloor = 3
                R.id.Chip4 -> refrigeratorFloor = 4
            }
        })

    }
}