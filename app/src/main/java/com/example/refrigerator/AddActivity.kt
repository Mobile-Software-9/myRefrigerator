package com.example.refrigerator

import android.app.AlarmManager
import android.app.DatePickerDialog
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.refrigerator.databinding.ActivityAddBinding
import java.util.Calendar

class AddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBinding
    private var endyear = 0
    private var endmonth = 0
    private var endday = 0
    private var where = ""
    val NOTIFICATION_ID = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val currentDate = Calendar.getInstance()
        var startyear = currentDate.get(Calendar.YEAR)
        var startmonth =  currentDate.get(Calendar.MONTH) + 1
        var startday =  currentDate.get(Calendar.DAY_OF_MONTH)

        binding.foodname.text = intent.getStringExtra("food")

        binding.startdatebtn.text = "${startyear}년 ${startmonth}월 ${startday}일"

        binding.enddatebtn.setOnClickListener {
            val cal = Calendar.getInstance()
            val dateSetListener =
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    binding.enddatebtn.text = "${year}년 ${month + 1}월 ${dayOfMonth}일"
                    endyear = year
                    endmonth = month + 1
                    endday = dayOfMonth
                }
            DatePickerDialog(
                this, dateSetListener, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(
                    Calendar.DAY_OF_MONTH
                )
            ).show()
        }

        binding.checkboxLeft.setOnClickListener {
            if (binding.checkboxLeft.isChecked) {
                where = binding.checkboxLeft.text.toString()
            }
        }

        binding.checkboxRight.setOnClickListener {
            if (binding.checkboxRight.isChecked) {
                where = binding.checkboxRight.text.toString()
            }
        }

        binding.addbtn.setOnClickListener {

            val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
            var intent = Intent(this,FoodEndDateReceiver::class.java)
            intent.putExtra("food",binding.foodname.text.toString())
            val pendingIntent = PendingIntent.getBroadcast(
                this, NOTIFICATION_ID, intent,
                PendingIntent.FLAG_IMMUTABLE
            )

            val calendar = Calendar.getInstance().apply {
                timeInMillis = System.currentTimeMillis()
                set(Calendar.YEAR, endyear)
                set(Calendar.MONTH, endmonth)
                set(Calendar.DAY_OF_MONTH, endday - 2)
                set(Calendar.HOUR_OF_DAY, 10)
                set(Calendar.MINUTE, 0)
                set(Calendar.SECOND, 0)
            }

            alarmManager. set(
                AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis,
                pendingIntent)

            intent = Intent(this, MyFoodInfoActivity::class.java) //메인으로 수정필요
            startActivity(intent)
        }

    }
}