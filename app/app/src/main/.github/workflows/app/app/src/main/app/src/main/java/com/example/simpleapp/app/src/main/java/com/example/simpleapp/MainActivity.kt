package com.example.simpleapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.simpleapp.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var b: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        showFragment(HomeFragment())

        b.btnDocs.setOnClickListener { showFragment(SubscriptionFragment.newInstance("Документы")) }
        b.btnServices.setOnClickListener { showFragment(SubscriptionFragment.newInstance("Сервисы")) }
        b.btnMenu.setOnClickListener { openMenuSheet() }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.contentFrame, fragment)
            .commit()
    }

    private fun openMenuSheet() {
        val dialog = BottomSheetDialog(this)
        val view = layoutInflater.inflate(R.layout.sheet_menu, null)

        val btn1 = view.findViewById<MaterialButton>(R.id.btnMessages)
        val btn2 = view.findViewById<MaterialButton>(R.id.btnHistory)
        val btn3 = view.findViewById<MaterialButton>(R.id.btnSettings)
        val btn4 = view.findViewById<MaterialButton>(R.id.btnDevice)

        val click: (MaterialButton) -> Unit = {
            Toast.makeText(this, "Функция пока недоступна", Toast.LENGTH_SHORT).show()
        }
        btn1.setOnClickListener { click(btn1) }
        btn2.setOnClickListener { click(btn2) }
        btn3.setOnClickListener { click(btn3) }
        btn4.setOnClickListener { click(btn4) }

        dialog.setContentView(view)
        dialog.show()
    }
}
