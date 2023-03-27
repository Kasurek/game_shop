package com.aplikacja.gry_sklep.services;


import com.aplikacja.gry_sklep.models.Game;
import com.aplikacja.gry_sklep.repos.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    @Autowired
    private GameRepository GameRepository;

    public void delete(Integer id) { GameRepository.deleteById(id);}
    public void save(Game game) {GameRepository.save(game);}

    public List<Game> findAll() {
        return GameRepository.findAll();
    }


    public Game findById(Integer id){return GameRepository.findById(id).get();}
}
