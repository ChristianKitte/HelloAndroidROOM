package de.ckitte.helloandroidroom

import java.util.*

interface IToDoItem {
    val titel: String
    val description: String
    val group: Int
    val isFavorite: Boolean
    val priority: Int
    val dueDate: Date?
    val isDone: Boolean
}

data class ToDoItem(
    override val titel: String,
    override val description: String,
    override val group: Int,
    override val isFavorite: Boolean = false,
    override val priority: Int,
    override val dueDate: Date?,
    override val isDone: Boolean = false
) : IToDoItem
