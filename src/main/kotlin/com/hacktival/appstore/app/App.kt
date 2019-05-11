package com.hacktival.appstore.app

import com.hacktival.appstore.tag.Tag
import javax.persistence.*

@Entity
@Table(name = "APP")
class App (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        var link: String = "",
        var score: Long = 0,
        @ManyToMany(cascade = arrayOf(CascadeType.ALL))
        @JoinTable(
                name = "APP_TAG",
                joinColumns = arrayOf(JoinColumn(name = "APP_ID", referencedColumnName = "ID")),
                inverseJoinColumns = arrayOf(JoinColumn(name = "TAG_ID", referencedColumnName = "ID"))
        )
        var tags: List<Tag> = mutableListOf<Tag>()
) {
        fun toDto(): AppDTO = AppDTO(
                id = this.id!!,
                link = this.link,
                score = this.score,
                tags = this.tags?.map { it.toDto() }
        )

        companion object {
            fun fromDto(dto: CreateAppDTO) = App(
                    link = dto.link
            )
        }
}