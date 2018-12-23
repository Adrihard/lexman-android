package fr.utt.if26.projetv4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Persistance extends SQLiteOpenHelper implements PersistanceLexiqueInterface, PersistanceTermeInterface
{
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

    private static final String LEXIQUES_CREATE

        = "CREATE TABLE " + LEX_TABLE + "("
                + LEX_ID + " INTEGER, "
                + LEX_TITRE + " TEXT NOT NULL, "
                + LEX_DESCRIPTIF + " TEXT, "
                + "PRIMARY KEY(" + LEX_ID + ") "
        + ")";

    private static final String LEXIQUES_DROP

        = "DROP TABLE " + LEX_TABLE;

    private static final String[] LEXIQUES_SELECTION = { LEX_ID, LEX_TITRE, LEX_DESCRIPTIF };

    private static final String TERMES_CREATE

        = "CREATE TABLE " + TER_TABLE + "("
                + TER_ID + " INTEGER, "
                + TER_TITRE + " TEXT NOT NULL, "
                + TER_DESCRIPTIF + " TEXT, "
                + TER_LEXIQUE + " INTEGER, "
                + "FOREIGN KEY(" + TER_LEXIQUE + ") "
                    + "REFERENCES " + LEX_TABLE + "(" + LEX_ID + ") "
                    + "ON DELETE CASCADE, "
                + "PRIMARY KEY(" + TER_ID + ") "
        + ")";

    private static final String TERMES_DROP

        = "DROP TABLE " + TER_TABLE;

    private static final String[] TERMES_SELECTION = { TER_ID, TER_TITRE, TER_DESCRIPTIF, TER_LEXIQUE };

    private static String trimAndNullify(String str)
    {
        if (str != null)
        {
            str = str.trim();

            if (!str.isEmpty())
                return (str);
        }

        return (null);
    }

    private static Lexique inflateLexique(Cursor c)
    {
        int     id          = c.getInt(c.getColumnIndex(LEX_ID));
        String  titre       = c.getString(c.getColumnIndex(LEX_TITRE));
        String  descriptif  = c.getString(c.getColumnIndex(LEX_DESCRIPTIF));

        return (new Lexique(id, titre, descriptif));
    }

    private static Terme inflateTerme(Cursor c)
    {
        int     id          = c.getInt(c.getColumnIndex(TER_ID));
        String  titre       = c.getString(c.getColumnIndex(TER_TITRE));
        String  descriptif  = c.getString(c.getColumnIndex(TER_DESCRIPTIF));
        int     id_lexique  = c.getInt(c.getColumnIndex(TER_LEXIQUE));

        return (new Terme(id, titre, descriptif, id_lexique));
    }

    public Persistance(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(LEXIQUES_CREATE);
        db.execSQL(TERMES_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(TERMES_DROP);
        db.execSQL(LEXIQUES_DROP);

        db.execSQL(LEXIQUES_CREATE);
        db.execSQL(TERMES_CREATE);
    }

    @Override
    public boolean creerLexique(String titre, String descriptif)
    {
        String _titre       = trimAndNullify(titre);
        String _descriptif  = trimAndNullify(descriptif);

        ContentValues values = new ContentValues();

        if (_titre != null)
        {
            values.put(LEX_TITRE,       _titre);
            values.put(LEX_DESCRIPTIF,  _descriptif);

            try (SQLiteDatabase db = getWritableDatabase()) {
                return (db.insert(LEX_TABLE, null, values) != -1);
            }
        }

        return (false);
    }

    @Override
    public boolean modifierLexique(int id, String titre, String descriptif)
    {
        String _titre       = trimAndNullify(titre);
        String _descriptif  = trimAndNullify(descriptif);

        ContentValues values = new ContentValues();

        if (_titre != null)
        {
            values.put(LEX_TITRE,       _titre);
            values.put(LEX_DESCRIPTIF,  _descriptif);

            try (SQLiteDatabase db = getWritableDatabase())
            {
                return (
                    db.update
                    (
                        LEX_TABLE,
                        values,
                        LEX_ID + "=?",
                        new String[] { Integer.toString(id) }
                    )
                    != 0
                );
            }
        }

        return (false);
    }

    @Override
    public boolean supprimerLexique(int id)
    {
        try (SQLiteDatabase db = getWritableDatabase())
        {
            return (
                db.delete
                (
                    LEX_TABLE,
                    LEX_ID + "=?",
                    new String[] { Integer.toString(id) }
                )
                != 0
            );
        }
    }

    @Override
    public List<Lexique> listerLexiques()
    {
        List<Lexique> lexiques = new ArrayList();

        try (SQLiteDatabase db = getReadableDatabase())
        {
            Cursor c = db.query
            (
                LEX_TABLE,
                LEXIQUES_SELECTION,
                null,
                null,
                null,
                null,
                null
            );

            if (c != null)
            {
                while (c.moveToNext())
                    lexiques.add(inflateLexique(c));
            }
        }

        catch (Exception e) {
            return (new ArrayList());
        }

        return (lexiques);
    }

    @Override
    public List<Terme> listerTermes(int id_lexique)
    {
        List<Terme> termes = new ArrayList();

        try (SQLiteDatabase db = getReadableDatabase())
        {
            Cursor c = db.query
            (
                TER_TABLE,
                TERMES_SELECTION,
                TER_LEXIQUE + "=?",
                new String[] { Integer.toString(id_lexique) },
                null,
                null,
                null
            );

            if (c != null)
            {
                while (c.moveToNext())
                    termes.add(inflateTerme(c));
            }
        }

        catch (Exception e) {
            return (new ArrayList());
        }

        return (termes);
    }

    @Override
    public boolean creerTerme(String titre, String descriptif, int id_lexique)
    {
        String _titre       = trimAndNullify(titre);
        String _descriptif  = trimAndNullify(descriptif);

        ContentValues values = new ContentValues();

        if (_titre != null && _descriptif != null)
        {
            values.put(TER_TITRE,       _titre);
            values.put(TER_DESCRIPTIF,  _descriptif);
            values.put(TER_LEXIQUE,     id_lexique);

            try (SQLiteDatabase db = getWritableDatabase()) {
                return (db.insert(TER_TABLE, null, values) != -1);
            }
        }

        return (false);
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
