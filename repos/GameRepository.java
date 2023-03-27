package com.aplikacja.gry_sklep.repos;

import com.aplikacja.gry_sklep.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {
}
