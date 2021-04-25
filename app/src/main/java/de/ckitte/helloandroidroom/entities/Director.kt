package de.ckitte.helloandroidroom.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Director(
    @PrimaryKey(autoGenerate = false)
    val directorName: String,
    val schoolName: String
)
