package com.example.foxminded_newsfeed.data.network

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "feed", strict = false)
data class RedditRssResponse(
    @field:ElementList(inline = true, name = "item", required = false)
    var items: List<RssItem>? = null
)