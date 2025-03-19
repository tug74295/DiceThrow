package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.random.Random

class DieFragment : Fragment() {

    companion object {
        val DIESIDE = "sidenumber"
        val PREVIOUS_ROLL = "previousRoll"
        fun newInstance(sides: Int): DieFragment {
            val fragment = DieFragment()
            val bundle = Bundle()
            bundle.putInt(DIESIDE, sides)
            fragment.arguments = bundle
            return fragment
        }
    }
    var currentRoll = 0

    lateinit var dieTextView: TextView

    var dieSides: Int = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getInt(DIESIDE).run {
                dieSides = this
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        savedInstanceState?.run {
            currentRoll = getInt(PREVIOUS_ROLL, 0)
        }
        if (currentRoll == 0) {
            throwDie()
        } else {
            throwDie(currentRoll)
        }
        view.setOnClickListener{
            throwDie()
        }
    }

    fun throwDie() {
        currentRoll = (Random.nextInt(dieSides) + 1)
        dieTextView.text = currentRoll.toString()
    }

    fun throwDie(die: Int) {
        dieTextView.text = die.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(PREVIOUS_ROLL, currentRoll)
    }
}