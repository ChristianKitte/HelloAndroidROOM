package de.ckitte.helloandroidroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import de.ckitte.helloandroidroom.entities.Director
import de.ckitte.helloandroidroom.entities.School
import de.ckitte.helloandroidroom.entities.SchoolDao
import de.ckitte.helloandroidroom.entities.Student

/*
Class References: The most basic reflection feature is getting the runtime
reference to a Kotlin class. To obtain the reference to a statically known
Kotlin class, you can use the class literal syntax:
*/

// ::class ist eine Referenz auf den Typ KClass.
@Database(
    entities = [
        School::class,
        Director::class,
        Student::class
    ],
    version = 2
)
abstract class SchoolDatabase : RoomDatabase() {
    abstract val schoolDao: SchoolDao

    companion object {
        //Schreibvorgänge werden durch Volatile sofort ausgeführt ==> vermindert
        //die Gefahr von Race Condition
        @Volatile
        private var instance: SchoolDatabase? = null

        fun getInstance(contect: Context): SchoolDatabase {
            //Locked die Datenbank
            synchronized(this) {
                return instance ?: Room.databaseBuilder(
                    contect.applicationContext,
                    SchoolDatabase::class.java,
                    "school_db"
                ).fallbackToDestructiveMigration().build().also {
                    instance = it
                }
            }
        }
    }
}
