package org.apache.maven.archetypes.maven_archetype_quickstart.controller;

import org.apache.maven.archetypes.maven_archetype_quickstart.repositories.TicketRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
public class DrawingServiceController {
    TicketRepository ticketRepo = new TicketRepository();
    @RequestMapping(
            value = "/status",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public String status() {
        return "{\"status\":\"Greetings from Spring Boot. "
                + LocalDate.now() + ", "
                + LocalTime.now()
                + ". " + "The server is Runnig!\"}";
    }
    @GetMapping("/getticket")

     public String getTicket() {

        return "{\"ticket\":\"" +
     ticketRepo.getTicket() + "\"}";
 }
}
