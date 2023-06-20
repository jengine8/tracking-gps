package com.gps.gps.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GpsTrackModel {

    public String rad;
    public String uti;
    public String dat;
    public String tim;
    public String hex;
    public String fli;
    public String src;
    public String lat;
    public String lon;
    public String alt;
    public String gda;
    public String spd;
    public String hea;
    public String vrt;
    public String cat;
    public String org;
    public String dst;
    public String opr;
    public String typ;
    public String reg;
    public String dis;
    public String dbm;
    public String cou;
    public String squ;
    public String tru;
    public String lla;
    public String rol;
    public String tra;
    public String qnh;
    public String flg;
    public String tcs;
    public String signal;
    public String alias;


    public void convertToKnots(){
        Double convertion = Double.parseDouble(this.getSpd()) * 1.9438;
        setSpd(String.valueOf(convertion));
    }

}
