package com.android.cameraapp.ui.base_activity.following_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.cameraapp.databinding.FollowingFragmentBinding
import dagger.android.support.DaggerFragment

class FollowingFragment : DaggerFragment() {
    lateinit var binding : FollowingFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FollowingFragmentBinding.inflate(inflater, container, false)
        binding.followingRecyclerView.adapter =
            FollowingAdapter()
        return binding.root
    }
}