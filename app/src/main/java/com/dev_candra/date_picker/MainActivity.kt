package com.dev_candra.date_picker

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Aksi()
    }

    // memasukkan semua aksi pada widget
    private fun Aksi(){
        widgetAksi()
        initalActionbar()
    }

    // membuat fungsi dari semua aksi widget
    private fun widgetAksi(){
       val calendar = Calendar.getInstance()
       val year1 = calendar.get(Calendar.YEAR)
       val month1 = calendar.get(Calendar.MONTH)
       val day1 = calendar.get(Calendar.DAY_OF_MONTH)

       button1.apply {
           setOnClickListener {
               val datePickerDialog = DatePickerDialog(this@MainActivity,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                   teks1.apply {
                       setText(" $dayOfMonth - $month - $year")
                   }
               },year1,month1,day1)
               datePickerDialog.show()
           }
       }
    }

    private fun initalActionbar(){
        val actionbar = supportActionBar
        if (actionbar != null){
            actionbar.title = "Candra Julius Sinaga"
            actionbar.subtitle = "Contoh DatePicker Dialog"
        }
    }

}
