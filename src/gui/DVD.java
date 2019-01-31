package gui;

import java.util.ArrayList;

public class DVD {

    private String adSoyad;
    private String dvdBasligi;
    private int cikisTarihi;
    private int fiyatBilgileri;
    private ArrayList<String> sarkilar;

    public DVD() {
        this.adSoyad = "Not Set";
        this.dvdBasligi = " Not Set";
        this.cikisTarihi = -1;
        this.fiyatBilgileri = -1;
        this.sarkilar = new ArrayList<>();
    }

    public DVD(String adSoyad, String dvdBasligi, int cikisTarihi, int fiyatBilgileri) {
        this.adSoyad = adSoyad;
        this.dvdBasligi = dvdBasligi;
        this.cikisTarihi = cikisTarihi;
        this.fiyatBilgileri = fiyatBilgileri;
        this.sarkilar = new ArrayList<>();
    }

    public void addSong(String song) {

        this.getSarkilar().add(song);
    }

    public String getSongList() {
        String tmp = "";

        int counter = 0;
        for (String i : getSarkilar()) {
            counter++;
            if (counter < getSarkilar().size()) {

                tmp += i + ", ";
            } else {
                tmp += i;
            }

        }
        if (!tmp.endsWith(".")) {
            tmp += ".";
        }
        tmp += "\n";
        return tmp;
    }

    public boolean compare(DVD data) {
        if (this.getAdSoyad().equals(data.getAdSoyad()) && this.getDvdBasligi().equals(data.getDvdBasligi()) && this.getCikisTarihi() == data.getCikisTarihi()) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return this.getAdSoyad() + ", " + this.getDvdBasligi() + ", " + this.getCikisTarihi() + ", " + this.getFiyatBilgileri() + ", " + this.getSongList();
    }

    /**
     * @return the adSoyad
     */
    public String getAdSoyad() {
        return adSoyad;
    }

    /**
     * @param adSoyad the adSoyad to set
     */
    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    /**
     * @return the dvdBasligi
     */
    public String getDvdBasligi() {
        return dvdBasligi;
    }

    /**
     * @param dvdBasligi the dvdBasligi to set
     */
    public void setDvdBasligi(String dvdBasligi) {
        this.dvdBasligi = dvdBasligi;
    }

    /**
     * @return the cikisTarihi
     */
    public int getCikisTarihi() {
        return cikisTarihi;
    }

    /**
     * @param cikisTarihi the cikisTarihi to set
     */
    public void setCikisTarihi(int cikisTarihi) {
        this.cikisTarihi = cikisTarihi;
    }

    /**
     * @return the fiyatBilgileri
     */
    public int getFiyatBilgileri() {
        return fiyatBilgileri;
    }

    /**
     * @param fiyatBilgileri the fiyatBilgileri to set
     */
    public void setFiyatBilgileri(int fiyatBilgileri) {
        this.fiyatBilgileri = fiyatBilgileri;
    }

    /**
     * @return the sarkilar
     */
    public ArrayList<String> getSarkilar() {
        return sarkilar;
    }

    /**
     * @param sarkilar the sarkilar to set
     */
    public void setSarkilar(ArrayList<String> sarkilar) {
        this.sarkilar = sarkilar;
    }

}
