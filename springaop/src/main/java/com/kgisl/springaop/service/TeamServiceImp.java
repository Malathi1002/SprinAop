package com.kgisl.springaop.service;

import java.util.List;

import javax.transaction.Transactional;

import com.kgisl.springaop.entity.Team;
import com.kgisl.springaop.repository.TeamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TeamServiceImp implements TeamService {

    @Autowired
    TeamRepository teamRepository;

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    public Team findByTeamId(Long id) {
        return teamRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found"));
    }

    public Team updateTeam(Long id,Team team) {
        return team;
       
    }

    public void deleteTeamById(Long id) {
        teamRepository.deleteById(id);
    }

}