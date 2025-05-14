package com.example.tuwaiqfinalproject.Service;

import com.example.tuwaiqfinalproject.Api.ApiException;
import com.example.tuwaiqfinalproject.Model.Field;
import com.example.tuwaiqfinalproject.Model.Organizer;
import com.example.tuwaiqfinalproject.Model.PublicMatch;
import com.example.tuwaiqfinalproject.Model.Team;
import com.example.tuwaiqfinalproject.Repository.OrganizerRepository;
import com.example.tuwaiqfinalproject.Repository.PublicMatchRepository;
import com.example.tuwaiqfinalproject.Repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;
    private final PublicMatchRepository publicMatchRepository;
    private final OrganizerRepository organizerRepository;

    public List<Team>getAllTeam(){
        return teamRepository.findAll();
    }

    // 57. Faisal - Get team by id - Tested
    public Team getTeamById(Integer id){
        return teamRepository.findTeamById(id);
    }

    // 21. Taha - Add team for a public match - Tested
    public void addTeamsForPublicMatch(Integer userId, Integer publicMatchId){
        Organizer organizer = organizerRepository.findOrganizerById(userId);
        if(organizer== null)
            throw new ApiException("Organizer not found");
        PublicMatch publicMatch= publicMatchRepository.findPublicMatchById(publicMatchId);
        if(publicMatch== null)
            throw new ApiException("PublicMatch not found");
        Field field = publicMatch.getField();
        if (field == null)
            throw new ApiException("Field not assigned to this PublicMatch");

        // Create two teams and assign to match
        Team teamA = new Team();
        teamA.setName("Team A");
        teamA.setPlayersCount(0);
        teamA.setMax_players_count(field.getCapacity() / 2);
        teamA.setPublic_match(publicMatch);

        Team teamB = new Team();
        teamB.setName("Team B");
        teamB.setPlayersCount(0);
        teamB.setMax_players_count(field.getCapacity() / 2);
        teamB.setPublic_match(publicMatch);

        teamRepository.save(teamA);
        teamRepository.save(teamB);

        publicMatch.getTeams().add(teamA);
        publicMatch.getTeams().add(teamB);
        publicMatchRepository.save(publicMatch);
    }

    public void updateTeam(Integer userId, Integer teamId, Team updatedTeam) {
        Organizer organizer = organizerRepository.findOrganizerById(userId);
        if (organizer == null)
            throw new ApiException("Organizer not found");

        Team oldTeam = teamRepository.findTeamById(teamId);
        if (oldTeam == null)
            throw new ApiException("Team not found");

        PublicMatch match = oldTeam.getPublic_match();
        if (match == null || !match.getField().getOrganizer().getId().equals(organizer.getId()))
            throw new ApiException("You are not allowed to update a team that doesn't belong to your match");

        // Update only allowed fields
        oldTeam.setName(updatedTeam.getName());
        oldTeam.setPlayersCount(updatedTeam.getPlayersCount());

        teamRepository.save(oldTeam);
    }

    public void deleteTeam(Integer userId, Integer teamId) {
        Organizer organizer = organizerRepository.findOrganizerById(userId);
        if (organizer == null)
            throw new ApiException("Organizer not found");

        Team team = teamRepository.findTeamById(teamId);
        if (team == null)
            throw new ApiException("Team not found");

        PublicMatch match = team.getPublic_match();
        if (match == null || !match.getField().getOrganizer().getId().equals(organizer.getId()))
            throw new ApiException("You are not allowed to delete a team that doesn't belong to your match");

        teamRepository.delete(team);
    }

}
