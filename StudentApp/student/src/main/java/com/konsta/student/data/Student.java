package com.konsta.student.data;



public class Student {
    private String name;
    private long id;
    private static long idCounter;
    private String luokka;
    

    
    public Student() {
        this("", "");
    }
    public Student(String name, String luokka) {
        this.luokka=luokka;
        this.name = name;
        this.id = idCounter++;
    }

    public String getLuokka() {
        return this.luokka;
    }

    public void setLuokka(String luokka) {
        this.luokka = luokka;
    }
     
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return this.id;
    }
}
