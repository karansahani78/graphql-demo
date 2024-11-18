package com.example.demo.controller;

import com.example.demo.models.Player;
import com.example.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @QueryMapping
    // creating a method to find all the players
    public List<Player> findAll() {
        return playerService.findAll();
    }
    @QueryMapping
    public Optional<Player>findById(Long id){
        return playerService.findPlayerById(id);
    }

    @MutationMapping
    public Player createPlayer(String name, Player.Team team) {
        return playerService.createPlayer(name, team);
    }
    @MutationMapping
    public Player updatePlayer(Long id, String name, Player.Team team){
        return updatePlayer(id, name, team);
    }

    // Mutation to delete a player by id
    @MutationMapping
    public void deletePlayer(Long id) {
       playerService.deleteById(id);
    }
}


