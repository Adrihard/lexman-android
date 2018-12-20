package fr.utt.if26.projetv4;

public interface PersistanceTermeInterface
{
    public boolean creerTerme       (String titre, String descriptif, int id_lexique);
    public boolean modifierTerme    (int id, String titre, String descriptif);
    public boolean supprimerTerme   (int id);
}
