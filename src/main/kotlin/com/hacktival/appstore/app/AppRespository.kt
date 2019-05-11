package com.hacktival.appstore.app

import org.springframework.data.jpa.repository.JpaRepository

interface AppRepository : JpaRepository<App, Long> {
    fun findAllByOrderByScoreDesc(): List<App>
}