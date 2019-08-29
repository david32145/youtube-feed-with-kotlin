package david.com.youtubeclone.adapter

import android.content.Context
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import david.com.youtubeclone.models.Movie
import david.com.youtubeclone.R

class ArrayMoviesAdapter(context: Context,list: List<Movie>?) :
    ArrayAdapter<Movie>(context, 0, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var item = getItem(position)
        var view: View =  LayoutInflater.from(context).inflate(R.layout.listview_youtube, parent,false)

        var image = view.findViewById<ImageView>(R.id.img_thumbnail)
        var tvTitle = view.findViewById<TextView>(R.id.tv_title)
        var tvDescription = view.findViewById<TextView>(R.id.tv_description)

        Picasso.with(context).load(item.snippet.thumbnails.default.url).into(image)
        tvTitle.text = item.snippet.title
        tvDescription.text = item.snippet.description


        return view
    }
}