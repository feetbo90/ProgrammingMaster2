package master.programming.programmingmaster.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import master.programming.programmingmaster.R
import master.programming.programmingmaster.model.Movie




class movieAdapter(val movieList : ArrayList<Movie>, val context: Context) : RecyclerView.Adapter<movieAdapter.ViewHolder>(){
    
    
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.movie_list_row, parent, false)
        return movieAdapter.ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.genre?.text = movieList.get(position).genre
        holder?.title?.text = movieList.get(position).title
        holder?.year?.text = movieList.get(position).year

    }


    private companion object {
        var callback: onSuggestResultListener? = null
    }

    
    override fun getItemCount(): Int {

        return movieList.size
    }

    
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        //private val itemClickListener: AdapterView.OnItemClickListener? = null
        var genre : TextView? = null
        var title : TextView? = null
        var year : TextView? = null

        init{
            genre = itemView.findViewById(R.id.genre)
            title = itemView.findViewById(R.id.title)
            year = itemView.findViewById(R.id.year)
            itemView.setOnClickListener{

                var value = adapterPosition
                callback?.onSuggestResult(value)


            }
        }
    }

    interface onSuggestResultListener {
        fun onSuggestResult(posisi : Int)
    }

    fun setOnSuggestResultListener(x: onSuggestResultListener) {
        callback = x
    }


}