/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Xqy
 */
public class Food implements Serializable{
    private String id;
    private String name;
    private double weight;
    private String type;
    private String place;
    private String expiredDate;

    //Constructor
    public Food() {
        id = "";
        name = "";
        weight = 0.0;
        type = "";
        place = "";
        expiredDate = "";
    }

    public Food(String id, String name, double weight, String type, String place, String expiredDate) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.place = place;
        this.expiredDate = expiredDate;
    }
    //getters, setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    public void input() {
        Check c = new Check(); 
        id = c.checkId(); 
        name = c.checkName();
        weight = c.checkWeight();
        type = c.checkType();
        place = c.checkPlace();
        Scanner sc = new Scanner(System.in);
        Date d = null;
        do {
            System.out.print("Input expiredDate(dd/MM/yyyy): ");
            expiredDate = sc.nextLine();
            d = c.checkDate(expiredDate);
        } while (d == null);
    }

    @Override
    public String toString() {
        return id + "\t\t" + name + "\t\t" + weight + "\t\t" + type + "\t\t" + place + "\t\t" + expiredDate;
    }
}
