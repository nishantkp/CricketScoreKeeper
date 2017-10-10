package com.example.android.cricketscorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    int teamARuns = 0, teamABalls = 0, teamAOut = 0;
    int teamBRuns = 0, teamBBalls = 0, teamBOut = 0;
    double teamAStrikeRate = 0.0;
    double teamBStrikeRate = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Update runs by +1 for Team A
     */
    public void teamAOneRun(View v) {
        teamARuns += 1;
        displayForTeamA(teamARuns, 1);
    }

    /**
     * Update runs by +2 for Team A
     */
    public void teamATwoRun(View v) {
        teamARuns += 2;
        displayForTeamA(teamARuns, 1);
    }

    /**
     * Update runs by +3 for Team A
     */
    public void teamAThreeRun(View v) {
        teamARuns += 3;
        displayForTeamA(teamARuns, 1);
    }

    /**
     * Update runs by +4 for Team A
     */
    public void teamAFourRun(View v) {
        teamARuns += 4;
        displayForTeamA(teamARuns, 1);
    }

    /**
     * Update runs by +6 for Team A
     */
    public void teamASixRun(View v) {
        teamARuns += 6;
        displayForTeamA(teamARuns, 1);
    }

    /**
     * Update out by +1 for Team A
     */
    public void teamAOut(View v) {
        teamAOut += 1;
        displayForTeamA(teamAOut, 2);
    }

    /**
     * Update balls by +1 for Team A
     */
    public void teamABallCount(View v) {
        teamABalls += 1;
        displayForTeamA(teamABalls, 3);
    }


    /**
     * Update runs by +1 for Team B
     */
    public void teamBOneRun(View v) {
        teamBRuns += 1;
        displayForTeamB(teamBRuns, 1);
    }

    /**
     * Update runs by +2 for Team B
     */
    public void teamBTwoRun(View v) {
        teamBRuns += 2;
        displayForTeamB(teamBRuns, 1);
    }

    /**
     * Update runs by +3 for Team B
     */
    public void teamBThreeRun(View v) {
        teamBRuns += 3;
        displayForTeamB(teamBRuns, 1);
    }

    /**
     * Update runs by +4 for Team B
     */
    public void teamBFourRun(View v) {
        teamBRuns += 4;
        displayForTeamB(teamBRuns, 1);
    }

    /**
     * Update runs by +6 for Team B
     */
    public void teamBSixRun(View v) {
        teamBRuns += 6;
        displayForTeamB(teamBRuns, 1);
    }

    /**
     * Update out by +1 for Team B
     */
    public void teamBOut(View v) {
        teamBOut += 1;
        displayForTeamB(teamBOut, 2);
    }

    /**
     * Update balls by +1 for Team B
     */
    public void teamBBallCount(View v) {
        teamBBalls += 1;
        displayForTeamB(teamBBalls, 3);
    }

    /**
     * Calculate Strike rate for Team A
     */
    public void teamAStrikeRate() {
        DecimalFormat df = new DecimalFormat();     // Change decimal format to 2 for displaying
        df.setMaximumFractionDigits(2);             // floating data with two decimal points
        teamAStrikeRate = (teamARuns * 100.00) / teamABalls;
        TextView scoreView = (TextView) findViewById(R.id.team_a_strike_rate);
        scoreView.setText(String.valueOf(df.format(teamAStrikeRate)));
    }

    /**
     * Calculate Strike rate for Team B and change decimal format to 2
     */
    public void teamBStrikeRate() {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        teamBStrikeRate = (teamBRuns * 100.00) / teamBBalls;
        TextView scoreView = (TextView) findViewById(R.id.team_b_strike_rate);
        scoreView.setText(String.valueOf(df.format(teamBStrikeRate)));
    }


    /**
     * Reset everything
     */
    public void reset(View v) {
        teamARuns = 0;
        teamABalls = 0;
        teamAOut = 0;
        teamBRuns = 0;
        teamBBalls = 0;
        teamBOut = 0;
        displayForTeamA(teamARuns, 1);
        displayForTeamA(teamABalls, 2);
        displayForTeamA(teamAOut, 3);
        displayForTeamA(0, 4);
        displayForTeamB(teamBRuns, 1);
        displayForTeamB(teamBBalls, 2);
        displayForTeamB(teamBOut, 3);
        displayForTeamB(0, 4);

        teamAStrikeRate = 0.0;
        teamBStrikeRate = 0.0;

        TextView scoreViewA = (TextView) findViewById(R.id.team_a_strike_rate);
        scoreViewA.setText(String.valueOf(teamBStrikeRate));
        TextView scoreViewB = (TextView) findViewById(R.id.team_b_strike_rate);
        scoreViewB.setText(String.valueOf(teamBStrikeRate));
    }

    /**
     * Displays the given score for Team A.
     *
     * @param identifier = 1 : update team A score
     *                   = 2 : update team A wicket
     *                   = 3 : update team A balls
     */
    public void displayForTeamA(int score, int identifier) {
        if (teamABalls > 0) {
            teamAStrikeRate();
        }
        if (identifier == 1) {
            TextView scoreView = (TextView) findViewById(R.id.team_a_score);
            scoreView.setText(String.valueOf(score));
        }
        if (identifier == 2) {
            TextView scoreView = (TextView) findViewById(R.id.team_a_wicket);
            scoreView.setText(String.valueOf(score));
        }
        if (identifier == 3) {
            TextView scoreView = (TextView) findViewById(R.id.team_a_ball);
            scoreView.setText(String.valueOf(score));
        }
    }

    /**
     * Displays the given score for Team B.
     *
     * @param identifier = 1 : update team A score
     *                   = 2 : update team A wicket
     *                   = 3 : update team A balls
     */
    public void displayForTeamB(int score, int identifier) {
        if (teamBBalls > 0) {
            teamBStrikeRate();
        }

        if (identifier == 1) {
            TextView scoreView = (TextView) findViewById(R.id.team_b_score);
            scoreView.setText(String.valueOf(score));
        }
        if (identifier == 2) {
            TextView scoreView = (TextView) findViewById(R.id.team_b_wicket);
            scoreView.setText(String.valueOf(score));
        }
        if (identifier == 3) {
            TextView scoreView = (TextView) findViewById(R.id.team_b_ball);
            scoreView.setText(String.valueOf(score));
        }
    }
}
