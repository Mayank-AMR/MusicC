package com.mayank_amr.musicchat.auth.repository.data

/**
 * @Project MusicChat
 * @Created_by Mayank Kumar on 13-06-2021 01:08 PM
 */
data class TokenResponse(
    val access_token: String,
    val expires_in: Int,
    val scope: String,
    val token_type: String
)