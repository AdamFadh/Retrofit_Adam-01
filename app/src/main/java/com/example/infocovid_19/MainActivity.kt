package com.example.infocovid_19

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.infocovid_19.api.RetrofitClient
import com.example.infocovid_19.model.IndonesiaResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showIndonesia()

        val btnProvince = findViewById<TextView>(R.id.btnProvince)

        btnProvince.setOnClickListener {
            Intent(this@MainActivity, ProvinceActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    private fun showIndonesia(){
        RetrofitClient.instance.getIndonesia().enqueue(object :
            Callback<ArrayList<IndonesiaResponse>>{
            override fun onFailure(call: Call<ArrayList<IndonesiaResponse>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<ArrayList<IndonesiaResponse>>,
                response: Response<ArrayList<IndonesiaResponse>>
            ) {
                val indonesia = response.body()?.get(0)
                val positive = indonesia?.positif
                val hospitalized = indonesia?.dirawat
                val recover = indonesia?.sembuh
                val death = indonesia?.meninggal

                val tvPositive = findViewById<TextView>(R.id.tvPositive)
                val tvHospitalized = findViewById<TextView>(R.id.tvHospitalized)
                val tvRecover = findViewById<TextView>(R.id.tvRecover)
                val tvDeath = findViewById<TextView>(R.id.tvDeath)

                tvPositive.text = positive
                tvHospitalized.text = hospitalized
                tvRecover.text = recover
                tvDeath.text = death
            }

        })
    }
}