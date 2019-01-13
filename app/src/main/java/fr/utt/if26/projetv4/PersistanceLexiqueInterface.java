package fr.utt.if26.projetv4;

import java.util.List;

public interface PersistanceLexiqueInterface
{
    public boolean          creerLexique    (String titre, String descriptif);
    public boolean          modifierLexique (int id, String titre, String descriptif);
    public boolean          supprimerLexique(int id);
    public List<Lexique> listerLexiques  ();
    public List<Terme>      listerTermes    (int id_lexique);
}
