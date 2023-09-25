package com.skel.test.cassandra.repository

import com.skel.test.cassandra.model.Tutorial
import org.springframework.data.cassandra.repository.AllowFiltering
import org.springframework.data.cassandra.repository.CassandraRepository
import java.util.UUID

interface TutorialRepository: CassandraRepository<Tutorial, UUID> {

    @AllowFiltering
    fun findByPublished(published: Boolean): List<Tutorial>
    fun findByTitleContaining(title: String): List<Tutorial>
}