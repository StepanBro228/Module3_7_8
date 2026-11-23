package com.example.module2_7_8

import com.example.module2_7_8.domain.model.TodoItem
import com.example.module2_7_8.domain.repository.TodoRepository
import com.example.module2_7_8.domain.usecase.GetTodosUseCase
import com.example.module2_7_8.domain.usecase.ToggleTodoUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class FakeTodoRepository : TodoRepository {
    private var todos = listOf(
        TodoItem(1, "Купить молоко", "2 литра, обезжиренное", false),
        TodoItem(2, "Позвонить маме", "Спросить про выходные", true),
        TodoItem(3, "Сделать ДЗ по Android", "Clean Architecture + Compose", false)
    )

    override suspend fun getTodos(): List<TodoItem> = todos

    override suspend fun toggleTodo(id: Int) {
        todos = todos.map { if (it.id == id) it.copy(isCompleted = !it.isCompleted) else it }
    }
}

class TodoUseCaseTest {
    @Test
    fun getTodosUseCase_returns3Todos() = runBlocking {
        val useCase = GetTodosUseCase(FakeTodoRepository())
        assertEquals(3, useCase().size)
    }

    @Test
    fun toggleTodo_changesIsCompleted() = runBlocking {
        val repository = FakeTodoRepository()
        ToggleTodoUseCase(repository)(1)
        val todo = GetTodosUseCase(repository)().first { it.id == 1 }
        assertTrue(todo.isCompleted)
    }
}
