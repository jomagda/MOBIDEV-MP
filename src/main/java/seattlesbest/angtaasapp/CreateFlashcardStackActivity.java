package seattlesbest.angtaasapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Dalag, Magdaraog, Raymundo on 11/10/2017.
 */

public class CreateFlashcardStackActivity extends AppCompatActivity {

    RecyclerView rvFlashcardStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createflashcardstack);

        rvFlashcardStack = (RecyclerView) findViewById(R.id.rv_flashcardStack);

        ArrayList<FlashcardStack> flashcardstacks = new ArrayList<>();
        flashcardstacks.add(new FlashcardStack("Animals", R.drawable.chicken1600));
        flashcardstacks.add(new FlashcardStack("Food", R.drawable.pizza));
        flashcardstacks.add(new FlashcardStack("Things", R.drawable.pencil));

        FlashcardStackAdapter fa = new FlashcardStackAdapter(flashcardstacks);
        fa.setOnItemClickListener(new FlashcardStackAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(FlashcardStack f) {
                Toast.makeText(getBaseContext(), "You have selected this " + f.getName() + "stack.", Toast.LENGTH_SHORT).show();
            }
        });

        rvFlashcardStack.setAdapter(fa);
        rvFlashcardStack.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL, false));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Add a Flashcard Stack", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
    }
}
