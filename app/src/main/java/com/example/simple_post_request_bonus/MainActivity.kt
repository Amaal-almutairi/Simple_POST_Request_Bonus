package com.example.simple_post_request_bonus

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {
    lateinit var edname:EditText
    lateinit var btnsubmit:Button
   var name=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edname = findViewById(R.id.edname)
        btnsubmit = findViewById(R.id.btnsubmit)
        btnsubmit.setOnClickListener {
            name=edname.text.toString()
            if (name.isNotEmpty()){
                postAllusers()
            }
        }
    }

    fun postAllusers(){
       val api=APIClint().getClient()?.create(APIInterface::class.java)
        val processDialog=ProgressDialog(this)
        processDialog.setMessage("please wait")
        processDialog.show()
        if (api != null){
            api.postAllusers(Users(name,0)).enqueue(object :Callback<Users?>{
                override fun onResponse(call: Call<Users?>, response: Response<Users?>) {
                    processDialog.dismiss()
                }

                override fun onFailure(call: Call<Users?>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
                    processDialog.dismiss()
                }

            })
        }

    }
}