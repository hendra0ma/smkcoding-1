package com.hendra.biodata

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        val intentData = intent.extras
        val namaPengguna = intentData?.getString("nama")

        edtNama.setText(namaPengguna)
        btnSimpann.setOnClickListener{ saveData()}
    }
    private fun saveData() {
        val edit = edtNama.text.toString()
        if(!edit.isEmpty()) {
            val result = Intent()
            result.putExtra("nama", edit)
            setResult(Activity.RESULT_OK, result)
        } else {
            setResult(Activity.RESULT_CANCELED)
        }
        finish()
    }
}
