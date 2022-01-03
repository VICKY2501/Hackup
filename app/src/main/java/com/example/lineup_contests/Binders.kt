package com.example.lineup_contests

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: ArrayList<ContestsItem>?) {
    val adapter = recyclerView.adapter as LuAdapter
    adapter.submitList(data)
}

