package com.mayank_amr.musicchat.base.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mayank_amr.musicchat.base.repository.BaseRepository
import com.mayank_amr.musicchat.base.viewmodel.BaseViewModel
import com.mayank_amr.musicchat.base.viewmodel.ViewModelFactory
import com.mayank_amr.musicchat.network.ConnectionLiveData
import com.mayank_amr.musicchat.network.RemoteDataSource
import com.spotify.android.appremote.api.ConnectionParams
import com.spotify.android.appremote.api.Connector
import com.spotify.android.appremote.api.SpotifyAppRemote

/**
 * @Project MusicChat
 * @Created_by Mayank Kumar on 22-05-2021 09:01 AM
 */
abstract class BaseFragment<VM : BaseViewModel, B : ViewDataBinding, BR : BaseRepository> :
    Fragment() {
    private val TAG = "BaseFragment"


    lateinit var connectionLiveData: ConnectionLiveData

    protected val remoteDataSource = RemoteDataSource()
    protected lateinit var binding: B
    protected lateinit var viewmodel: VM

    // Spotify
    private val clientId = "00bbcb69dc4640b8ba16e07fcf670a21"
    private val redirectUri =/*"https://spotauth.github.io"*/
        "http://com.mayank_amr.musicchat/successfulConnectedCallback"
    private var spotifyAppRemote: SpotifyAppRemote? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val factory = ViewModelFactory(getFragmentRepository())
        viewmodel = ViewModelProvider(this, factory).get(getViewModel())

        /*
        * Check for live Internet connection and update ui.
        */
        connectionLiveData = ConnectionLiveData(requireContext())
        connectionLiveData.observe(viewLifecycleOwner, { isNetworkAvailable ->
            // update ui
            if (isNetworkAvailable) {
                Toast.makeText(requireContext(), "Online", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(requireContext(), "Offline", Toast.LENGTH_LONG).show()
            }
        })

        return inflater.inflate(layoutId(), container, false)
    }

    override fun onStart() {
        super.onStart()
        // We will start writing our code here.
        // Set the connection parameters
        val connectionParams = ConnectionParams.Builder(clientId)
            .setRedirectUri(redirectUri)
            .showAuthView(true)
            .build()

        SpotifyAppRemote.connect(
            requireContext(),
            connectionParams,
            object : Connector.ConnectionListener {
                override fun onConnected(appRemote: SpotifyAppRemote) {
                    spotifyAppRemote = appRemote
                    Log.d(TAG, "Connected! Yay!")
                    // Now you can start interacting with App Remote
                    connected()
                    //viewmodel.playSong("spotify:playlist:37i9dQZF1DX2sUQwD7tbmL")
                }

                override fun onFailure(throwable: Throwable) {
                    Log.e(TAG, throwable.message, throwable)
                    // Something went wrong when attempting to connect! Handle errors here
                }
            })
    }

    fun connected() {
        // Then we will write some more code here.
        // Play a playlist
        spotifyAppRemote!!.playerApi.play("spotify:playlist:37i9dQZF1DX2sUQwD7tbmL")
    }

    override fun onStop() {
        super.onStop()
        // And we will finish off here.
        spotifyAppRemote?.let {
            SpotifyAppRemote.disconnect(it)
        }
    }

    abstract fun getViewModel(): Class<VM>

    abstract fun getFragmentRepository(): BR

    abstract fun layoutId(): Int
}