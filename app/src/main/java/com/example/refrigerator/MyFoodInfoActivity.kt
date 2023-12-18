package com.example.refrigerator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.refrigerator.databinding.ActivityMyfoodinfoBinding

//drawer에서 음식클릭시 내가 저장한 정보보여주기
//테스트하기위한 페이지. 다른페이지연결후 이 페이지 삭제필요
class MyFoodInfoActivity : AppCompatActivity() {

//    private lateinit var db : AppDatabase
    lateinit var binding : ActivityMyfoodinfoBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyfoodinfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        db = AppDatabase.getInstance(this.applicationContext)!!
//        val name = intent.getStringExtra("name")   //이름넘어와야함
//        CoroutineScope(Dispatchers.IO).launch {
//            foodInfo = db.foodInfoDao().showInfo("감")      //showInfo(name) 으로 수정
//        }
//        binding.name.text = foodInfo.name
//        binding.count.text = foodInfo.count
//        binding.where.text = foodInfo.where
//        binding. enddatebtn.text = foodInfo.startDate
//        binding. enddatebtn.text = foodInfo.endDate




    }

}