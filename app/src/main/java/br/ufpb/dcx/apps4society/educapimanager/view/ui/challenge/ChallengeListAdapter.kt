package br.ufpb.dcx.apps4society.educapimanager.view.ui.challenge

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.ufpb.dcx.apps4society.educapimanager.R
import br.ufpb.dcx.apps4society.educapimanager.model.Challenge

class ChallengeListAdapter(private var challenges : List<Challenge>) : RecyclerView.Adapter<ChallengeListAdapter.ViewHolder>() {
    private var TAG : String = "ChallengeListAdapter"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_challenge, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return challenges.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.challenge_name.setText(challenges.get(position).word)
        Log.i(TAG, ""+challenges.size)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var challenge_name : TextView = itemView.findViewById(R.id.challenge_word)
        var bnt_edit_challenge : Button = itemView.findViewById(R.id.btn_edit_challenge)
        var challenge_image : ImageView = itemView.findViewById(R.id.challenge_image)

    }

}