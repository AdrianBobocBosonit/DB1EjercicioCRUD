package com.bosonit.DB1EjercicioCRUD.persona.infraestructure.controller;

import com.bosonit.DB1EjercicioCRUD.persona.application.PersonaService;
import com.bosonit.DB1EjercicioCRUD.persona.infraestructure.controller.input.PersonaCORSInputDTO;
import com.bosonit.DB1EjercicioCRUD.persona.infraestructure.controller.input.PersonaInputDTO;
import com.bosonit.DB1EjercicioCRUD.persona.infraestructure.controller.output.PersonaCORSOutputDTO;
import com.bosonit.DB1EjercicioCRUD.persona.infraestructure.controller.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CorsController {

    @Autowired
    PersonaService personaService;

    @CrossOrigin
    @PostMapping("/addperson")
    public PersonaOutputDTO addPerson(@RequestBody PersonaCORSInputDTO personaCORSInputDTO) throws Exception {
        System.out.println("OBTENGO LO SIGUIENTE: ");
        System.out.println(personaCORSInputDTO);
        PersonaInputDTO personaInputDTO = new PersonaInputDTO();
        personaInputDTO.setUsuario(personaCORSInputDTO.getUsuario());
        personaInputDTO.setPassword(personaCORSInputDTO.getPassword());
        personaInputDTO.setName(personaCORSInputDTO.getName());
        personaInputDTO.setSurname(personaCORSInputDTO.getSurname());
        personaInputDTO.setCompanyEmail(personaCORSInputDTO.getCompany_email());
        personaInputDTO.setPersonalEmail(personaCORSInputDTO.getPersonal_email());
        personaInputDTO.setCity(personaCORSInputDTO.getCity());
        personaInputDTO.setActive(personaCORSInputDTO.getActive());
        personaInputDTO.setCreatedDate(personaCORSInputDTO.getCreated_date());
        personaInputDTO.setImagenUrl(personaCORSInputDTO.getImagen_url());
        personaInputDTO.setTerminationDate(personaCORSInputDTO.getTermination_date());
        return personaService.addPersona(personaInputDTO);
    }

    @CrossOrigin
    @GetMapping("/getall")
    public List<PersonaCORSOutputDTO> getall() {
        return personaService.getAllPersonCORS();
    }
}
