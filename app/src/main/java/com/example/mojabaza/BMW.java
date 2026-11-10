package com.example.mojabaza;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "bmw")
public class BMW {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String Model;
    private String Typ;
    @ColumnInfo(name = "rok")
    private int rokProdukcji;
    private Integer moc;

    public BMW(int id, String model, String typ, int rokProdukcji, Integer moc) {
        this.id = id;
        Model = model;
        Typ = typ;
        this.rokProdukcji = rokProdukcji;
        this.moc = moc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getTyp() {
        return Typ;
    }

    public void setTyp(String typ) {
        Typ = typ;
    }

    public int getRokProdukcji() {
        return rokProdukcji;
    }

    public void setRokProdukcji(int rokProdukcji) {
        this.rokProdukcji = rokProdukcji;
    }

    public Integer getMoc() {
        return moc;
    }

    public void setMoc(Integer moc) {
        this.moc = moc;
    }

    public BMW() {
    }

    @Override
    public String toString() {
        return "BMW{" +
                "id=" + id +
                ", Model='" + Model + '\'' +
                ", Typ='" + Typ + '\'' +
                ", rokProdukcji=" + rokProdukcji +
                ", moc=" + moc +
                '}';
    }
}
