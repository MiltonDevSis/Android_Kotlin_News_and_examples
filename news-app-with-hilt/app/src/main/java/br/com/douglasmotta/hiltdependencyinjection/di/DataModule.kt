package br.com.douglasmotta.hiltdependencyinjection.di

import br.com.douglasmotta.hiltdependencyinjection.data.repository.NewsApiDataSource
import br.com.douglasmotta.hiltdependencyinjection.data.repository.NewsRepository
import br.com.douglasmotta.hiltdependencyinjection.data.repository.NewsRepositoryInterface
import br.com.douglasmotta.hiltdependencyinjection.data.repository.NewsRetrofitApiDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Singleton
    @Binds
    abstract fun bindNewsrepository(
        newRepository: NewsRepository
    ): NewsRepositoryInterface

    @Singleton
    @Binds
    abstract fun bindApiDataSource(
        apiDataSource: NewsRetrofitApiDataSource
    ): NewsApiDataSource
}