package com.aplikacja.gry_sklep.services;


import com.aplikacja.gry_sklep.models.Comments;
import com.aplikacja.gry_sklep.repos.CommentsRepository;
import com.aplikacja.gry_sklep.repos.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {

    @Autowired
    private CommentsRepository CommentsRepository;

    public void delete(Integer id) { CommentsRepository.deleteById(id);}
    public void save(Comments comments) {CommentsRepository.save(comments);}

    public List<Comments> findAll() {
        return CommentsRepository.findAll();
    }

    public Comments findById(Integer id){return CommentsRepository.findById(id).get();}

}
