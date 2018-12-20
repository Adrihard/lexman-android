package fr.utt.if26.projetv4;

public class Lexique {

    private int Id;
    private String Tritre;
    private String Descriptif;

    public Lexique(int id, String tritre, String descriptif) {
        Id = id;
        Tritre = tritre;
        Descriptif = descriptif;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTritre() {
        return Tritre;
    }

    public void setTritre(String tritre) {
        Tritre = tritre;
    }

    public String getDescriptif() {
        return Descriptif;
    }

    public void setDescriptif(String descriptif) {
        Descriptif = descriptif;
    }
}
