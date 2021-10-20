package com.levelup.jokester.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.levelup.jokester.R
import com.levelup.jokester.ui.search.SearchJokesViewModel
import kotlinx.android.synthetic.main.fragment_list.*
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {
    val viewModel : SearchJokesViewModel by sharedViewModel()

    var adapter : JokesAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = JokesAdapter(viewModel)
        recyclerView.adapter = adapter

        viewModel.jokes.observe(viewLifecycleOwner, Observer {
            it ?: return@Observer

            adapter?.setJokes(it)
        })
    }

}