package br.ufpb.dcx.apps4society.educapimanager.view.ui.context

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.ufpb.dcx.apps4society.educapimanager.R
import br.ufpb.dcx.apps4society.educapimanager.model.Context

class ContextListAdapter(private var contexts : List<Context>) : RecyclerView.Adapter<ContextListAdapter.ViewHolder>() {
    private var TAG : String = "ContextListAdapter"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_context, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return contexts.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.context_name.setText(contexts.get(position).name)
        Log.i(TAG, ""+contexts.size)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var context_name : TextView = itemView.findViewById(R.id.context_name)
        var bnt_edit_context : Button = itemView.findViewById(R.id.btn_edit_context)
        var btn_view_challenges_of_this_context : Button = itemView.findViewById(R.id.btn_view_challenges_of_this_context)
        var context_image : ImageView = itemView.findViewById(R.id.context_image)

    }

}