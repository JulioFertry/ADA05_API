package com.es.mongoapi.ADA05_API.repository

import com.es.mongoapi.ADA05_API.model.Task
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository


@Repository
interface TaskRepository: MongoRepository<Task, String> {
    fun findByUserId(userId: String): List<Task>
}
