package com.mayank_amr.musicchat.base.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mayank_amr.musicchat.base.repository.BaseRepository
import com.mayank_amr.musicchat.song.repository.OnlineSongRepository
import com.mayank_amr.musicchat.song.viewmodel.OnlineSongViewModel

/**
 * @Project MusicChat
 * @Created_by Mayank Kumar on 22-05-2021 09:16 AM
 */
class ViewModelFactory(
    private val repository: BaseRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            //modelClass.isAssignableFrom(LoginViewModel::class.java) -> LoginViewModel(repository as AuthRepository) as T
            //modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(repository as PostsRepository) as T
            //modelClass.isAssignableFrom(CreatePostViewModel::class.java) -> CreatePostViewModel(repository as CreatePostRepository) as T
            modelClass.isAssignableFrom(OnlineSongViewModel::class.java) -> OnlineSongViewModel(repository as OnlineSongRepository) as T

            else -> throw IllegalArgumentException("ViewModelClass Not Found")
        }
    }
}