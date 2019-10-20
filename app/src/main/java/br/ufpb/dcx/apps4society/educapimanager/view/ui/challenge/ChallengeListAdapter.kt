package br.ufpb.dcx.apps4society.educapimanager.view.ui.challenge

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.ufpb.dcx.apps4society.educapimanager.R
import br.ufpb.dcx.apps4society.educapimanager.model.bean.Challenge
import com.bumptech.glide.Glide
import com.bumptech.glide.load.EncodeStrategy
import com.bumptech.glide.load.engine.DiskCacheStrategy

class ChallengeListAdapter(private var challenges : List<Challenge>, private var fragmentContext: android.content.Context) : RecyclerView.Adapter<ChallengeListAdapter.ViewHolder>() {
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
        loadImage(challenges[position].imageUrl, holder.challenge_image)
    }

    private fun loadImage(imageUrl: String?, themeImageLeft: ImageView) {
        val diskCacheStrategy = object : DiskCacheStrategy() {
            override fun isDataCacheable(dataSource: com.bumptech.glide.load.DataSource?): Boolean {
                return true
            }

            override fun isResourceCacheable(isFromAlternateCacheKey: Boolean, dataSource: com.bumptech.glide.load.DataSource?, encodeStrategy: EncodeStrategy?): Boolean {
                return true
            }

            override fun decodeCachedResource(): Boolean {
                return true
            }

            override fun decodeCachedData(): Boolean {
                return true
            }

        }
        var erroImg : Int
        try {
            erroImg = Integer.parseInt(imageUrl)
        } catch (e: NumberFormatException) {
            erroImg = R.drawable.no_image
        }

        Glide.with(fragmentContext)
            .load(imageUrl)
            .error(erroImg)
            .diskCacheStrategy(diskCacheStrategy)
            .into(themeImageLeft)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var challenge_name : TextView = itemView.findViewById(R.id.challenge_word)
        var bnt_edit_challenge : Button = itemView.findViewById(R.id.btn_edit_challenge)
        var challenge_image : ImageView = itemView.findViewById(R.id.challenge_image)

    }

}