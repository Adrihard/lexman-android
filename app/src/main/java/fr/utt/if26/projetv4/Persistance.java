package fr.utt.if26.projetv4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

public class Persistance extends SQLiteOpenHelper implements  PersistanceLexiqueInterface, PersistanceTermeInterface{
    private static final String DATABASE_NAME       = "lexiques.db";
    private static final int    DATABASE_VERSION    = 1;

    private static final String LEX_TABLE       = "lexiques";
    private static final String LEX_ID          = "id";
    private static final String LEX_TITRE       = "titre";
    private static final String LEX_DESCRIPTIF  = "descriptif";

    private static final String TER_TABLE       = "termes";
    private static final String TER_ID          = "id";
    private static final String TER_TITRE       = "titre";
    private static final String TER_DESCRIPTIF  = "descriptif";
    private static final String TER_LEXIQUE     = "id_lexique";

    private static final String LEXIQUES_CREATE =

            "CREATE TABLE " + LEX_TABLE + "("
                    + LEX_ID + " INTEGER, "
                    + LEX_TITRE + " TEXT NOT NULL, "
                    + LEX_DESCRIPTIF + " TEXT, "
                    + "PRIMARY KEY(" + LEX_ID + ") "
            + ")";

    private static final String LEXIQUES_DROP =

            "DROP TABLE " + LEX_TABLE;

    private static final String TERMES_CREATE =

            "CREATE TABLE " + TER_TABLE + "("
                    + TER_ID + " INTEGER, "
                    + TER_TITRE + " TEXT NOT NULL, "
                    + TER_DESCRIPTIF + " TEXT, "
                    + TER_LEXIQUE + " INTEGER, "
                    + "FOREIGN KEY(" + TER_LEXIQUE + ") "
                        + "REFERENCES " + LEX_TABLE + "(" + LEX_ID + ") "
                        + "ON DELETE CASCADE, "
                    + "PRIMARY KEY(" + TER_ID + ") "
            + ")";

    private static final String TERMES_DROP =

            "DROP TABLE " + TER_TABLE;

    public Persistance(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(LEXIQUES_CREATE);
        db.execSQL(TERMES_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(TERMES_DROP);
        db.execSQL(LEXIQUES_DROP);

        db.execSQL(LEXIQUES_CREATE);
        db.execSQL(TERMES_CREATE);
    }

    @Override
    public boolean creerLexique(String titre, String descriptif) {
        return false;
    }

    @Override
    public boolean modifierLexique(int id, String titre, String descriptif) {
        return false;
    }

    @Override
    public boolean supprimerLexique(int id) {
        return false;
    }

    @Override
    public List<Lexique> listerLexiques() {
        return null;
    }

    @Override
    public List<Terme> listerTermes(int id_lexique) {
        return null;
    }

    @Override
    public boolean creerTerme(String titre, String descriptif, int id_lexique) {
        return false;
    }

    @Override
    public boolean modifierTerme(int id, String titre, String descriptif) {
        return false;
    }

    @Override
    public boolean supprimerTerme(int id) {
        return false;
    }
}
