package com.example.lineup_contests

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.lineup_contests.databinding.FragmentListBinding
import com.example.lineup_contests.databinding.FragmentUpComingBinding

class UpComing : Fragment(),Uplisten {

    private val sharedViewModel: ContestViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as AppCompatActivity).supportActionBar!!.hide()
        val binding = FragmentUpComingBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.dataup = sharedViewModel
        // Giving the binding access to the OverviewViewModel
        // Sets the adapter of the photosGrid RecyclerView
        binding.recyclerViewup.adapter = Upadapter(this)

        return binding.root

    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UpComing().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onclicked(hit: ContestsItem) {
        val bundle = Bundle().apply {
            putSerializable("contest", hit)
        }
        findNavController().navigate(R.id.action_upComing_to_displayFragment, bundle)
    }
}