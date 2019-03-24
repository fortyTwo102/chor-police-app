package com.example.farooq.chorpolicedemo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import static java.util.Arrays.asList;

public class Activity2 extends AppCompatActivity {

    Player playerOne, playerTwo, playerThree, playerFour;
    ArrayList<Player> players;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Random r = new Random();
        int rand = r.nextInt(1);


        playerOne = (Player) getIntent().getSerializableExtra("PLAYERONE");
        playerTwo = (Player) getIntent().getSerializableExtra("PLAYERTWO");
        playerThree = (Player) getIntent().getSerializableExtra("PLAYERTHREE");
        playerFour = (Player) getIntent().getSerializableExtra("PLAYERFOUR");

        players = new ArrayList<Player>(asList(playerFour,playerThree,playerTwo,playerOne));

        //  for(Player player: players){
        //     Log.i("Name",player.getName());
        // }

        TextView police = (TextView) findViewById(R.id.police);

        Button choice1 = (Button) findViewById(R.id.choice1);
        Button choice2 = (Button) findViewById(R.id.choice2);

        for(Player player: players){
            if(player.getRole().equals("POLICE")){
                police.setText(player.getName());
            }
            if(rand==0) {


                if (player.getRole().equals("MANTRI")) {
                    choice1.setText(player.getName());
                    choice1.setTag(player.getRole());
                }

                if (player.getRole().equals("CHOR")) {
                    choice2.setText(player.getName());
                    choice2.setTag(player.getRole());
                }

            }else{
                if (player.getRole().equals("MANTRI")) {
                    choice2.setText(player.getName());
                    choice2.setTag(player.getRole());
                }

                if (player.getRole().equals("CHOR")) {
                    choice1.setText(player.getName());
                    choice1.setTag(player.getRole());
                }

            }
        }

    }

    public void select(View view){

        Button temp = (Button) view;

        if(temp.getTag().equals("CHOR")){
            for(Player player: players){
                if(player.getRole().equals("POLICE")){
                    final Toast toast = Toast.makeText(getApplicationContext(),player.getName()+" GUESSED CORRECT!",Toast.LENGTH_SHORT);
                    toast.show();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 700);

                    player.setScore(500);
                }

                if(player.getRole().equals("CHOR")){
                    player.setScore(0);
                }
            }
        }else{
            for(Player player: players){
                if(player.getRole().equals("POLICE")){
                    final Toast toast = Toast.makeText(getApplicationContext(),player.getName()+" GUESSED WRONG!",Toast.LENGTH_SHORT);
                    toast.show();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 700);

                    player.setScore(0);
                }

                if(player.getRole().equals("CHOR")){
                    player.setScore(500);
                }
            }
        }

        Intent intent3 = new Intent(this, Activity3.class);

        intent3.putExtra("PLAYERONE",playerOne);
        intent3.putExtra("PLAYERTWO",playerTwo);
        intent3.putExtra("PLAYERTHREE",playerThree);
        intent3.putExtra("PLAYERFOUR",playerFour);

        startActivity(intent3);

    }
}
