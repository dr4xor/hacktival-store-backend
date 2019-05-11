package com.hacktival.appstore.app

import com.hacktival.appstore.tag.TagDTO

class AppDTO (
    var id: Long = 0,
    var link: String = "",
    var score: Long = 0,
    var tags: List<TagDTO> = mutableListOf<TagDTO>()
)

class CreateAppDTO (
        var link: String,
        var tags: List<Long>
)

class SocketAppDTO (
        var id: Long,
        var isUpVote: Boolean
)
