package seattlesbest.angtaasapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dalag, Magdaraog, Raymundo on 11/10/2017.
 */

public class ViewAllFlashcardsActivity extends AppCompatActivity {

    RecyclerView rvListFlashcard;
    DatabaseHelper dbHelper;
    ArrayList<Flashcard> flashcardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewallflashcards);

        rvListFlashcard = (RecyclerView) findViewById(R.id.rv_listflashcards);
        dbHelper = new DatabaseHelper(getBaseContext());
        flashcardList = new ArrayList<>();


        // Cursor cardsCursor = dbHelper.getAllFlashcards();
        flashcardList = dbHelper.getFlashcarList();
        ViewAllFlashcardAdapter vafAdapter = new ViewAllFlashcardAdapter(flashcardList);
        rvListFlashcard.setAdapter(vafAdapter);
        rvListFlashcard.setLayoutManager(new LinearLayoutManager(getBaseContext()));

        }
}


