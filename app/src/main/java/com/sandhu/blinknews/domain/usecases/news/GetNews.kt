package com.sandhu.blinknews.domain.usecases.news

import androidx.paging.PagingData
import com.sandhu.blinknews.domain.model.Article
import com.sandhu.blinknews.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = sources)

    }
}