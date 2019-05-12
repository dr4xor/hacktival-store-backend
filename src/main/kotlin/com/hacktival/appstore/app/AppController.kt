package com.hacktival.appstore.app

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/apps")
class AppController {

    @Autowired
    lateinit var appService: AppService;

    @GetMapping()
    fun get(): Collection<AppDTO> {
        return appService.findAll()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): AppDTO? {
        return appService.findById(id)
    }

    @PostMapping()
    fun create(@RequestBody dto: CreateAppDTO): AppDTO {
        return appService.create(dto)
    }

    @PostMapping("/{id}")
    fun vote(@PathVariable id: Long, @RequestParam("isUpVote") isUpVote: Boolean): AppDTO? {
        return appService.vote(id, isUpVote)
    }
}
