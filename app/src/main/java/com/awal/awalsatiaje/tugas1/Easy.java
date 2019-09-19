package com.awal.awalsatiaje.tugas1;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.awal.awalsatiaje.tugas1.R;

public class Easy extends Activity {

    List<Question> quesList;
    int score = 0;
    int qid = 0;


    Question currentQ;
    TextView txtQuestion, times, scored;
    Button button1, button2, button3,button4,button5;
    private long backpressedtime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);

        QuizHelper db = new QuizHelper(this);
        quesList = db.getAllQuestions();
        currentQ = quesList.get(qid);

        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);

        button4.setVisibility(View.GONE);

        scored = (TextView) findViewById(R.id.score);

        scored.setVisibility(View.GONE);


        times = (TextView) findViewById(R.id.timers);


        setQuestionView();
        times.setText("00:02:00");


        CounterClass timer = new CounterClass(60000, 1000);
        timer.start();





        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                getAnswer(button1.getText().toString());
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button2.getText().toString());
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button3.getText().toString());
            }
        });

    }

    public void getAnswer(String AnswerString) {
        if (currentQ.getANSWER().equals(AnswerString)) {


            score++;
            scored.setText("Score : " + score);
        } else {



            Intent intent = new Intent(Easy.this,
                    ResultActivity.class);


            Bundle b = new Bundle();
            b.putInt("score", score);
            intent.putExtras(b);
            startActivity(intent);
            finish();
        }
        if (qid < 21) {


            currentQ = quesList.get(qid);
            setQuestionView();
        } else {


            Intent intent = new Intent(Easy.this,Won.class);
            Bundle b = new Bundle();
            b.putInt("score",score);
            intent.putExtras(b);
            startActivity(intent);
            finish();
        }


    }


    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    public class CounterClass extends CountDownTimer {

        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            // TODO Auto-generated constructor stub
        }


        @Override
        public void onFinish() {
            times.setText("Time is up");
            button4.setVisibility(View.VISIBLE);
            button4.setOnClickListener((arg0 -> {
                Intent i =new Intent(getApplicationContext(),Easy.class);
                startActivity(i);
            }));
            button1.setBackgroundColor(Color.GRAY);
            button2.setBackgroundColor(Color.GRAY);
            button3.setBackgroundColor(Color.GRAY);
            scored.setVisibility(View.VISIBLE);
            button1.setClickable(false);
            button2.setClickable(false);
            button3.setClickable(false);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            // TODO Auto-generated method stub

            long millis = millisUntilFinished;
            String hms = String.format(
                    "%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                            .toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                            .toMinutes(millis)));
            System.out.println(hms);
            times.setText(hms);
        }


    }

    private void setQuestionView() {


        txtQuestion.setText(currentQ.getQUESTION());
        button1.setText(currentQ.getOPTA());
        button2.setText(currentQ.getOPTB());
        button3.setText(currentQ.getOPTC());

        qid++;
    }

    @Override
    public void onBackPressed() {
        if (backpressedtime + 2000 > System.currentTimeMillis()){
            super.onBackPressed();
            return;
        } else {
            Toast.makeText(getBaseContext(), "Tekan Lagi Untuk Kembali", Toast.LENGTH_SHORT).show();
        }
        backpressedtime = System.currentTimeMillis();
        //Intent intent = new Intent(MainActivity.this, NextActivity.class);
        //startActivity(intent);
        //Toast.makeText(getApplicationContext(), "Klick Tombol Menu Untuk Kembali", Toast.LENGTH_SHORT).show();
        //finish();
    }
}
