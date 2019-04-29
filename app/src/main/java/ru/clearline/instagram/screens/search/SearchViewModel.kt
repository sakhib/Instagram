package ru.clearline.instagram.screens.search

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import ru.clearline.instagram.data.SearchRepository
import ru.clearline.instagram.models.SearchPost
import ru.clearline.instagram.screens.common.BaseViewModel
import com.google.android.gms.tasks.OnFailureListener

class SearchViewModel(searchRepo: SearchRepository,
                      onFailureListener: OnFailureListener) : BaseViewModel(onFailureListener) {
    private val searchText = MutableLiveData<String>()

    val posts: LiveData<List<SearchPost>> = Transformations.switchMap(searchText) { text ->
        searchRepo.searchPosts(text)
    }

    fun setSearchText(text: String) {
        searchText.value = text
    }
}