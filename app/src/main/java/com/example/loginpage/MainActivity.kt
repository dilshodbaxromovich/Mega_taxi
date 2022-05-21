package com.example.loginpage

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loginpage.ProgressBar.LoadingDialog
import com.example.loginpage.databinding.ActivityMainBinding
import com.example.loginpage.DataApi.*
import com.example.loginpage.DataApi.Response.ResponseDriver
import io.github.muddz.styleabletoast.StyleableToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val loading = LoadingDialog(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()



        binding.signInBtn.setOnClickListener {
            val phone = binding.loginPhone.text.toString()
            val password = binding.passwordText.text.toString()

            signin(phone,password)
            loading.startLoading()
            binding.signInBtn.isEnabled = false
        }


    }

    private fun signin(phone: String, password: String){
        val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterfase::class.java)
        val signInInfo = UserBody(phone, password)
        retIn.signin(signInInfo).enqueue(object : Callback<ResponseDriver> {
            override fun onFailure(call: Call<ResponseDriver>, t: Throwable) {
                Toast.makeText(
                    this@MainActivity,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
                loading.isDismiss()

            }
            override fun onResponse(call: Call<ResponseDriver>, response: Response<ResponseDriver>) {
                val success = response.body()?.success
                if (success == true) {
                    val intent = Intent(this@MainActivity,Order_Page_Activity::class.java)
                    intent.putExtra("name",response.body()?.data?.user_full_name)
                    startActivity(intent)
                    finish()
                    loading.isDismiss()


                }else{
                    StyleableToast.Builder(this@MainActivity)
                        .text(response.body()?.message)
                        .textColor(Color.WHITE)
                        .backgroundColor(Color.RED)
                        .show()
                    loading.isDismiss()

                    binding.signInBtn.isEnabled = true
                }

            }
        })
    }
}