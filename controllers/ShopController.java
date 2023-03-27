package com.aplikacja.gry_sklep.controllers;


import com.aplikacja.gry_sklep.models.Comments;
import com.aplikacja.gry_sklep.models.Game;
import com.aplikacja.gry_sklep.repos.CommentsRepository;
import com.aplikacja.gry_sklep.services.CommentsService;
import com.aplikacja.gry_sklep.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.stream.events.Comment;
import java.util.List;

@Controller
@RequestMapping(path = "/")
public class ShopController {

    @Autowired
    private ShopService ShopService;

    @Autowired
    private CommentsService CommentsService;

    @RequestMapping("/newgame")
    public String addNewGame(Model model) {
        Game game = new Game();
        model.addAttribute("game", game);

        return "newGameForm";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveGame(@ModelAttribute("Game") Game game) {
        ShopService.save(game);

        return "redirect:/";
    }

    @RequestMapping(value = "/saveComment", method = RequestMethod.POST)
    public String saveComments(@ModelAttribute("Comments") Comments comments) {
        CommentsService.save(comments);
        Integer gameId = comments.getGame().getId();
        return "redirect:/update/" + gameId;
    }

    @RequestMapping("/")
    public String startpage(Model model){
        model.addAttribute("games", ShopService.findAll());
        return "gameshop";
    }

    @RequestMapping("/delete/{id}")
    public String deleteGame(@PathVariable(name = "id") Integer id) {
        ShopService.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/deletecomment/{id}/{idgame}")
    public String deleteComment(@PathVariable(name = "id") Integer id, @PathVariable(name = "idgame") Integer idgame) {
        CommentsService.delete(id);
        return "redirect:/update/" + idgame;
    }

    @RequestMapping("/update/{id}")
    public ModelAndView updateGame(@PathVariable(name = "id") Integer id){
        ModelAndView viewEditedGames = new ModelAndView("editGameForm");
        Game game = ShopService.findById(id);
        Comments comments = new Comments();
        viewEditedGames.addObject("game", game);
        viewEditedGames.addObject("comments", comments);
        return viewEditedGames;
    }
}
