package org.bedu.s2.controllers;

import org.bedu.s2.dto.ContactoDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class AgendaController {


    private HashMap<String, String> agenda;

    public AgendaController() {
        agenda = new HashMap<>();

        agenda.put("Juan", "55-1234-5678");
        agenda.put("Pedro", "55-8765-4321");
    }

    @RequestMapping("/obtenerAgenda")
    public List<ContactoDTO> obtenerAgenda() {
        return agenda.entrySet().stream()
                .map(e -> new ContactoDTO(e.getKey(), e.getValue()))
                .collect(java.util.stream.Collectors.toList());
    }
}
