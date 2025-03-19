package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dieFragment1 = DieFragment.newInstance(6)
        val dieFragment2 = DieFragment.newInstance(20)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, dieFragment1)
            .replace(R.id.fragmentContainerView2, dieFragment2)
            .commit()

        findViewById<Button>(R.id.rollDiceButton).setOnClickListener {
            dieFragment1.throwDie()
            dieFragment2.throwDie()
        }
    }
}