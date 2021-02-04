/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author espin
 */
@Entity
@Table(name = "team")
public class Team implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "name")
    private String name;
     @Column(name = "image")
    private String image;
    @Column(name = "games")
    private Long games;
    @Column(name = "matcheswon")
    private Long matcheswon;
    @Column(name = "lostmatches")
    private Long lostmatches;
    @Column(name = "tiedmatches")
    private Long tiedmatches;
    @Column(name = "goals")
    private Long goals;
    @Column(name = "goalsc")
    private Long goalsc;
    @Column(name = "createdate")
    private Long createdate;
    
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    protected List<Player> repertorio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getGames() {
        return games;
    }

    public void setGames(Long games) {
        this.games = games;
    }

    public Long getMatcheswon() {
        return matcheswon;
    }

    public void setMatcheswon(Long matcheswon) {
        this.matcheswon = matcheswon;
    }

    public Long getLostmatches() {
        return lostmatches;
    }

    public void setLostmatches(Long lostmatches) {
        this.lostmatches = lostmatches;
    }

    public Long getTiedmatches() {
        return tiedmatches;
    }

    public void setTiedmatches(Long tiedmatches) {
        this.tiedmatches = tiedmatches;
    }

    public Long getGoals() {
        return goals;
    }

    public void setGoals(Long goals) {
        this.goals = goals;
    }

    public Long getGoalsc() {
        return goalsc;
    }

    public void setGoalsc(Long goalsc) {
        this.goalsc = goalsc;
    }

    public Long getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Long createdate) {
        this.createdate = createdate;
    }

    public List<Player> getRepertorio() {
        return repertorio;
    }

    public void setRepertorio(List<Player> repertorio) {
        this.repertorio = repertorio;
    }
    
    
}
