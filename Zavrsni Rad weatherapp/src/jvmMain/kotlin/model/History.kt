package model

import org.ktorm.entity.Entity

interface History: Entity<History> {
    companion object: Entity.Factory<History>()
    val id: Int
    var location: String
    var userId: User
}