package studio.goldenapp.selectioncampus;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    Dialog myDialog;
    private FirebaseFirestore firebaseFirestore;
    private String user_id;
    private FirebaseAuth firebaseAuth;


    Button b1,b2,b3,b4, showPopUp;
    TextView t1_question,timerTxt;
    public int correct = 0;
    public int wrong = 0;
    public int timer;
    private int totalQue = 0, mQueNum = 1;
    private String mAnswer, name;
    public Firebase mQueRef, mChoice1Ref, mChoice2Ref, mChoice3Ref, mChoice4Ref, mAnsRef, mTotalQuestions, mTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Firebase.setAndroidContext(this);
        myDialog = new Dialog(this);
        showPopUp = findViewById(R.id.popup);


        firebaseAuth = FirebaseAuth.getInstance();
        user_id = firebaseAuth.getCurrentUser().getUid();
        firebaseFirestore = FirebaseFirestore.getInstance();
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);

        t1_question = findViewById(R.id.questionTxt);
        timerTxt = findViewById(R.id.timerTxt);

        firebaseFirestore.collection("Users").document(user_id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                if (task.isSuccessful()) {

                    if (task.getResult().exists()) {

                         name = task.getResult().getString("name");

                    }

                } else {}

            }
        });


        updateQuestion();
        reverseTimer(900,timerTxt);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b1.getText().equals(mAnswer)){
                    b1.setBackgroundColor(Color.GREEN);
                    correct++;

                } else {
                    wrong++;
                    b1.setBackgroundColor(Color.RED);

                    if (b2.getText().toString().equals(mAnswer)) {
                        b2.setBackgroundColor(Color.GREEN);
                    } else if (b3.getText().toString().equals(mAnswer)) {
                        b3.setBackgroundColor(Color.GREEN);
                    } else if (b4.getText().toString().equals(mAnswer)) {
                        b4.setBackgroundColor(Color.GREEN);
                    }
                }
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                            b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                            b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                            b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                            updateQuestion();
                        }
                    }, 1500);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b2.getText().equals(mAnswer)){
                    b2.setBackgroundColor(Color.GREEN);
                    correct++;
                } else {
                    wrong++;
                    b2.setBackgroundColor(Color.RED);

                    if (b1.getText().toString().equals(mAnswer)) {
                        b1.setBackgroundColor(Color.GREEN);
                    } else if (b3.getText().toString().equals(mAnswer)) {
                        b3.setBackgroundColor(Color.GREEN);
                    } else if (b4.getText().toString().equals(mAnswer)) {
                        b4.setBackgroundColor(Color.GREEN);
                    }
                }
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                            b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                            b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                            b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                            updateQuestion();
                        }
                    }, 1500);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b3.getText().equals(mAnswer)){
                    b1.setBackgroundColor(Color.GREEN);
                    correct++;
                } else  {
                    wrong++;
                    b3.setBackgroundColor(Color.RED);

                    if(b2.getText().toString().equals(mAnswer)){
                        b2.setBackgroundColor(Color.GREEN);
                    }else if(b1.getText().toString().equals(mAnswer)) {
                        b1.setBackgroundColor(Color.GREEN);
                    }else if (b4.getText().toString().equals(mAnswer)){
                        b4.setBackgroundColor(Color.GREEN);
                    } }
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                            b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                            b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                            b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                            updateQuestion();
                        }
                    }, 1500);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b4.getText().equals(mAnswer)){
                    b4.setBackgroundColor(Color.GREEN);
                   correct++;
                } else  {
                    wrong++;
                    b4.setBackgroundColor(Color.RED);

                    if(b2.getText().toString().equals(mAnswer)){
                        b2.setBackgroundColor(Color.GREEN);
                    }else if(b3.getText().toString().equals(mAnswer)) {
                        b3.setBackgroundColor(Color.GREEN);
                    }else if (b1.getText().toString().equals(mAnswer)){
                        b1.setBackgroundColor(Color.GREEN);
                    }

                }
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                        updateQuestion();
                    }
                }, 1500);
            }
        });
    }


    public void updateQuestion() {


        mQueRef = new Firebase("https://pannu-english-classes-23e9e.firebaseio.com//Questions/" + mQueNum + "/question");

        mQueRef.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                String question = dataSnapshot.getValue(String.class);
                t1_question.setText(question);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mChoice1Ref = new Firebase("https://pannu-english-classes-23e9e.firebaseio.com//Questions/" + mQueNum + "/option1");

        mChoice1Ref.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                String choice1 = dataSnapshot.getValue(String.class);
                b1.setText(choice1);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mChoice2Ref = new Firebase("https://pannu-english-classes-23e9e.firebaseio.com//Questions/" + mQueNum + "/option2");

        mChoice2Ref.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                String choice2 = dataSnapshot.getValue(String.class);
                b2.setText(choice2);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mChoice3Ref = new Firebase("https://pannu-english-classes-23e9e.firebaseio.com//Questions/" + mQueNum + "/option3");

        mChoice3Ref.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                String choice3 = dataSnapshot.getValue(String.class);
                b3.setText(choice3);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mChoice4Ref = new Firebase("https://pannu-english-classes-23e9e.firebaseio.com//Questions/" + mQueNum + "/option4");

        mChoice4Ref.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                String choice4 = dataSnapshot.getValue(String.class);
                b4.setText(choice4);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mAnsRef = new Firebase("https://pannu-english-classes-23e9e.firebaseio.com//Questions/" + mQueNum + "/answer");

        mAnsRef.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                mAnswer = dataSnapshot.getValue(String.class);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mQueNum++;



        if (mQueNum == 27) {
            showPopUp.performClick();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(QuizActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 6000);
        }

    }

    public void reverseTimer(int seconds, final  TextView tv){
        new CountDownTimer(seconds * 1000 + 1000,1000){
            public void onTick(long milliUntilFinished){
                int seconds = (int) (milliUntilFinished/1000);
                int minutes = seconds/60;
                tv.setText(String.format("Seconds left : ") + String.format("%02d",seconds));
            }

            @Override
            public void onFinish() {

                tv.setText("Time Completed..");
                ShowPopup();

               /** Intent myIntent = new Intent(QuizActivity.this, ResultActivity.class);
                myIntent.putExtra("total",String.valueOf(total));
                myIntent.putExtra("correct",String.valueOf(correct));
                myIntent.putExtra("incorrect",String.valueOf(wrong));
                startActivity(myIntent);*/
            }

            public void ShowPopup() {

                TextView txtclose, totalQue, rightQue, wrongQue, user;
                myDialog.setContentView(R.layout.show_popup);
                txtclose = myDialog.findViewById(R.id.txtclose);
                totalQue = myDialog.findViewById(R.id.total_que);
                rightQue = myDialog.findViewById(R.id.right_ans);
                wrongQue = myDialog.findViewById(R.id.wrong_ans);
                user = myDialog.findViewById(R.id.username);
                txtclose.setText("X");
                totalQue.setText("25");
                rightQue.setText("" + correct);
                wrongQue.setText("" + wrong);
                user.setText("" + name);


                txtclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myDialog.dismiss();
                    }
                });
                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                myDialog.show();

            }
        }.start();
    }

    public void ShowPopup(View v) {


        TextView txtclose, totalQue, rightQue, wrongQue, user;
        myDialog.setContentView(R.layout.show_popup);
        txtclose = myDialog.findViewById(R.id.txtclose);
        totalQue = myDialog.findViewById(R.id.total_que);
        rightQue = myDialog.findViewById(R.id.right_ans);
        wrongQue = myDialog.findViewById(R.id.wrong_ans);
        user = myDialog.findViewById(R.id.username);
        txtclose.setText("X");
        totalQue.setText("25");
        rightQue.setText("" + correct);
        wrongQue.setText("" + wrong);
        user.setText("" + name);


        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();

            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();


    }

}
