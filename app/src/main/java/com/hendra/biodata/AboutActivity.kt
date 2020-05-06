package com.hendra.biodata

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        github.setOnClickListener {pindahKeWebsite()}
    }

    private fun pindahKeWebsite() {
        val toWeb : Intent = Uri.parse("https://github.com/hendra0ma").let{webpage->Intent(Intent.ACTION_VIEW,webpage)}
        startActivity(toWeb)
    }
}
