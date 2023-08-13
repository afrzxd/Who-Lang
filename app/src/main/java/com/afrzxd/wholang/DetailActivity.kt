package com.afrzxd.wholang

import android.content.Intent
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val sname = intent.getStringExtra("name")
        val ssince = intent.getStringExtra("since")
        val sowner = intent.getStringExtra("owner")
        val sdesc = intent.getStringExtra("desc")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val shareButton = findViewById<Button>(R.id.action_share)
        shareButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "- Bahasa Pemrograman : $sname \n- Tahun Rilis : $ssince \n- Pengembang : $sowner \n- Deskripsi Lengkap : $sdesc \n\n- Who Lang -")
            val shareIntent = Intent.createChooser(intent, "Share this message using...")
            startActivity(shareIntent)
        }

        val name = intent.getStringExtra("name")
        val since = intent.getStringExtra("since")
        val owner = intent.getStringExtra("owner")
        val desc = intent.getStringExtra("desc")
        val photo = intent.getIntExtra("photo", 0)

        // Set data pada TextView dan ImageView
        findViewById<TextView>(R.id.txt_name_lang).text = name
        findViewById<TextView>(R.id.txt_since_lang).text = since
        findViewById<TextView>(R.id.txt_owner_lang).text = owner
        findViewById<TextView>(R.id.txt_desc_lang).text = desc
        findViewById<ImageView>(R.id.img_item_photo).setImageResource(photo)


    }



}