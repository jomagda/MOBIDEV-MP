package seattlesbest.angtaasapp;

/**
 * Created by Ana on 11/10/2017.
 */

public class Flashcard {

    private int _fcId;
    private String _filWord;
    private String _engWord;
    private byte[] _fcImage;

    public static final String TABLE_NAME = "flashcards";
    public static final String COLUMN_FCID = "_id";
    public static final String COLUMN_FILWORD = "filWord";
    public static final String COLUMN_ENGWORD = "engWord";
    public static final String COLUMN_FCIMAGE = "fcImage";

    public Flashcard () {

    }

    public Flashcard (int fcId, String filWord, String engWord, byte[] fcImage) {
        this._fcId = fcId;
        this._filWord = filWord;
        this._engWord = engWord;
        this._fcImage = fcImage;
    }

    public int get_fcId() {
        return _fcId;
    }

    public void set_fcId(int _fcId) {
        this._fcId = _fcId;
    }

    public String get_filWord() {
        return _filWord;
    }

    public void set_filWord(String _filWord) {
        this._filWord = _filWord;
    }

    public String get_engWord() {
        return _engWord;
    }

    public void set_engWord(String _engWord) {
        this._engWord = _engWord;
    }

    public byte[] get_fcImage() {
        return _fcImage;
    }

    public void set_fcImage(byte[] _fcImage) {
        this._fcImage = _fcImage;
    }



}
