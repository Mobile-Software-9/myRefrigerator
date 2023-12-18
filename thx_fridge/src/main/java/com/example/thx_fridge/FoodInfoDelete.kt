package com.example.thx_fridge

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.thx_fridge.databinding.ActivityFoodInfoBinding

class FoodInfoDelete : AppCompatActivity() {
    val binding: ActivityFoodInfoBinding by lazy {
        ActivityFoodInfoBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnMap: Button =  findViewById(R.id.btnMap);

        btnMap.setOnClickListener {
                val intent:Intent = Intent(this@FoodInfoDelete, ShoppingList::class.java)
                startActivity(intent)
        }

    }

    fun foodDeleteAlert(view: View) {
        AlertDialog.Builder(this).run{
            setTitle("삭제")
            setMessage("정말 삭제하시겠습니까?")
            //setPositiveButton("Yes", {_, _-> Log.d("knh", "삭제")})
            setPositiveButton("Yes"){_, _->
                Log.d("Delete Confirmed", "삭제")
                //binding.result.text = "삭제되었습니다."
            }
            setNegativeButton("No", null)
            show()
        }
    }

}


