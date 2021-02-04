/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Controllers;

import App.Exceptions.RecordNotFoundException;
import App.Model.Player;
import App.Services.PlayerService;
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
@RequestMapping("/player")
public class PlayerServiceController {
     @Autowired
    PlayerService service;
 
    @GetMapping
    public ResponseEntity<List<Player>> getAllItems() {
        List<Player> list = service.getAllItems();
 
        return new ResponseEntity<List<Player>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Player> getItemById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
    	Player entity = service.getPlayerById(id);
 
        return new ResponseEntity<Player>(entity, new HttpHeaders(), HttpStatus.OK);
    }
    
    @GetMapping("/search/{name}")
    public ResponseEntity<List<Player>> getItemsByTitle(@PathVariable("name") String title) {
    	List<Player> list = service.getPlayerByTitle(title);
 
        return new ResponseEntity<List<Player>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
   @PostMapping
    public ResponseEntity<Player> createItem(@Valid @RequestBody Player myItem){
    	Player created = service.createPlayer(myItem);
        return new ResponseEntity<Player>(created, new HttpHeaders(), HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<Player> UpdateItem(@Valid @RequestBody Player myItem)
                                                    throws RecordNotFoundException {
    	Player updated = service.createPlayer(myItem);
        return new ResponseEntity<Player>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteItemById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        service.deletePlayerById(id);
        return HttpStatus.ACCEPTED;
    }
}
