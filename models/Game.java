package com.aplikacja.gry_sklep.models;


import javax.persistence.*;
import java.util.List;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String gameName;

    @Column
    private Float gameCost;

    @OneToMany(mappedBy = "game", cascade=CascadeType.REMOVE)
    private List<Comments> comments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public Float getGameCost() {
        return gameCost;
    }

    public void setGameCost(Float gameCost) {
        this.gameCost = gameCost;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }
}
