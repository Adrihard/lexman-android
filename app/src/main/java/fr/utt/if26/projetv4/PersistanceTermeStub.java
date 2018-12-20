package fr.utt.if26.projetv4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PersistanceTermeStub extends SQLiteOpenHelper implements PersistanceTermeInterface
{
    protected static       int      DATABASE_VERSION    = 1;
    public    static final String   DATABASE_NAME       = PersistanceLexiqueStub.DATABASE_NAME;

    protected static final String   T_TERMES            = "termes";

    protected static final String   A_ID                = "id";
    protected static final String   A_TITRE             = "titre";
    protected static final String   A_DESCRIPTIF        = "descriptif";
    protected static final String   A_LEXIQUE           = "id_lexique";

    protected static final String   TERMES_CREATE       = "";
    protected static final String   TERMES_DROP         = "";

    public PersistanceTermeStub(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TERMES_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(TERMES_DROP);
        db.execSQL(TERMES_CREATE);
    }

    public boolean creerTerme(String titre, String descriptif, int id_lexique) {
        return (false);
    }

    public boolean modifierTerme(int id, String titre, String descriptif) {
        return (false);
    }

    public boolean supprimerTerme(int id) {
        return (false);
    }
}
