package com.hendra.biodata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    private var namaInput : String = ""
    private var emailInput : String = ""
    private var telpInput : String = ""
    private var alamatInput : String = ""
    private var genderInput : String = ""
    private var umurInput : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSimpan.setOnClickListener { goProfileActivity() }
    }
    private fun goProfileActivity() {
//        dalam variabel yang telah dibuat
        namaInput = inputNama.text.toString()
        emailInput = inputEmail.text.toString()
        telpInput = inputTelpon.text.toString()
        alamatInput = inputAlamat.text.toString()
        umurInput = inputUmur.text.toString()
        genderInput = spinnerGender.selectedItem.toString()
        when{
            namaInput.isEmpty() -> inputNama.error = "Nama tidak boleh kosong"
            genderInput.equals("Pilih Jenis Kelamin", ignoreCase = true) -> tampilToast("Jenis Kelamin harus dipilih")
            emailInput.isEmpty() -> inputEmail.error = "Email tidak boleh kosong"
            umurInput.isEmpty() -> inputUmur.error = "Umur Tidak Boleh Kosong"
            telpInput.isEmpty() -> inputTelpon.error = "Telp tidak boleh kosong"
            alamatInput.isEmpty() -> inputAlamat.error = "Alamat tidak boleh kosong"
            else -> {
                goToProfilActivity()
                tampilToast("Navigasi ke halaman profil")
                goToProfilActivity()
            }
        }
    }

    private fun tampilToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    private fun goToProfilActivity() {
        val intent = Intent(this, ProfileActivity::class.java)
        val bundle = Bundle()

        bundle.putString("nama", namaInput)
        bundle.putString("umur", umurInput)
        bundle.putString("gender", genderInput)
        bundle.putString("email", emailInput)
        bundle.putString("telp", telpInput)
        bundle.putString("alamat", alamatInput)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}
