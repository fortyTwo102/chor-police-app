package com.example.farooq.chorpolicedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.view.View;

public class Activity3 extends AppCompatActivity {

    Player playerOne, playerTwo, playerThree, playerFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);


        playerOne = (Player) getIntent().getSerializableExtra("PLAYERONE");
        playerTwo = (Player) getIntent().getSerializableExtra("PLAYERTWO");
        playerThree = (Player) getIntent().getSerializableExtra("PLAYERTHREE");
        playerFour = (Player) getIntent().getSerializableExtra("PLAYERFOUR");

        TextView score1 = (TextView) findViewById(R.id.score1);
        TextView score2 = (TextView) findViewById(R.id.score2);
        TextView score3 = (TextView) findViewById(R.id.score3);
        TextView score4 = (TextView) findViewById(R.id.score4);

        score1.setText(playerOne.getName() + ": " + Integer.toString(playerOne.getScore()));
        score2.setText(playerTwo.getName() + ": " + Integer.toString(playerTwo.getScore()));
        score3.setText(playerThree.getName() + ": " + Integer.toString(playerThree.getScore()));
        score4.setText(playerFour.getName() + ": " + Integer.toString(playerFour.getScore()));




    }

    public void restart(View view){

        Intent intent = new Intent(this, Activity1.class);

        intent.putExtra("PLAYERONE",playerOne);
        intent.putExtra("PLAYERTWO",playerTwo);
        intent.putExtra("PLAYERTHREE",playerThree);
        intent.putExtra("PLAYERFOUR",playerFour);


        startActivity(intent);

    }


    public void openMainActivity(View view){

        Intent intent = new Intent(this,MainActivity.class);

        startActivity(intent);
    }
}
