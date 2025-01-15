package model;

public class Medikamente {
    String name;
    int preis;
    String krankheit;

    public Medikamente(String name, int preis, String krankheit) {
        this.name = name;
        this.preis = preis;
        this.krankheit = krankheit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPreis() {
        return preis;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

    public String getKrankheit() {
        return krankheit;
    }

    public void setKrankheit(String krankheit) {
        this.krankheit = krankheit;
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "name='" + name + '\'' +
                ", preis=" + preis +
                ", krankheit='" + krankheit + '\'' +
                '}';
    }
}
