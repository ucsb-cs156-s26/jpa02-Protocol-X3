package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_correct_value() {
        //case 1: same object (obj == this)
        Team other = team;
        assertEquals(true, team.equals(other));

        //case 2: different object
        Object notATeam = new Object();
        assertEquals(false, team.equals(notATeam));

        //case 3-1: same name same members
        other = new Team("test-team");
        assertEquals(true, team.equals(other));

        //case 3-2: different name same members
        other = new Team("other-team");
        assertEquals(false, team.equals(other));

        //case 3-3: same name different members
        other = new Team("test-team");
        other.setMembers(new ArrayList<>(Arrays.asList("member1")));
        assertEquals(false, team.equals(other));
    }

    @Test
    public void hashCode_returns_correct_value() {
        //case 1: same object (obj == this)
        Team other = team;
        assertEquals(true, team.hashCode() == other.hashCode());

        //case 2-1: same name same members
        assertEquals(true, team.hashCode() == new Team("test-team").hashCode());

        //case 2-2: different name
        assertEquals(false, team.hashCode() == new Team("other-team").hashCode());

        //case 2-3: same name different members
        other = new Team("test-team");
        other.setMembers(new ArrayList<>(Arrays.asList("member1")));
        assertEquals(false, team.hashCode() == other.hashCode());
    }
}
