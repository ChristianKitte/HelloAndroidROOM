package de.ckitte.helloandroidroom.entities

import androidx.room.*
import de.ckitte.helloandroidroom.entities.relations.SchoolAndDirector
import de.ckitte.helloandroidroom.entities.relations.SchoolAndStudents

@Dao
interface SchoolDao {
    //https://blog.codecentric.de/2018/05/einfuehrung-in-kotlin-coroutines/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Transaction //kapselt den Vorgang in einer Transaction
    @Query("select * from school where schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String): List<SchoolAndDirector>

    @Transaction //kapselt den Vorgang in einer Transaction
    @Query("select * from school where schoolName = :schoolName")
    suspend fun getSchoolAndStudents(schoolName: String): List<SchoolAndStudents>
}
