package io.ipl.ipl_dashboard.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.ipl.ipl_dashboard.model.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {

    Team findByTeamName(String teamName);
    List<Team> findAll();
}
