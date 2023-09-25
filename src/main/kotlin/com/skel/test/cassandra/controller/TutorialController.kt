package com.skel.test.cassandra.controller

import com.skel.test.cassandra.model.Tutorial
import com.skel.test.cassandra.repository.TutorialRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.function.Consumer


@RestController
@RequestMapping("/api")
class TutorialController(
    private val tutorialRepository: TutorialRepository
) {

    @PostMapping("/tutorials")
    fun createTutorial(@RequestBody tutorial: Tutorial): ResponseEntity<Tutorial?>? {
        return try {
            val tutorial1: Tutorial =
                tutorialRepository.save(Tutorial(UUID.randomUUID(), tutorial.title, tutorial.description, false))
            ResponseEntity<Tutorial?>(tutorial1, HttpStatus.CREATED)
        } catch (e: Exception) {
            println (e)
            ResponseEntity<Tutorial?>(null, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/tutorials")
    fun getAllTutorials(@RequestParam(required = false) title: String?): ResponseEntity<List<Tutorial>> {
        return try {

            val tutorials = if (title == null) {
                tutorialRepository.findAll()
            } else {
                tutorialRepository.findByTitleContaining(title)
            }

            if (tutorials.isEmpty()) {
                ResponseEntity<List<Tutorial>>(HttpStatus.NO_CONTENT)
            } else ResponseEntity(tutorials, HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity<List<Tutorial>>(null, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

}