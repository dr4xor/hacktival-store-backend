package com.hacktival.appstore.tag

import javax.persistence.*

@Entity
@Table(name = "TAG")
class Tag (
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,
    var name: String = ""
) {
    fun toDto(): TagDTO = TagDTO(
            id = this.id!!,
            name = this.name
    )
}