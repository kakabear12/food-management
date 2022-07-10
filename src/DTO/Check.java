/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Xqy
 */
public class Check {
    public int checkInt() {
        int number;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                number = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("Invalid number, please input again!");
            }
        } while (true);
        return number;
    }

    public double checkWeight() {
        double w = 0.0;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print("Input weight: ");
                w = Double.parseDouble(sc.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("Invalid number, please input again!");
            }
        } while (true);
        return w;
    }

    public String checkId() {
        String id;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Input Id: ");
            id = sc.nextLine().toLowerCase();
            if (!id.trim().equals("")) {
                break;
            } else {
                System.err.println("Id is not empty, please input again!");
            }
        } while (true);
        return id;
    }

    public String checkType() {
        String type;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Input type: ");
            type = sc.nextLine();
            if (!type.trim().equals("")) {
                break;
            } else {
                System.err.println("Type is not empty, please input again!");
            }
        } while (true);
        return type;
    }

    public String checkName() {
        String name;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Input name: ");
            name = sc.nextLine();
            if (!name.trim().equals("")) {
                break;
            } else {
                System.err.println("Name is not empty, please input again!");
            }
        } while (true);
        return name;
    }

    public String checkPlace() {
        String place;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Input place : ");
            place = sc.nextLine();
            if (!place.trim().equals("")) {
                break;
            } else {
                System.err.println("Place is not empty, please input again!");
            }
        } while (true);
        return place;
    }

   
    public Date checkDate(String date) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        Date d;
        Date currentDate = new Date();
        try {
            d = df.parse(date);
            if (d.compareTo(currentDate) < 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Invalid expiry date!!!!");
            return null;
        }
        return d;
    }


    public String checkFileName() {
        String fn = "";
        Scanner sc = new Scanner(System.in);
        do {
            fn = sc.nextLine();
            if (!fn.trim().equals("")) {
                break;
            } else {
                System.err.println("Filename is not empty, please input again!");
            }
        } while (true);
        return fn;
    }
}
