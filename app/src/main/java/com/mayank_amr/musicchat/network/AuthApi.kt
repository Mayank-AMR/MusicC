package com.mayank_amr.musicchat.network

import com.mayank_amr.musicchat.auth.repository.data.TokenResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

/**
 * @Project MusicChat
 * @Created_by Mayank Kumar on 07-06-2021 12:26 PM
 */
interface AuthApi {
    @FormUrlEncoded
    @POST("api/token")
    suspend fun getAccessToken(
        @Header("Authorization") encodedString: String?,
        @Field("grant_type") client_credentials: String
    ): Response<TokenResponse>

}