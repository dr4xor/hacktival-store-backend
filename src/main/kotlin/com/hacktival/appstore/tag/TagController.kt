package com.hacktival.appstore.tag

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/tags")
class TagController {

    lateinit var tagService: TagService

    @GetMapping()
    fun get(): Collection<TagDTO> {
        return tagService.findAll()
    }
}