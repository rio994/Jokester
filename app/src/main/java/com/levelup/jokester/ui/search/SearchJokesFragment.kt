package com.levelup.jokester.ui.search

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.levelup.jokester.R
import com.levelup.jokester.databinding.FragmentSearchJokesBinding
import kotlinx.android.synthetic.main.fragment_search_jokes.*
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class SearchJokesFragment : Fragment() {

    private lateinit var bindings : FragmentSearchJokesBinding

    private val viewModel : SearchJokesViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindings = DataBindingUtil.inflate(inflater, R.layout.fragment_search_jokes, container, false)
        bindings.viewModel = viewModel
        bindings.lifecycleOwner = this

        return bindings.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.errorResponse.observe(viewLifecycleOwner, Observer {
            it?:return@Observer

        })
        viewModel.jokes.observe(viewLifecycleOwner, Observer {
            it?:return@Observer

        })
    }


}
/*
@BindingAdapter("app:setFavorite")
fun ImageView.setFavorite(res: Int) {
    //val drawable = resources.getDrawable(res, null)
    if()
    setImageResource(res)
    else
        setImageDrawable(context.getDrawable(R.drawable.ic_favorite_empty_24))
}
 */


