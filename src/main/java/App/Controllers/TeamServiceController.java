/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Controllers;

import App.Exceptions.RecordNotFoundException;
import App.Model.Team;
import App.Services.PlayerService;
import App.Services.TeamService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author espin
 */
@RestController
@RequestMapping("/team")
public class TeamServiceController {
    @Autowired
    TeamService service;
 
    @GetMapping
    public ResponseEntity<List<Team>> getAllItems() {
        List<Team> list = service.getAllTeams();
 
        return new ResponseEntity<List<Team>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Team> getItemById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
    	Team entity = service.getTeamById(id);
 
        return new ResponseEntity<Team>(entity, new HttpHeaders(), HttpStatus.OK);
    }
    
    @GetMapping("/search/{name}")
    public ResponseEntity<List<Team>> getItemsByTitle(@PathVariable("name") String title) {
    	List<Team> list = service.geteTeamByTitle(title);
 
        return new ResponseEntity<List<Team>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
   @PostMapping
    public ResponseEntity<Team> createItem(@Valid @RequestBody Team myItem){
    	Team created = service.createTeam(myItem);
        return new ResponseEntity<Team>(created, new HttpHeaders(), HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<Team> UpdateItem(@Valid @RequestBody Team myItem)
                                                    throws RecordNotFoundException {
    	Team updated = service.createTeam(myItem);
        return new ResponseEntity<Team>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteItemById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        service.deleteTeamById(id);
        return HttpStatus.ACCEPTED;
    }
}
