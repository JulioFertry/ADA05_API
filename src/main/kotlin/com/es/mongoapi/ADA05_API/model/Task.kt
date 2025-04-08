package com.es.mongoapi.ADA05_API.model

import org.bson.codecs.pojo.annotations.BsonId
import org.springframework.data.mongodb.core.mapping.Document


@Document("Task")
data class Task(
    @BsonId
    val id: String? = null,
    val userId: String,
    val title: String,
    val description: String,
    val completed: Boolean
) {

    override fun toString(): String {
        return "$title: ${if (completed) "Completado" else "Pendiente"}" +
                "\n$description"
    }
}
