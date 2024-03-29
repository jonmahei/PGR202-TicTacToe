package no.jmheiberg.jonma.tictactoe

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class GameOver : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_game_over, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnYes = view.findViewById<Button>(R.id.btn_yes)
        val btnNo = view.findViewById<Button>(R.id.btn_no)

        btnYes.setOnClickListener {
            newGame()
        }

        btnNo.setOnClickListener {
            view.visibility = View.GONE
        }

        val name = this.arguments?.getString("name")
        val player = this.arguments?.getInt("winner")

        val txtWinner: TextView = view.findViewById(R.id.txt_winner)

        var winner = ""
        if (player == 1) winner = "x"
        if (player == 2) winner = "o"
        txtWinner.text = "The winner is $name ($winner)"
        if (player == 0) {
            txtWinner.text = "It's a draw, please try again"
        }


    }

    private fun newGame() {
        activity?.recreate()

    }
}