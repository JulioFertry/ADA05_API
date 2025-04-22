package com.es.mongoapi.ADA05_API.controller

import com.es.mongoapi.ADA05_API.model.Task
import com.es.mongoapi.ADA05_API.repository.TaskRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/task")
class TaskController(private val taskRepository: TaskRepository) {

    @PostMapping
    fun createTask(@RequestBody task: Task): ResponseEntity<Task> {
        val savedTask = taskRepository.save(task)
        return ResponseEntity.ok(savedTask)
    }

}
