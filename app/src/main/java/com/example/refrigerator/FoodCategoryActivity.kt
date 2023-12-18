package com.example.refrigerator

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.refrigerator.databinding.ActivityAddBinding
import com.example.refrigerator.databinding.ActivityFoodcategoryBinding


class FoodCategoryActivity : AppCompatActivity() {
    lateinit var category:Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFoodcategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.vegetable.setOnClickListener() {
            category = resources.getStringArray(R.array.vegetables)
            categoryDialog()
        }
        binding.fruit.setOnClickListener() {
            category = resources.getStringArray(R.array.fruits)
            categoryDialog()
        }
        binding.fish.setOnClickListener() {
            category = resources.getStringArray(R.array.fishes)
            categoryDialog()
        }
        binding.meat.setOnClickListener() {
            category = resources.getStringArray(R.array.meats)
            categoryDialog()
        }
        binding.egg.setOnClickListener() {
            category = resources.getStringArray(R.array.eggs)
            categoryDialog()
        }
        binding.sauce.setOnClickListener() {
            category = resources.getStringArray(R.array.sauces)
            categoryDialog()
        }
        binding.nut.setOnClickListener() {
            category = resources.getStringArray(R.array.nuts)
            categoryDialog()
        }
        binding.dairy.setOnClickListener() {
            category = resources.getStringArray(R.array.dairys)
            categoryDialog()
        }
        binding.frozenfood.setOnClickListener() {
            category = resources.getStringArray(R.array.frozenfoods)
            categoryDialog()
        }
        binding.food.setOnClickListener() {
            category = resources.getStringArray(R.array.foods)
            categoryDialog()
        }
        binding.bread.setOnClickListener() {
            category = resources.getStringArray(R.array.breads)
            categoryDialog()
        }
        binding.wheat.setOnClickListener() {
            category = resources.getStringArray(R.array.wheats)
            categoryDialog()
        }
        binding.dessert.setOnClickListener() {
            category = resources.getStringArray(R.array.desserts)
            categoryDialog()
        }
        binding.drink.setOnClickListener() {
            category = resources.getStringArray(R.array.drinks)
            categoryDialog()
        }
        binding.alcohol.setOnClickListener() {
            category = resources.getStringArray(R.array.alcohols)
            categoryDialog()
        }
        binding.other.setOnClickListener() {
            category = resources.getStringArray(R.array.others)
            categoryDialog()
        }
        
    }
    fun categoryDialog() {
        val intent = Intent(this, AddActivity::class.java)
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("재료를 선택해주세요")
        builder.setItems(category) { p0, p1 ->
            Log.e("cate", category[p1])
            intent.putExtra("food",category[p1])
            startActivity(intent)
//            startActivity(intent)
//            setResult(RESULT_OK,intent)
//            finish()
        }
        builder.setCancelable(true)
        val dialog = builder.create()
        dialog.show()


    }

}