package org.bedu.s3.service;

import org.bedu.s3.dto.CreateTodoDTO;
import org.bedu.s3.dto.TodoDTO;
import org.bedu.s3.model.Todo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;


@Service
public class TodoService {

    private List<Todo> todos;
    private Long idCounter = 1L;

    public TodoService(){
        todos = new LinkedList<>();
        todos.add(new Todo(1L, "Tarea 1", "Descripción de la tarea 1", false));
    }

    public List<TodoDTO> getTodos(){
        return this.todos.stream().map(todo -> {
            TodoDTO dto = new TodoDTO();
            dto.setId(todo.getId());
            dto.setTitle(todo.getTitle());
            dto.setDescription(todo.getDescription());
            dto.setCompleted(todo.isCompleted());
            return dto;
        }).collect(java.util.stream.Collectors.toList());
    }

    public TodoDTO createTodo(CreateTodoDTO data){
        // Conversion de DTO a modelo
        // Model es como almeceno los datos
        // DTO es como recibo los datos en el controlador y como los regreso
        Todo model = new Todo(
                idCounter++,
                data.getTitle(),
                data.getDescription(),
                false
        );

        TodoDTO dto = new TodoDTO();
        dto.setId(model.getId());
        dto.setTitle(model.getTitle());
        dto.setDescription(model.getDescription());
        dto.setCompleted(model.isCompleted());

        return dto;
    }
}
