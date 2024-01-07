package com.example.foxminded_newsfeed.domain.usecase

import com.example.foxminded_newsfeed.domain.model.NewsItem
import com.example.foxminded_newsfeed.domain.repository.NewsRepository

class GetFavoriteNews(private val newsRepository : NewsRepository) {
    suspend fun get(): List<NewsItem>{
        return newsRepository.getFavoriteNews()
    }

}