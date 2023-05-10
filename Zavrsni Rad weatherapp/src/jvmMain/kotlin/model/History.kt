package model

import org.ktorm.entity.Entity

interface History: Entity<History> {
    companion object: Entity.Factory<History>()
    val id: Int
    var user: String
    var location: String
    var userId: User
}