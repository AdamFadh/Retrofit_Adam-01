package com.example.infocovid_19

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.infocovid_19.api.RetrofitClient
import com.example.infocovid_19.model.ProvinsiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProvinceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_province)
        showProvince()
    }

    private fun showProvince() {
        val rvProvince : RecyclerView = findViewById(R.id.rvProvince)

        rvProvince.setHasFixedSize(true)
        rvProvince.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getProvince()
            .enqueue(object : Callback<ArrayList<ProvinsiResponse>> {
                override fun onResponse(
                    call: Call<ArrayList<ProvinsiResponse>>,
                    response: Response<ArrayList<ProvinsiResponse>>
                ) {
                    val list = response.body()
                    val adapter = list?.let { ProvinceAdapter(it) }
                    rvProvince.adapter = adapter
                }

                override fun onFailure(call: Call<ArrayList<ProvinsiResponse>>, t: Throwable) {
                    Toast.makeText(this@ProvinceActivity, "${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
    }
}