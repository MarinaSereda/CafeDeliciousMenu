package com.example.dima.myapplication;


import java.util.ArrayList;

public class CheckList {
    static String s;
    static int suma = 0;
    static ArrayList<String> list = new ArrayList<>();

    public static void setS(String s) {
        CheckList.s = s;
    }

    public static void addToBill() {
        list.add(s);
    }

    public static ArrayList<String> getList() {
        return list;
    }

    public static void Sum(int s) {
        suma += s;
        System.out.println(suma);
    }


}
