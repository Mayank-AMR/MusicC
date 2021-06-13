package com.mayank_amr.musicchat.base.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.mayank_amr.musicchat.base.repository.BaseRepository
import com.spotify.android.appremote.api.SpotifyAppRemote

/**
 * @Project MusicChat
 * @Created_by Mayank Kumar on 22-05-2021 09:17 AM
 */
abstract class BaseViewModel(
    private val repository: BaseRepository
) : ViewModel() {
    private val TAG = "BaseViewModel"

    var spotifyAppRemote: SpotifyAppRemote? = null


    fun playSong(uri: String) {
        if (spotifyAppRemote == null) Log.d(TAG, "playSong: SDK IS Null ") else spotifyAppRemote!!.playerApi.play(uri)
    }


    override fun onCleared() {
        super.onCleared()
        // And we will finish off here.
        spotifyAppRemote?.let {
            SpotifyAppRemote.disconnect(it)
        }
    }
}
