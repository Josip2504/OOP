package model

import org.ktorm.entity.Entity

interface Animal: Entity<Animal> {
    companion object: Entity.Factory<Animal>()
    val id: Int
    var name: String
    var owner: Owner
}