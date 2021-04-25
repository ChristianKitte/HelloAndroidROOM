package de.ckitte.helloandroidroom.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import de.ckitte.helloandroidroom.entities.School
import de.ckitte.helloandroidroom.entities.Student

data class SchoolAndStudents(
    @Embedded
    val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )

    val students: List<Student>
)
