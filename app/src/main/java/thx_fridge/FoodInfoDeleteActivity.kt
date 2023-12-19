package thx_fridge

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.refrigerator.FoodCategoryActivity
import com.example.refrigerator.databinding.ActivityFoodInfoDeleteBinding
import issuedeash.MainActivity


class FoodInfoDeleteActivity : AppCompatActivity() {
    val binding: ActivityFoodInfoDeleteBinding by lazy {
        ActivityFoodInfoDeleteBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun foodDeleteAlert(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        AlertDialog.Builder(this).run{
            setTitle("삭제")
            setMessage("정말 삭제하시겠습니까?")
            //setPositiveButton("Yes", {_, _-> Log.d("knh", "삭제")})
            setPositiveButton("Yes"){_, _->
                Log.d("Delete Confirmed", "삭제")
                startActivity(intent)
                //binding.result.text = "삭제되었습니다."
            }
            setNegativeButton("No", null)
            show()
        }
    }

}

