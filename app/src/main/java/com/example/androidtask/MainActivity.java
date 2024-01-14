package com.example.androidtask;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView questionTextView, correctTextView, wrongTextView, GradeTextView;
    private Button trueButton, falseButton, nextButton;
    private ArrayList<String> questions;
    private ArrayList<Boolean> answers;
    private int currentIndex = 0;
    int totalscore = 0;

    @Override
   comm protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        questionTextView = findViewById(R.id.questionTextView);
        correctTextView = findViewById(R.id.correctTextView);
        wrongTextView = findViewById(R.id.WrongTextView);
        trueButton = findViewById(R.id.trueanswer);
        falseButton = findViewById(R.id.falseanswer);
        nextButton = findViewById(R.id.nextQ);
        GradeTextView = findViewById(R.id.GradeTextView);


        questions = new ArrayList<>();
        questions.add("Can you kiss your ears?");
        questions.add("Do you earn 5k monthly?");
        questions.add("Do you love me?");
        questions.add("Is Messi better than Ronaldo?");
        questions.add("Salt crackers is overrated?");
        questions.add("Muslim prays 9 times a day");
        questions.add("Machboos is the worst kuwaiti food?");
        questions.add("Ronaldo Has 5 Balon'dors T/F?");
        questions.add("Is Real Madrid the best Club in the world?");


        answers = new ArrayList<>();
        answers.add(false);
        answers.add(true);
        answers.add(true);
        answers.add(false);
        answers.add(true);
        answers.add(false);
        answers.add(false);
        answers.add(true);
        answers.add(true);


        displayQuestion();

        trueButton.setOnClickListener(view -> checkAnswer(true));
        falseButton.setOnClickListener(view -> checkAnswer(false));
        nextButton.setOnClickListener(view -> nextQuestion());
    }

    private void displayQuestion() {
        questionTextView.setText(questions.get(currentIndex));

        GradeTextView.setText(String.valueOf(totalscore));

        correctTextView.setVisibility(View.INVISIBLE);
        wrongTextView.setVisibility(View.INVISIBLE);
        nextButton.setVisibility(View.INVISIBLE);
        trueButton.setVisibility(View.VISIBLE);
        falseButton.setVisibility(View.VISIBLE);
    }

    private void checkAnswer(boolean userAnswer) {
        boolean correctAnswer = answers.get(currentIndex);

        if (userAnswer == correctAnswer) {

            correctTextView.setVisibility(View.VISIBLE);
            wrongTextView.setVisibility(View.INVISIBLE);
            trueButton.setVisibility(View.INVISIBLE);
            falseButton.setVisibility(View.INVISIBLE);
            nextButton.setVisibility(View.VISIBLE);

            TotalGrades();
        } else {

            correctTextView.setVisibility(View.INVISIBLE);
            wrongTextView.setVisibility(View.VISIBLE);
            trueButton.setVisibility(View.VISIBLE);
            falseButton.setVisibility(View.VISIBLE);
            nextButton.setVisibility(View.INVISIBLE);

        }
    }

    public void TotalGrades() {
        totalscore++;
        GradeTextView.setText(String.valueOf(totalscore));
    }

    private void hideAnswer(){
        questionTextView.setText(questions.get(currentIndex));

        GradeTextView.setText(String.valueOf(totalscore));

        correctTextView.setVisibility(View.VISIBLE);
        wrongTextView.setVisibility(View.VISIBLE);
        nextButton.setVisibility(View.VISIBLE);
        trueButton.setVisibility(View.INVISIBLE);
        falseButton.setVisibility(View.INVISIBLE);
    }

    private void nextQuestion() {
        currentIndex++;
        if (currentIndex < questions.size()) {
            displayQuestion();
        }
        else {
            hideAnswer();
        }
    }
}