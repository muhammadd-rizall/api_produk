package com.example.api_produk

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class DetailProduk : AppCompatActivity() {
    private lateinit var txtDetailTitle : TextView
    private lateinit var imgDetail : ImageView
    private lateinit var txtDetailDescription : TextView
    private lateinit var txtDetailPrice : TextView
    private lateinit var txtDetailStock : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_produk)

        txtDetailTitle = findViewById(R.id.txtDetailTitle)
        imgDetail = findViewById(R.id.imgDetail)
        txtDetailDescription = findViewById(R.id.txtDetailDescription)
        txtDetailPrice = findViewById(R.id.txtDetailPrice)
        txtDetailStock =findViewById(R.id.txtDetailStock)

        val judul = intent.getStringExtra("title")
        val deskripsi = intent.getStringExtra("description")
        val harga = intent.getDoubleExtra("price", 0.0)
        val stock = intent.getIntExtra("stok", 0)
        val gambar = intent.getStringExtra("thumbnail")
        val brande = intent.getStringExtra("brand")


        txtDetailTitle.text = judul
        Glide.with(this).load(gambar).centerCrop().into(imgDetail)
        txtDetailDescription.text = deskripsi
        txtDetailPrice.text = harga.toString()
        txtDetailStock.text = stock.toString()




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}