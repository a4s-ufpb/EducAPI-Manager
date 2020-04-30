package br.ufpb.dcx.apps4society.educapimanager.view.ui.context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.ufpb.dcx.apps4society.educapimanager.R
import br.ufpb.dcx.apps4society.educapimanager.model.dto.ContextDTO
import com.bumptech.glide.Glide
import com.bumptech.glide.load.EncodeStrategy
import com.bumptech.glide.load.engine.DiskCacheStrategy

class ContextListAdapter(private var contexts: List<ContextDTO>, fragmentContext: android.content.Context) : RecyclerView.Adapter<ContextListAdapter.ViewHolder>() {
    private var TAG : String = "ContextListAdapter"
    private var fragmentContext : android.content.Context = fragmentContext

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_context, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return contexts.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.context_name.text = contexts[position].name
        loadImage(contexts[position].imageUrl, holder.context_image)
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
            erroImg = Integer.parseInt(imageUrl.toString())
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
        var context_name : TextView = itemView.findViewById(R.id.context_name)
        var bnt_edit_context : Button = itemView.findViewById(R.id.btn_edit_context)
        var btn_view_challenges_of_this_context : Button = itemView.findViewById(R.id.btn_view_challenges_of_this_context)
        var context_image : ImageView = itemView.findViewById(R.id.context_image)

    }

}