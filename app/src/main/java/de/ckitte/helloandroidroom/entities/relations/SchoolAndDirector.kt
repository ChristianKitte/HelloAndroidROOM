package de.ckitte.helloandroidroom.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import de.ckitte.helloandroidroom.entities.Director
import de.ckitte.helloandroidroom.entities.School

//Helferklasse
data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )

    val director: Director
)
