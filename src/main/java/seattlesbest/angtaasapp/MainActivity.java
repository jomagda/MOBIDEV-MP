package seattlesbest.angtaasapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Dalag, Magdaraog, Raymundo on 11/08/2017.
 */

public class MainActivity extends AppCompatActivity {

    ImageView ivUpload;
    ImageView ivEdit;
    ImageView ivFlashcards;
    ImageView ivStack;
    ImageView ivQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uploadActivity();
        editFlashCardActivity();
        viewAllFlashcardsActivity();
        createFlashcardStack();
        takeQuizAcivity();

        ivEdit = (ImageView) findViewById(R.id.iv_edit);
        ivFlashcards = (ImageView) findViewById(R.id.iv_flashcards);
        ivStack = (ImageView) findViewById(R.id.iv_stack);
        ivQuiz = (ImageView) findViewById(R.id.iv_quiz);

    }

    // Upload Activity
    public void uploadActivity(){
        final Context context = this;

        ivUpload = (ImageView) findViewById(R.id.iv_upload);
        ivUpload.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, UploadActivity.class);
                startActivity(intent);

            }

        });
    }

    // Edit Flash Cards Activity
    public void editFlashCardActivity(){
        final Context context = this;

        ivUpload = (ImageView) findViewById(R.id.iv_edit);
        ivUpload.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, EditFlashcardActivity.class);
                startActivity(intent);

            }

        });
    }

    // View All Flash Cards Activity
    public void viewAllFlashcardsActivity(){
        final Context context = this;

        ivUpload = (ImageView) findViewById(R.id.iv_flashcards);
        ivUpload.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, ViewAllFlashcardsActivity.class);
                startActivity(intent);

            }

        });
    }

    // Create Flashcard Stack Activity
    public void createFlashcardStack(){
        final Context context = this;

        ivUpload = (ImageView) findViewById(R.id.iv_stack);
        ivUpload.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, CreateFlashcardStackActivity.class);
                startActivity(intent);

            }

        });
    }

    // Take Quiz Activity
    public void takeQuizAcivity(){
        final Context context = this;

        ivUpload = (ImageView) findViewById(R.id.iv_quiz);
        ivUpload.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, TakeQuizActivity.class);
                startActivity(intent);

            }

        });
    }

}

