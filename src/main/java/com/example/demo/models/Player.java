package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name="players_details")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Enumerated(EnumType.STRING)
    private Team team;
    public enum Team {
        CSK,
        MI,
        DC

    }
    // default constructor
    public Player(){

    }
    }


