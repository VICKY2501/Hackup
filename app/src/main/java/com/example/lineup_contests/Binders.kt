package com.example.lineup_contests

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: ArrayList<ContestsItem>?) {
    val adapter = recyclerView.adapter as LuAdapter
    adapter.submitList(data)
}
@BindingAdapter("onlistData")
fun bindRecyclerView2(recyclerViewon: RecyclerView, dataon: ArrayList<ContestsItem>?) {
    val adapter = recyclerViewon.adapter as Onadapter
    adapter.submitList(dataon)
}
@BindingAdapter("uplistData")
fun bindRecyclerView3(recyclerViewup: RecyclerView, dataup: ArrayList<ContestsItem>?) {
    val adapter = recyclerViewup.adapter as Upadapter
    adapter.submitList(dataup)
}

