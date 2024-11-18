package com.example.demo.service;

import com.example.demo.models.Player;
import com.example.demo.repo.PlayerRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepo playerRepo;

    // CREATE PLAYER
    public Player createPlayer(String name, Player.Team team) {
        Player player = new Player();
        player.setTeam(team);
        player.setName(name);
        return player;
    }
        // GET ALL PLAYER
    public List<Player> findAll(){
        return playerRepo.findAll();
    }
        // GET PLAYER BY ID
    public Optional<Player>findPlayerById(Long id){
        return playerRepo.findById(id);
    }
        // UPDATE PLAYER
    public Player updatePlayer(Long id,String name, Player.Team team){
        Player existingPlayer = playerRepo.findById(id).orElseThrow(()->new EntityNotFoundException("Player not found for given id"+id));
        if(name!=null){
            existingPlayer.setName(name);
        }
        if(team!=null){
            existingPlayer.setTeam(team);
        }
        return playerRepo.save(existingPlayer);
    }
        // DELETE PLAYER
    public  void deleteById(Long id){
        playerRepo.findById(id).orElseThrow(()->new EntityNotFoundException("Player not found for given id"+id));
        playerRepo.deleteById(id);
    }
    }

