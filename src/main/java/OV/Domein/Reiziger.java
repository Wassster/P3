package OV.Domein;

import java.sql.Date;

public class Reiziger {
    private int id;
    private String voorletters;
    private String tussenvoegsel;
    private String achternaam;
    private Date geboortedatum;
    private Adres adres;


    public Reiziger(int id, String voorletters, String tussenvoegsel, String achternaam, Date geboortedatum) {
        this.id = id;
        this.voorletters = voorletters;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getVoorletters() {
        return voorletters;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public int getId() {
        return id;
    }

    public Adres getAdres() {
        return adres;
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public void setVoorletters(String voorletters) {
        this.voorletters = voorletters;
    }

    @Override
    public String toString() {
        return String.format("Reiziger {#%d %s%s %s, geb. %s, %s}",
                id,
                voorletters,
                tussenvoegsel,
                achternaam,
                geboortedatum.toString(),
                adres);
    }
}
