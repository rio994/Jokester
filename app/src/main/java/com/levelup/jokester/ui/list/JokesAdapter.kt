package com.levelup.jokester.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.levelup.jokester.data.model.JokeResponse
import com.levelup.jokester.databinding.ListItemBinding
import com.levelup.jokester.ui.search.SearchJokesViewModel

class JokesAdapter(private val viewModel : SearchJokesViewModel) : RecyclerView.Adapter<JokesAdapter.ViewHolder>() {

    var list : MutableList<JokeResponse> = mutableListOf()

    fun setJokes(jokes: List<JokeResponse>) {
        list = jokes.toMutableList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        holder.bind(item, position)
    }

    inner class ViewHolder (private val binding : ListItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item : JokeResponse, position: Int){
            binding.apply {
                this.item = item
                this.listener = object : ItemClickListener{
                    override fun onClick() {
                        list.removeAt(position)
                        viewModel.deleteJoke(item)
                        notifyItemRemoved(position)
                    }
                }
                executePendingBindings()
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}