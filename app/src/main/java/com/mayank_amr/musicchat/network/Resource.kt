package com.mayank_amr.musicchat.network

import okhttp3.ResponseBody

/**
 * @Project MusicChat
 * @Created_by Mayank Kumar on 22-05-2021 09:20 AM
 */
sealed class  Resource<out T> {
    data class Success<out T>(val value: T) : Resource<T>()
    data class Failure(
        val isNetworkError: Boolean,
        val errorCode: Int?,
        val errorBody: ResponseBody?
    ) : Resource<Nothing>()

    object Loading:Resource<Nothing>()

}