package org.bedu.s3.controller;

import org.bedu.s3.dto.CreateTodoDTO;
import org.bedu.s3.dto.TodoDTO;
import org.bedu.s3.model.Todo;
import org.bedu.s3.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;


    // Obtener todas las tareas
    @RequestMapping("/todos")
    public List<TodoDTO> getTodos(){
        return todoService.getTodos();
    }

    /*
     * Una API tiene 4 maneras de recibir parámetros:
     *
     *  1. Utilizando el Query String
     *     http://localhost:8080/todos?title=Tarea%201
     *  El query string se utiliza mas para filtrado de datosm dichos son Opciones
     *
     *  2. Utilizando el PATH VARIABLE
     *    http://localhost:8080/todos/1
     * El path variable se utiliza para obtener un recurso en específico
     *
     *  3. Utilando el REQUEST BODY
     *
     *  4. Utilizando el HEADER
     *
     */
    // Crear una tarea
    @RequestMapping(value = "/todos", method = RequestMethod.POST)
    public TodoDTO createTodo(@Valid @RequestBody CreateTodoDTO data){

        return todoService.createTodo(data);
    }

    // Marcar como completada una tarea

    // Obtener una solo tarea(por identificador)
}
