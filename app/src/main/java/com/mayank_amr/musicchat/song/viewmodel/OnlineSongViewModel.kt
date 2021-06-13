package com.mayank_amr.musicchat.song.viewmodel

import com.mayank_amr.musicchat.base.viewmodel.BaseViewModel
import com.mayank_amr.musicchat.song.repository.OnlineSongRepository

class OnlineSongViewModel(private val repository: OnlineSongRepository) :
    BaseViewModel(repository) {

}