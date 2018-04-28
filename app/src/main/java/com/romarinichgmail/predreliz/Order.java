package com.romarinichgmail.predreliz;

public class Order {
    private String StartPoint;
    private String FinishPoint;
    private String DistanseTo;
    private String DistanseBetween;
    private String NameCargo;
    private String Prise;


    public Order() {

    }

    public Order(String startPoint, String finishPoint,  String distanseBetween, String nameCargo) {
        StartPoint = startPoint;
        FinishPoint = finishPoint;
        DistanseBetween = distanseBetween;
        NameCargo = nameCargo;


    }

    ////GETTER

    public String getStartPoint() {
        return StartPoint;
    }

    public String getFinishPoint() {
        return FinishPoint;
    }

    public String getDistanseTo() {
        return DistanseTo;
    }

    public String getDistanseBetween() {
        return DistanseBetween;
    }

    public String getNameCargo() {
        return NameCargo;
    }

    public String getPrise() {
        return Prise;
    }
    ///////SETTER

    public void setStartPoint(String startPoint) {
        StartPoint = startPoint;
    }

    public void setFinishPoint(String finishPoint) {
        FinishPoint = finishPoint;
    }

    public void setDistanseTo(String distanseTo) {
        DistanseTo = distanseTo;
    }

    public void setDistanseBetween(String distanseBetween) {
        DistanseBetween = distanseBetween;
    }

    public void setNameCargo(String nameCargo) {
        NameCargo = nameCargo;
    }

    public void setPrise(String prise) {
        Prise = prise;
    }
}

