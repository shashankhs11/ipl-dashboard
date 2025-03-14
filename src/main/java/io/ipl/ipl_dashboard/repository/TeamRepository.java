package io.ipl.ipl_dashboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.ipl.ipl_dashboard.model.Team;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    Team findByTeamName(String teamName);
    List<Team> findAll();
}
