package com.example.satya.rpsgames;

import android.graphics.Color;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;
import java.util.RandomAccess;

public class MainActivity extends AppCompatActivity {
    //step-1: declare all variables
    Button b_rock, b_paper, b_scissors;
    ImageView iv_cpu, iv_me;
    TextView tv_score;
    TextToSpeech t1;

    String myChoice, cpuChoice, result;
    //take another variable Random
    Random r;
    // take two variable to count score of me and computer
    int myScore=0; int computerScore=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // step-2 :initialize all variables
        b_rock = (Button) findViewById(R.id.b_rock);
        b_paper = (Button) findViewById(R.id.b_paper);
        b_scissors = (Button) findViewById(R.id.b_scissors);
        iv_cpu = (ImageView) findViewById(R.id.iv_cpu);
        iv_me = (ImageView) findViewById(R.id.iv_me);
        tv_score= (TextView) findViewById(R.id.tv_score);

        r= new Random();

        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoice = "rock";
                iv_me.setImageResource(R.drawable.newrock);
                calucate();
                tv_score.setText("My Score: "+Integer.toString(myScore)+"\n Computer Score: "+Integer.toString(computerScore));

            }
        });
        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoice = "paper";
                iv_me.setImageResource(R.drawable.newpaper);
                calucate();
                tv_score.setText("My Score: "+Integer.toString(myScore)+"\n Computer Score: "+Integer.toString(computerScore));

            }
        });
        b_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoice = "scissors";
                iv_me.setImageResource(R.drawable.newscissors);
                calucate();
                tv_score.setText("My Score: "+Integer.toString(myScore)+"\n Computer Score: "+Integer.toString(computerScore));

            }
        });
    }
    //step-3: create a method named as calculate
    public void calucate() {
        // step-4: here give the choice option of cpu
        int cpu = r.nextInt(3);
        if (cpu == 0) {
            cpuChoice = "rock";
            iv_cpu.setImageResource(R.drawable.newrock);
        } else if (cpu == 1) {
            cpuChoice = "paper";
            iv_cpu.setImageResource(R.drawable.newpaper);
        } else if (cpu == 2) {
            cpuChoice = "scissors";
            iv_cpu.setImageResource(R.drawable.newscissors);
        }
        //step-5: giving comparisn options/rules of game  logics
        if (myChoice.equals("rock") && cpuChoice.equals("paper")) {
            computerScore++;
            result = "you lose";
        } else if (myChoice.equals("rock") && cpuChoice.equals("scissors")) {
            result = "you win";
            myScore++;
        } else if (myChoice.equals("paper") && cpuChoice.equals("scissors")) {
            result = "you lose";
            computerScore++;
        } else if (myChoice.equals("paper") && cpuChoice.equals("rock")) {
            result = "you win";
            myScore++;
        } else if (myChoice.equals("scissors") && cpuChoice.equals("rock")) {
            result = "you lose";
            computerScore++;
        } else if (myChoice.equals("scissors") && cpuChoice.equals("paper")) {
            result = "you win";
            myScore++;
        } else if (myChoice.equals("rock") && cpuChoice.equals("rock")) {
            result = "draw";
        } else if (myChoice.equals("paper") && cpuChoice.equals("paper")) {
            result = "draw";
        } else if (myChoice.equals("scissors") && cpuChoice.equals("scissors")) {
            result = "draw";
        }
        //Toast.makeText(MainActivity.this,result, Toast.LENGTH_SHORT).show();
        Toast toast = Toast.makeText(this, result, Toast.LENGTH_SHORT);
        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        if (result == "you win") {
            v.setTextColor(Color.GREEN);
        } else if (result == "you lose") {
            v.setTextColor(Color.RED);
        } else if (result == "draw") {
            v.setTextColor(Color.YELLOW);
        }

        toast.show();



    }
}