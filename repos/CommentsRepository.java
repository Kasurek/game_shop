package com.aplikacja.gry_sklep.repos;

import com.aplikacja.gry_sklep.models.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Integer> {
}
