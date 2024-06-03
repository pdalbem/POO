package model;

public class Time {
    private int idTime;
    private String pais;

    @Override
    public String toString() {
        return "\nId: " + this.getIdTime()
                + "\nTime: " + this.getPais();
    }


    public Time(int idTime, String pais) {
        this.idTime = idTime;
        this.pais = pais;
    }

    public int getIdTime() {
        return idTime;
    }

    public void setIdTime(int idTime) {
        this.idTime = idTime;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
