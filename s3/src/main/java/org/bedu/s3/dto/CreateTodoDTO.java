package org.bedu.s3.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateTodoDTO {

    @NotBlank
    @Size(max=100)
    private String title;

    @NotBlank
    @Size(max=250)
    private String description;


    public CreateTodoDTO() {
    }

    public CreateTodoDTO(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }
}
