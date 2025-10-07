package com.sandhu.blinknews.presentation.search

import androidx.paging.PagingData
import com.sandhu.blinknews.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
) {
}