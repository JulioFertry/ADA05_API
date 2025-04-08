package com.es.mongoapi.ADA05_API.repository

import com.es.mongoapi.ADA05_API.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.Optional


@Repository
interface UserRepository: MongoRepository<User, String> {
    fun findByUsername(username: String): Optional<User>
}
