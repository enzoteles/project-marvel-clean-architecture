package com.example.projeto_marvel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.projeto_marvel.presentation.ui.commics.viewmodel.GetCommicsViewModel
import dagger.hilt.android.AndroidEntryPoint
import example.projeto_marvel.common.Constants
import java.math.BigInteger
import java.security.MessageDigest

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: GetCommicsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val str1 = "${Constants.TS}${Constants.PRIVATE_KEY}${Constants.PUBLIC_KEY}"
        val str = md5(str1)
        viewModel.state.observe(this){ getCommics->

            if(getCommics.isLoadding){
                Log.i("commics", "Loading.......")
            }

            if(getCommics.commics != null){
                Log.i("commics", "${getCommics.commics.data.results[0].prices[0].price}")
            }

            if(getCommics.error.isNullOrEmpty().not()){
                Log.i("commics", "show error ${getCommics.error}")
            }

        }
        viewModel.getCommics(Constants.TS, Constants.PUBLIC_KEY, str)

    }

    fun md5(input:String): String {
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
        }
}