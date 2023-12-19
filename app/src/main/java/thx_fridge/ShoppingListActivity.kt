package thx_fridge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.refrigerator.R

class ShoppingListActivity : AppCompatActivity() {

    private val list = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_list)
        val recyclerView  :RecyclerView = findViewById(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        val adapter = ShopAdapter(list)
        recyclerView.adapter = adapter

        val btn_add:Button = findViewById(R.id.btn_add)
        val et_add:EditText = findViewById(R.id.et_add)


        btn_add.setOnClickListener{
            val name = et_add.text.toString()
            list.add(name)
            Log.d("knh", "list: $list")
            adapter.notifyDataSetChanged()
        }


    }
}