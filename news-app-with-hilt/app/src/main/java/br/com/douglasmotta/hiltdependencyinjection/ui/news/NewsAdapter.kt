package br.com.douglasmotta.hiltdependencyinjection.ui.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.douglasmotta.hiltdependencyinjection.R
import br.com.douglasmotta.hiltdependencyinjection.data.model.Article
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_article.view.*

class NewsAdapter(
    private val articles: List<Article>
) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_article, parent, false)

        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int = articles.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(articles[position])
    }

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageArticle = itemView.imageArticle
        private val textArticleTitle = itemView.textArticleTitle
        private val textArticleDescription = itemView.textArticleDescription
        private val textArticleSource = itemView.textArticleSource

        fun bind(article: Article) {
            textArticleTitle.text = article.title
            textArticleDescription.text = article.description
            textArticleSource.text = article.source.name

            Glide
                .with(itemView)
                .load(article.urlToImage)
                .centerCrop()
                .into(imageArticle)
        }
    }
}