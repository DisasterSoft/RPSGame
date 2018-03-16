package disastersoft.gyorg.game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b_rock, b_paper, b_scissors;
    ImageView iv_cpu, iv_me;

    String myChoise, cpuChoice, result;

    Random r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_cpu = (ImageView) findViewById(R.id.iv_cpu);
        iv_me = (ImageView) findViewById(R.id.iv_me);

        b_rock = (Button) findViewById(R.id.b_rock);
        b_paper = (Button) findViewById(R.id.b_paper);
        b_scissors = (Button) findViewById(R.id.b_scissors);

        r = new Random();

        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoise = "rock";
                iv_me.setImageResource(R.drawable.rock);
                calculate();

            }
        });

        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoise = "paper";
                iv_me.setImageResource(R.drawable.paper);
                calculate();

            }
        });

        b_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoise = "scissors";
                iv_me.setImageResource(R.drawable.scissors);
                calculate();

            }
        });

    }

    public void calculate(){
        int cpu = r.nextInt(3);
        if(cpu == 0){
            cpuChoice = "rock";
            iv_cpu.setImageResource(R.drawable.rock);
        }
        else if(cpu == 1) {
            cpuChoice = "paper";
            iv_cpu.setImageResource(R.drawable.paper);
        }
        else if(cpu == 2) {
            cpuChoice = "scissors";
            iv_cpu.setImageResource(R.drawable.scissors);
        }

        if(myChoise.equals("rock") && cpuChoice.equals("paper")){
            result = "You Lose";
        } else
        if(myChoise.equals("rock") && cpuChoice.equals("scissors")){
            result = "You Win";
        } else
        if(myChoise.equals("paper") && cpuChoice.equals("rock")){
            result = "You Win";
        } else
        if(myChoise.equals("paper") && cpuChoice.equals("scissors")){
            result = "You Lose";
        } else
        if(myChoise.equals("scissors") && cpuChoice.equals("paper")){
            result = "You Win";
        } else
        if(myChoise.equals("scissors") && cpuChoice.equals("rock")){
            result = "You Lose";
        } else
        if(myChoise.equals("scissors") && cpuChoice.equals("scissors")){
            result = "Draw";
        } else
        if(myChoise.equals("rock") && cpuChoice.equals("rock")){
            result = "Draw";
        } else
        if(myChoise.equals("paper") && cpuChoice.equals("paper")){
            result = "Draw";
        }

        //Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();

        Toast toast = Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG);
        // Here we can set the Gravity to Top and Right
        toast.setGravity(Gravity.CENTER ,0, 0);
        toast.show();


    }
}
