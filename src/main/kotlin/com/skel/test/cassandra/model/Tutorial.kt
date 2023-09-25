package com.skel.test.cassandra.model

import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table
import java.util.UUID

@Table
data class Tutorial(
    @PrimaryKey
    val id: UUID?,
    var title: String,
    var description: String,
    var published: Boolean?,
)