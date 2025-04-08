package com.es.mongoapi.ADA05_API.model

import org.bson.codecs.pojo.annotations.BsonId
import org.springframework.data.mongodb.core.mapping.Document


@Document("User")
data class User(
    @BsonId
    val id: String?,
    val username: String,
    val password: String,
    val role: Role,
    val address: Address
) {

    override fun toString(): String {
        return "$username ($role)"
    }
}

enum class Role {
    USER, ADMIN
}
