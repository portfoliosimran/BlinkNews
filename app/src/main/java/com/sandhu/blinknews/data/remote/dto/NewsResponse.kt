package com.sandhu.blinknews.data.remote.dto

import com.sandhu.blinknews.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)