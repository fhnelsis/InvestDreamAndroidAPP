package br.com.investdream.investdreamandroidapp;

public class Bem {

    private int id;
    private String nomeBem;

    public Bem() {
    }

    public Bem(int id, String nomeBem) {
        this.id = id;
        this.nomeBem = nomeBem;
    }

    public Bem(String nomeBem) {
        this.nomeBem = nomeBem;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

    public void setNomeBem(String nomeBem) {
        this.nomeBem = nomeBem;
    }

    public String getProductName() {
        return this.nomeBem;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}