package com.example.imageappwithretrofitgridandlist.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imageappwithretrofitgridandlist.R
import com.example.imageappwithretrofitgridandlist.viewmodel.ImageViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragment : Fragment() {

    private lateinit var imageViewModel: ImageViewModel
    private var isGrid = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        imageViewModel = ViewModelProvider(this).get(ImageViewModel::class.java)

        view.image_search.setOnClickListener {
            getData(view, view.edit_text_search.text.toString())
        }

        view.toggle_view.setOnClickListener {
            isGrid = !isGrid
            getData(view, "")
        }

        getData(view, "")
        return view
    }

    private fun getData(view: View, query: String) {
        val adapter = ListAdapter()
        val recyclerView = view.recycler_view
        recyclerView.adapter = adapter

        if (isGrid) {
            recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        } else {
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }

        if (query.isEmpty()) {
            val list1 = imageViewModel.getItemList()
            list1.observe(viewLifecycleOwner, Observer {
                adapter.imgeList = it
                adapter.notifyDataSetChanged()
                adapter.setData(isGrid)
            })
        } else {
            val list = imageViewModel.getSearchItemList(query)
            list.observe(viewLifecycleOwner, Observer {
                adapter.imgeList = it
                adapter.notifyDataSetChanged()
                adapter.setData(isGrid)
            })
        }
    }
}
