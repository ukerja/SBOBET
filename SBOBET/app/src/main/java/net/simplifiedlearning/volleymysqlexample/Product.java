package net.simplifiedlearning.volleymysqlexample;

/**
 * Created by Belal on 10/18/2017.
 */

public class Product {

    private final String league_name;
    private final String home_team;
    private final String away_team;
    private final String status;
    private final String score;

    public Product( String league_name, String home_team, String away_team, String status, String score) {


        this.league_name = league_name;
        this.home_team = home_team;
        this.away_team = away_team;
        this.status = status;
        this.score = score;
    }





    public String getLeague_name() {
        return league_name;
    }

    public String getHome_team() {
        return home_team;
    }

    public String getAway_team() {
        return away_team;
    }

    public String getStatus() {
        return status;
    }

    public String getScore() {
        return score;
    }
}
