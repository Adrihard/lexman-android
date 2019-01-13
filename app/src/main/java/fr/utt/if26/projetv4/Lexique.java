package fr.utt.if26.projetv4;

public class Lexique {

    private int Id;
    private String Titre;
    private String Descriptif;

    public Lexique(int id, String titre, String descriptif) {
        Id = id;
        Titre = titre;
        Descriptif = descriptif;
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
}
