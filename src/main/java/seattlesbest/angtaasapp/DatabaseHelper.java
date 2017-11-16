package seattlesbest.angtaasapp;

/**
 * Created by Ana on 11/11/2017.
 */
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 6;
    public static final String SCHEMA = "flashcards";



    public DatabaseHelper(Context context) {
        super(context, SCHEMA, null, VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + Flashcard.TABLE_NAME + "("
                + Flashcard.COLUMN_FCID + " INTEGER PRIMARY KEY AUTOINCREMENT," + Flashcard.COLUMN_FILWORD + " TEXT,"
                + Flashcard.COLUMN_ENGWORD + " TEXT," + Flashcard.COLUMN_FCIMAGE + " BLOB" + ")";
        db.execSQL(sql);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Flashcard.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    //Add new flashcard
    public void addFlashcard(Flashcard flashcard) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Flashcard.COLUMN_FILWORD, flashcard.get_filWord()); // Filipino word
        values.put(Flashcard.COLUMN_ENGWORD, flashcard.get_engWord()); // English word
        values.put(Flashcard.COLUMN_FCIMAGE, flashcard.get_fcImage()); // Image

        // Inserting Row
        db.insert(flashcard.TABLE_NAME, null, values);
        db.close();
    }

    // view a flashcard
    public Flashcard getFlashcard(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.query(Flashcard.TABLE_NAME,
                null,
                Flashcard.COLUMN_FCID + " =?",
                new String [] {String.valueOf(id)},
                null, // groupby
                null, // having
                null); // orderby

        Flashcard card = null;
        if (c.moveToFirst())    {
            card = new Flashcard();
            String filword = c.getString(c.getColumnIndex(Flashcard.COLUMN_FILWORD));
            String engword = c.getString(c.getColumnIndex(Flashcard.COLUMN_ENGWORD));
            byte[] image = c.getBlob(c.getColumnIndex(Flashcard.COLUMN_FCIMAGE));

            card.set_filWord(filword);
            card.set_engWord(engword);
            card.set_fcImage(image);
            card.set_fcId(id);

        }
        c.close();
        db.close();
        return card;
    }

    public ArrayList<Flashcard> getFlashcarList()   {
        ArrayList<Flashcard> fcList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(Flashcard.TABLE_NAME, null,
                null, null, null, null, null, null);

        while(c.moveToNext()){
                Flashcard card = new Flashcard();
                card.set_fcId(c.getInt(c.getColumnIndex(Flashcard.COLUMN_FCID)));
                card.set_filWord(c.getString(c.getColumnIndex(Flashcard.COLUMN_FILWORD)));
                card.set_engWord(c.getString(c.getColumnIndex(Flashcard.COLUMN_ENGWORD)));
                card.set_fcImage(c.getBlob(c.getColumnIndex(Flashcard.COLUMN_FCIMAGE)));
                fcList.add(card);
            }

        c.close();
        db.close();
        return fcList;
    }
    // View All Flashcards
    public Cursor getAllFlashcards()  {
        SQLiteDatabase db = getReadableDatabase();
        return db.query(Flashcard.TABLE_NAME, null, null, null, null, null, null);
    }

    // Update/Edit a flashcard
    public void editFlashcard (Flashcard f){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Flashcard.COLUMN_FILWORD, f.get_filWord());
        cv.put(Flashcard.COLUMN_ENGWORD, f.get_engWord());
        cv.put(Flashcard.COLUMN_FCIMAGE, f.get_fcImage());
        db.update(Flashcard.TABLE_NAME, cv,
                Flashcard.COLUMN_FCID + " =? ", new String[]{String.valueOf(f.get_fcId())});
        db.close();
    }

    // Delete a flashcard
    public void deleteFlashcard(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(Flashcard.TABLE_NAME, Flashcard.COLUMN_FCID + " =? ", new String[]{String.valueOf(id)});
        db.close();
    }
}

