package br.com.douglasmotta.hiltdependencyinjection.ui.news

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.douglasmotta.hiltdependencyinjection.data.model.Article
import br.com.douglasmotta.hiltdependencyinjection.data.model.NewsResult
import br.com.douglasmotta.hiltdependencyinjection.data.repository.NewsRepositoryInterface
import kotlinx.coroutines.launch

class NewsViewModel @ViewModelInject constructor(
    private val newsRepository: NewsRepositoryInterface
) : ViewModel() {

    private val _articlesEvent = MutableLiveData<List<Article>>()
    val articlesEvent: LiveData<List<Article>>
        get() = _articlesEvent

    fun getNews() = viewModelScope.launch {
        when (val newsResult = newsRepository.getNews()) {
            is NewsResult.Success -> {
                _articlesEvent.value = newsResult.articles
            }
            is NewsResult.ApiError -> {
                if (newsResult.code == 401) {
                    // Show screen error
                }
            }
            is NewsResult.UnknownError -> {
                // Show toast
            }
        }
    }
}
