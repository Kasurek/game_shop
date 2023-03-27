package com.aplikacja.gry_sklep.models;

import javax.persistence.*;

@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String Comment;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="GAME_ID")
    private Game game;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
