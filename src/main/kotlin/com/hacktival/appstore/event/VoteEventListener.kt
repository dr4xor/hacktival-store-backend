package com.hacktival.appstore.event

import com.hacktival.appstore.app.AppService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class LivePreviewEventListener {

    @Autowired
    lateinit var appService: AppService

    @EventListener
    fun handle(event: VoteEvent) {
        appService!!.sendVoteUpdate(event.app)
    }
}
