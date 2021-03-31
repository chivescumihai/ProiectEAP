package ProiectEAP;

import java.time.LocalDate;

public class Date {
    private int an;
    private int luna;
    private int ziua;
    private int ora;
    private int minut;
    private int secunda;


    public Date(int an, int luna, int ziua, int ora, int minut, int secunda) {
        this.an = an;
        this.luna = luna;
        this.ziua = ziua;
        this.ora = ora;
        this.minut = minut;
        this.secunda = secunda;
    }

    public int getAn() {
        return this.an;
    }

    public void setAn(int an) {
        this.an = an;
    }

    public int getLuna() {
        return this.luna;
    }

    public void setLuna(int luna) {
        this.luna = luna;
    }

    public int getZiua() {
        return this.ziua;
    }

    public void setZiua(int ziua) {
        this.ziua = ziua;
    }

    public int getOra() {
        return this.ora;
    }

    public void setOra(int ora) {
        this.ora = ora;
    }

    public int getMinut() {
        return this.minut;
    }

    public void setMinut(int minut) {
        this.minut = minut;
    }

    public int getSecunda() {
        return this.secunda;
    }

    public void setSecunda(int secunda) {
        this.secunda = secunda;
    }

    public int [] getData ()
    {
        int [] data = {this.an, this.luna, this.ziua};
        return data;
    }

    public int [] getTime () {
        int [] time = {this.ora, this.minut, this.secunda};
        return time;
    }

    public int [] getAll () {
        int [] all = {this.an, this.luna, this.ziua, this.ora, this.minut, this.secunda};
        return all;
    }
}
