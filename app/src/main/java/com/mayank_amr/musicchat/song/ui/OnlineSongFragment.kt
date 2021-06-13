package com.mayank_amr.musicchat.song.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mayank_amr.musicchat.R
import com.mayank_amr.musicchat.base.fragment.BaseFragment
import com.mayank_amr.musicchat.databinding.OnlineSongFragmentBinding
import com.mayank_amr.musicchat.song.repository.OnlineSongRepository
import com.mayank_amr.musicchat.song.viewmodel.OnlineSongViewModel

class OnlineSongFragment :
    BaseFragment<OnlineSongViewModel, OnlineSongFragmentBinding, OnlineSongRepository>() {

    companion object {
        private const val TAG = "OnlineSongFragment"
        fun newInstance() = OnlineSongFragment()
    }

    private lateinit var viewModel: OnlineSongViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.online_song_fragment, container, false)
    }


    override fun getViewModel() = OnlineSongViewModel::class.java

    override fun getFragmentRepository(): OnlineSongRepository {

        //val api =
        //val api = remoteDataSource.buildApi(DataApi::class.java, token)
        return OnlineSongRepository()
    }

    override fun layoutId() = R.layout.online_song_fragment

    fun successfulConnectedCallback(){
        Log.d(TAG, "successfulConnectedCallback: ")

    }

}