package com.example.farooq.chorpolicedemo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.*;

import static android.widget.Toast.*;
import static java.util.Arrays.asList;

public class Activity1 extends AppCompatActivity {


    Button a,b,c,d,go;
    int p;
    int count=4;
    ArrayList<Button> buttons;
    ArrayList<Player> players;
    Player playerOne, playerTwo, playerThree, playerFour;
    Player p1,p2,p3,p4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        Player p1,p2,p3,p4;
        Log.i("Count",Integer.toString(count));
        p=99;

        a = (Button) findViewById(R.id.a);
        b = (Button) findViewById(R.id.b);
        c = (Button) findViewById(R.id.c);
        d = (Button) findViewById(R.id.d);
        go =(Button) findViewById(R.id.go);



        playerOne = (Player) getIntent().getSerializableExtra("PLAYERONE");
        p1=playerOne;
        playerTwo = (Player) getIntent().getSerializableExtra("PLAYERTWO");
        p2=playerTwo;
        playerThree = (Player) getIntent().getSerializableExtra("PLAYERTHREE");
        p3=playerThree;
        playerFour = (Player) getIntent().getSerializableExtra("PLAYERFOUR");
        p4=playerFour;

        a.setText(playerOne.getName());
        b.setText(playerTwo.getName());
        c.setText(playerThree.getName());
        d.setText(playerFour.getName());

        buttons = new ArrayList<Button>(asList(a,b,c,d));
        players = new ArrayList<Player>(asList(playerFour,playerThree,playerTwo,playerOne));
        assignRoles();
    }

    public void assignRoles(){

        String [] roles = {"RAJA","MANTRI","POLICE","CHOR"};

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<4; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);

        for (int i=0; i<3; i++) {
            System.out.println(list.get(i));
        }



        int i = 0;
        for(Button button: buttons){
            button.setTag(roles[list.get(i)]);
            i++;
        }


    }

    public void ButtonTapped(View view){

        Button temp = (Button) view;
        String role = (String) view.getTag();

        for(Player player: players){
            if(temp.getText().equals(player.getName())) {
                player.setRole(role);
            }

        }


        final Toast toast = Toast.makeText(getApplicationContext(),temp.getText() + " is " + role,LENGTH_SHORT);
        toast.show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, 700);


        Log.i("count",Integer.toString(count));

        view.setVisibility(View.INVISIBLE);

        count--;
        if(count==-0) go.setVisibility(View.VISIBLE);

    }

    public void nextPage(View view){

        for(Player player: players){
            if(player.getRole().equals("RAJA")){
                player.setScore(1000);
            }

            if(player.getRole().equals("MANTRI")){
                player.setScore(800);
            }

        }

        openActivity2();

    }


    public void openActivity2(){
        Intent intent2 = new Intent(this, Activity2.class);

        intent2.putExtra("PLAYERONE",playerOne);
        intent2.putExtra("PLAYERTWO",playerTwo);
        intent2.putExtra("PLAYERTHREE",playerThree);
        intent2.putExtra("PLAYERFOUR",playerFour);

        startActivity(intent2);
    }
}
