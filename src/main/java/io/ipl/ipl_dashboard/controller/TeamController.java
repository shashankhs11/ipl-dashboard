package io.ipl.ipl_dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.ipl.ipl_dashboard.model.Team;
import io.ipl.ipl_dashboard.repository.TeamRepository;

@RestController
public class TeamController {


    @Autowired
    public TeamRepository teamRepository;


    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName) {
        // System.out.println("Requested teamName: " + teamName);

        Team team = teamRepository.findByTeamName(teamName);

        System.out.println("team: " + team);

        List<Team> allTeams = teamRepository.findAll();
        System.out.println("All teams in DB at request time: " + allTeams);
        // if (team == null) {
        //     List<Team> allTeams = teamRepository.findAll();
        //     System.out.println("All teams in DB at request time: " + allTeams);
        // }
        return team;
    }
}
