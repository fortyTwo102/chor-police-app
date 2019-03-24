package com.example.farooq.chorpolicedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

class Player implements Serializable {

    private String name;
    private String role;
    private int score;

    public Player(String name){
        this.name = name;
    }

    public  void setRole(String role){
        this.role = role;
    }

    public void setScore(int score){
        this.score += score;
    }

    public String getName(){
        return name;
    }

    public String getRole(){
        return role;
    }

    public int getScore (){
        return score;
    }



}


public class MainActivity extends AppCompatActivity{

    EditText playerName1, playerName2, playerName3, playerName4;
 //   public String playerOne, playerTwo, playerThree, playerFour;
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.submitName);
        playerName1 = (EditText) findViewById(R.id.playerName1);
        playerName2 = (EditText) findViewById(R.id.playerName2);
        playerName3 = (EditText) findViewById(R.id.playerName3);
        playerName4 = (EditText) findViewById(R.id.playerName4);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* playerOne = playerName1.getText().toString();
                playerTwo = playerName2.getText().toString();
                playerThree = playerName3.getText().toString();
                playerFour = playerName4.getText().toString(); */


                openActivity1();
            }
        });
    }

    public void openActivity1(){
        Intent intent1 = new Intent(this, Activity1.class);

        Player playerOne = new Player(playerName1.getText().toString());
        Player playerTwo = new Player(playerName2.getText().toString());
        Player playerThree = new Player(playerName3.getText().toString());
        Player playerFour = new Player(playerName4.getText().toString());

        intent1.putExtra("PLAYERONE",playerOne);
        intent1.putExtra("PLAYERTWO",playerTwo);
        intent1.putExtra("PLAYERTHREE",playerThree);
        intent1.putExtra("PLAYERFOUR",playerFour);

        startActivity(intent1);

    }
}
