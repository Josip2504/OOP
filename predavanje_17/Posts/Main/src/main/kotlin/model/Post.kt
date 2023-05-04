package model

import org.ktorm.entity.Entity

interface Post:Entity<Post> {
    companion object: Entity.Factory<Post>()
    val id: Int
    var name: String
    var user: User
}