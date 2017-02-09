package com.example.android.courtcounter;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import java.lang.Math;

import static android.R.attr.id;
import static android.os.Build.VERSION_CODES.M;
import static android.provider.ContactsContract.Directory.PACKAGE_NAME;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;

    int logoA = 0;
    int logoB = 0;

    String[] nations = {"italy","france","england","ireland","wales","scotland"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("TeamA",scoreTeamA);
        savedInstanceState.putInt("TeamB",scoreTeamB);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        scoreTeamA = savedInstanceState.getInt("TeamA");
        scoreTeamB = savedInstanceState.getInt("TeamB");
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    private void displayForTeamA(int score){
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    private void displayForTeamB(int score){
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void incrementA(View view){
        int score = Integer.parseInt(view.getTag().toString());
        scoreTeamA = scoreTeamA + score;
        displayForTeamA(scoreTeamA);
    }

    public void incrementB(View view){
        int score = Integer.parseInt(view.getTag().toString());
        scoreTeamB = scoreTeamB + score;
        displayForTeamB(scoreTeamB);
    }

    public void reset(View view){
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        ImageView imageviewA = (ImageView) findViewById(R.id.logoTeamA);
        imageviewA.setImageResource(R.drawable.base);
        ImageView imageviewB = (ImageView) findViewById(R.id.logoTeamB);
        imageviewB.setImageResource(R.drawable.base);
    }

    public void changeLogoA(View view){
        logoA = Math.abs(logoA + Integer.parseInt(view.getTag().toString()))%6;
        int id = getResources().getIdentifier("com.example.android.courtcounter:drawable/" + nations[logoA], null, null);
        System.out.print(id);
        ImageView imageview = (ImageView) findViewById(R.id.logoTeamA);
        imageview.setImageResource(id);
    }

    public void changeLogoB(View view){
        logoB = Math.abs(logoB + Integer.parseInt(view.getTag().toString()))%6;
        int id = getResources().getIdentifier("com.example.android.courtcounter:drawable/" + nations[logoB], null, null);
        System.out.print(id);
        ImageView imageview = (ImageView) findViewById(R.id.logoTeamB);
        imageview.setImageResource(id);
    }

}
