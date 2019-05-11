package com.hacktival.appstore.app

import com.hacktival.appstore.tag.Tag
import com.hacktival.appstore.tag.TagRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AppService {

    @Autowired
    lateinit var appRepository: AppRepository

    @Autowired
    lateinit var tagRepository: TagRepository

    fun findAll(): Collection<AppDTO> {
        return appRepository.findAllByOrderByScoreDesc().map {it.toDto()}
    }

    fun findById(id: Long): AppDTO? {
        val app = appRepository.findById(id)
        return if (app.isPresent) app.get().toDto()
        else null
    }

    fun create(dto: CreateAppDTO): AppDTO {
        val tags: MutableList<Tag> = mutableListOf<Tag>()
        for (id: Long in dto.tags) {
            val tag = tagRepository.findById(id)
            if (tag.isPresent) tags.add(tag.get())
        }
        val app = App.fromDto(dto)
        app.tags = tags
        return appRepository.save(app).toDto()
    }

    fun vote(id: Long, isUpVote: Boolean): AppDTO? {
        val appOptional = appRepository.findById(id)
        if (appOptional.isPresent) {
            val app = appOptional.get()
            if (isUpVote) {
                app.score = app.score + 1
            } else {
                app.score = app.score - 1
            }
            return appRepository.save(app).toDto()
        }
        return null
    }
}