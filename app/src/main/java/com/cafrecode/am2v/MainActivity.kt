package com.cafrecode.am2v

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cafrecode.am2v.databinding.ActivityMainBinding
import com.cafrecode.lib.am2v.ModelToView

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var modelToView: ModelToView

    val packaging = Packaging(
        "12", "12", "45", "67",
        "87", null, "09", "34", "54", "54", "34", "34"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        modelToView = ModelToView(binding.content)
        modelToView.setModel(packaging as Object)
    }


}

