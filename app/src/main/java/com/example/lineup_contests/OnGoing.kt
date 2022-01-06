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
import com.example.lineup_contests.databinding.FragmentOnGoingBinding



class OnGoing : Fragment(),Onlisten {

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
        val binding = FragmentOnGoingBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.dataon = sharedViewModel
        binding.recyclerViewon.adapter = Onadapter(this)
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OnGoing().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onclicked(hit: ContestsItem) {
        val bundle = Bundle().apply {
            putSerializable("contest", hit)
        }
        findNavController().navigate(R.id.action_onGoing_to_displayFragment, bundle)
    }
}