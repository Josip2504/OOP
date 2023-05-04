package model

import org.ktorm.entity.Entity

interface Odjel: Entity<Odjel> {
    companion object: Entity.Factory<User>()
    val id: Int
    var name: String
    var user: User
}