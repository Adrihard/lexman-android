package fr.utt.if26.projetv4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class PersistanceLexiqueStub extends SQLiteOpenHelper implements PersistanceLexiqueInterface
{
    protected static       int      DATABASE_VERSION    = 1;
    public    static final String   DATABASE_NAME       = "lexiques.db";

    protected static final String   T_LEXIQUES          = "lexiques";

    protected static final String   A_ID                = "id";
    protected static final String   A_TITRE             = "titre";
    protected static final String   A_DESCRIPTIF        = "descriptif";

    protected static final String   LEXIQUES_CREATE     = "";
    protected static final String   LEXIQUES_DROP       = "";

    public PersistanceLexiqueStub(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(LEXIQUES_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(LEXIQUES_DROP);
        db.execSQL(LEXIQUES_CREATE);
    }

    public boolean creerLexique(String titre, String descriptif) {
        return (false);
    }

    public boolean modifierLexique(int id, String titre, String descriptif) {
        return (false);
    }

    public boolean supprimerLexique(int id) {
        return (false);
    }

    public List<Lexique> listerLexiques() {
        return (new ArrayList<>());
    }

    public List<Terme> listerTermes(int id_lexique) {
        return (new ArrayList<>());
    }
}
