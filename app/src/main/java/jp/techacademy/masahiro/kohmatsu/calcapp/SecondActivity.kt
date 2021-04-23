package jp.techacademy.masahiro.kohmatsu.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //

        val value5 = intent.getFloatExtra("total", 0.0)

        answer.text = value5.toString()

    }
}