package com.example.lineup_contests

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lineup_contests.databinding.FragmentListBinding


class ListFragment : Fragment() , Rvlisten {
    private val sharedViewModel: ContestViewModel by activityViewModels()
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: LuAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar!!.hide()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as AppCompatActivity).supportActionBar!!.hide()
        val binding = FragmentListBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.data = sharedViewModel
        // Giving the binding access to the OverviewViewModel


        // Sets the adapter of the photosGrid RecyclerView
        binding.recyclerView.adapter = LuAdapter(this)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        sharedViewModel.allContests.observe(viewLifecycleOwner,{
            if(it.isEmpty())
            {
                Toast.makeText(context,"Invalid Search Results", Toast.LENGTH_SHORT).show()
            }
        })
        sharedViewModel.getRecipes()
    }

    override fun onclicked(hit: ContestsItem) {
            val bundle = Bundle().apply {
                putSerializable("contest", hit)
            }
            findNavController().navigate(R.id.action_listFragment_to_displayFragment, bundle)
    }
}