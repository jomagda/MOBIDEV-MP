package seattlesbest.angtaasapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Dalag, Magdaraog, Raymundo on 11/10/2017.
 */

public class TakeQuizActivity extends AppCompatActivity{
    RecyclerView rvQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takequiz);

        rvQuiz = (RecyclerView) findViewById(R.id.rv_quiz);

        ArrayList<FlashcardStack> quizzes = new ArrayList<>();
        quizzes.add(new FlashcardStack("Animals", R.drawable.chicken1600));
        quizzes.add(new FlashcardStack("Food", R.drawable.pizza));
        quizzes.add(new FlashcardStack("Things", R.drawable.pencil));

        QuizAdapter qa = new QuizAdapter(quizzes);
        qa.setOnItemClickListener(new QuizAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(FlashcardStack f) {
                Toast.makeText(getBaseContext(), "You have selected this " + f.getName() + "stack.", Toast.LENGTH_SHORT).show();
            }
        });

        rvQuiz.setAdapter(qa);
        rvQuiz.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL, false));
    }
}
