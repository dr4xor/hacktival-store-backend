package com.hacktival.appstore.tag

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TagService {

    @Autowired
    lateinit var tagRepository: TagRepository

    fun findAll(): Collection<TagDTO> {
        return tagRepository.findAll().map { it.toDto() }
    }
}