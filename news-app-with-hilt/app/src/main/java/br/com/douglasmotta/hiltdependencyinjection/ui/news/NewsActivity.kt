package br.com.douglasmotta.hiltdependencyinjection.ui.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.douglasmotta.hiltdependencyinjection.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }
}
