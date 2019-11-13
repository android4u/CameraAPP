package com.android.cameraapp.ui.base_activity.photos_fragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagedList
import com.android.cameraapp.data.data_models.UserCollection
import com.android.cameraapp.di.base_activity.home_fragment.HomeFragmentScope
import com.android.cameraapp.di.base_activity.photo_fragment.PhotoFragmentScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@PhotoFragmentScope
class PhotosFragmentViewModel @Inject constructor(val repo: PhotosFragmentRepository) : ViewModel() {
    val mediatorLiveData : MediatorLiveData<List<UserCollection.Photos>> = repo.mediatorLiveData

    init {
        repo.getData()

        viewModelScope.launch { repo.getAllPhotos() }
    }

    override fun onCleared() {
        super.onCleared()
        repo.clearListener()
    }
}