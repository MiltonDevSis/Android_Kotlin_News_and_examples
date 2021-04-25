package br.com.douglasmotta.hiltdependencyinjection.ui.news

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.douglasmotta.hiltdependencyinjection.R
import br.com.douglasmotta.hiltdependencyinjection.data.repository.NewsFANApiDataSource
import br.com.douglasmotta.hiltdependencyinjection.data.repository.NewsDbDataSource
import br.com.douglasmotta.hiltdependencyinjection.data.repository.NewsRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.main_fragment.*

@AndroidEntryPoint
class NewsFragment : Fragment(R.layout.main_fragment) {

    private val viewModel: NewsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.articlesEvent.observe(viewLifecycleOwner, Observer {
            with(recyclerArticles) {
                setHasFixedSize(true)
                adapter = NewsAdapter(it)
            }
        })
        viewModel.getNews()
    }
}
