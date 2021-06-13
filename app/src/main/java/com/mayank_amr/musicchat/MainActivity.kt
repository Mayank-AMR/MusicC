package com.mayank_amr.musicchat

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mayank_amr.musicchat.network.ConnectionLiveData
import com.spotify.android.appremote.api.ConnectionParams
import com.spotify.android.appremote.api.Connector
import com.spotify.android.appremote.api.SpotifyAppRemote

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
//    lateinit var connectionLiveData: ConnectionLiveData



    // Spotify
//    private val clientId = "00bbcb69dc4640b8ba16e07fcf670a21"
//    private val redirectUri ="https://spotauth.github.io"// "http://com.mayank_amr.musicchat/successfulConnectedCallback"
//    private var spotifyAppRemote: SpotifyAppRemote? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: ")


//        /*
//        * Check for live Internet connection and update ui.
//        */
//        connectionLiveData = ConnectionLiveData(this)
//        connectionLiveData.observe(this, { isNetworkAvailable ->
//            // update ui
//            if (isNetworkAvailable) {
//                Toast.makeText(this, "Online", Toast.LENGTH_LONG).show()
//            } else {
//                Toast.makeText(this, "Offline", Toast.LENGTH_LONG).show()
//            }
//        })

    }


//    override fun onStart() {
//        super.onStart()
//        // We will start writing our code here.
//        // Set the connection parameters
//        val connectionParams = ConnectionParams.Builder(clientId)
//            .setRedirectUri(redirectUri)
//            .showAuthView(true)
//            .build()
//
//        SpotifyAppRemote.connect(this, connectionParams, object : Connector.ConnectionListener {
//            override fun onConnected(appRemote: SpotifyAppRemote) {
//                spotifyAppRemote = appRemote
//                Log.d(TAG, "Connected! Yay!")
//                // Now you can start interacting with App Remote
//                connected()
//            }
//
//            override fun onFailure(throwable: Throwable) {
//                Log.e(TAG, throwable.message, throwable)
//                // Something went wrong when attempting to connect! Handle errors here
//            }
//        })
//    }
//
//    fun connected() {
//        // Then we will write some more code here.
//        // Play a playlist
//        spotifyAppRemote!!.playerApi.play("spotify:playlist:37i9dQZF1DX2sUQwD7tbmL")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        // And we will finish off here.
//        spotifyAppRemote?.let {
//            SpotifyAppRemote.disconnect(it)
//        }
//    }

}