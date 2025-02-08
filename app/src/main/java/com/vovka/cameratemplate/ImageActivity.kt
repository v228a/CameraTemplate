package com.vovka.cameratemplate

import android.app.ComponentCaller
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.vovka.cameratemplate.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Получаем URI изображения из Intent
        val photoUri = intent.getStringExtra("photo_uri")

        if (photoUri != null) {
            val uri = Uri.parse(photoUri)
            binding.imageView.setImageURI(uri)
            Log.d("PhotoActivity", "Показ фото: $uri")
        } else {
            Log.e("PhotoActivity", "URI не передан!")
        }
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?,
        caller: ComponentCaller
    ) {
        super.onActivityResult(requestCode, resultCode, data, caller)
//        Toast.makeText(this, data?.getStringExtra("uri"), Toast.LENGTH_LONG).show()
        Log.d(Constants.TAG,data?.getStringExtra("uri").toString())
    }
}