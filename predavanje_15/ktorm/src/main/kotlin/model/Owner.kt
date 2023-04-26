package model

import org.ktorm.entity.Entity

interface Owner: Entity<Owner> {
    companion object: Entity.Factory<Owner>()
    val id: Int
    var name: String
}