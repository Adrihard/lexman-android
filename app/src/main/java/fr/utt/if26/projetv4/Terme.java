package fr.utt.if26.projetv4;

public class Terme {

    private int Id;
    private String Titre;
    private String Descriptif;
    private int IdLexique;

    public Terme(int id, String titre, String descriptif, int idLexique) {
        Id = id;
        Titre = titre;
        Descriptif = descriptif;
        IdLexique = idLexique;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public String getDescriptif() {
        return Descriptif;
    }

    public void setDescriptif(String descriptif) {
        Descriptif = descriptif;
    }

    public int getIdLexique() {
        return IdLexique;
    }

    public void setIdLexique(int idLexique) {
        IdLexique = idLexique;
    }
}
