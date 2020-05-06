package com.hendra.biodata

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        ambilData()
        edit.setOnClickListener { menujuEditProfil() }
        dial.setOnClickListener { dialPhone(txtTelpon.text.toString()) }
        about.setOnClickListener { abouteMe() }
    }
    private fun abouteMe() {
        val intent = Intent(this,AboutActivity::class.java)
        startActivity(intent)
    }
    private fun dialPhone(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getStringExtra ("nama")
                txtNama.text = result
            } else {
                Toast.makeText (this, "Edit Gagal", Toast.LENGTH_SHORT) .show()
            }
        }
    }
    companion object {
        val REQUEST_CODE = 100
    }
    private fun menujuEditProfil() {
        val intent = Intent (this, EditActivity::class.java)
        val namaPengguna = txtNama.text.toString()
        intent.putExtra("nama", namaPengguna)
        startActivityForResult(intent, REQUEST_CODE)
    }

    private fun ambilData() {
        val bundle = intent.extras
        val nama = bundle?.getString("nama")
        val gender = bundle?.getString( "gender")
        val email = bundle?.getString( "email")
        val telp = bundle?.getString( "telp")
        val alamat = bundle?.getString( "alamat")
        val umur = bundle?.getString("umur")
        txtNama.text = nama
        txtGender.text = gender
        txtEmail.text = email
        txtTelpon.text = telp
        txtAlamat.text = alamat
        txtUmur.text = umur
    }
}
