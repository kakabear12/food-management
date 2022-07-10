/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Xqy
 */
public class FoodList {

    ArrayList<Food> list;

    public FoodList() {
        list = new ArrayList<>();
    }

    public boolean addFood(Food f) {
        return list.add(f);
    }

    public void displayAll() {
        for (Food f : list) {
            System.out.println(f);;
        }
    }
//search stt of food

    public int findFood(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
//search food by id

    public Food searchFood(String id) {
        for (Food f : list) {
            if (f.getId().equals(id)) {
                return f;
            }
        }
        return null;
    }
//search food by name

    public Food searchFoodByName(String name) {
        for (Food f : list) {
            if (f.getName().equals(name)) {
                return f;
            }
        }
        return null;
    }

//remove by id
    public boolean removeFood(String id) {
        Food Tmp = searchFood(id);
        return list.remove(Tmp);
    }
//write to file

    public void writeFile(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Food f : list) {
                bw.write(f.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Have error!");
        }

    }

//read from file and add data to list
    public ArrayList<Food> readFromFile(String filename) {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split("\t\t");
                String id = txt[0].toLowerCase();
                String name = txt[1].toLowerCase();
                double weight = Double.parseDouble(txt[2]);
                String type = txt[3].toLowerCase();
                String place = txt[4].toLowerCase();
                String expiredDate = txt[5];
                list.add(new Food(id, name, weight, type, place, expiredDate));
            }
            br.close();
            fr.close();
        } catch (Exception e) {
        }
        return list ;
    }

    //output search by name
    public boolean printByname(String name) {
        System.out.println("List of search by name: ");
        System.out.println("ID\t\t" + "NAME\t\t" + "WEIGHT\t\t" + "TYPE\t\t" + "PLACE\t\t" + "EXPIRED DATE\t\t");
        for (Food f : list) {
            if (f.getName().equals(name)) {
                System.out.println(f);
            }
        }
        return true;
    }

    public boolean printDes(String filename) {
        Collections.sort(list, new Comparator<Food>() {
            DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
            @Override
            public int compare(Food f1, Food f2) {
                try {
                    return d.parse(f2.getExpiredDate()).compareTo(d.parse(f1.getExpiredDate()));
                } catch (ParseException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        });
        System.out.println("ID\t\t" + "NAME\t\t" + "WEIGHT\t\t" + "TYPE\t\t" + "PLACE\t\t" + "EXPIRED DATE\t\t");
        for (Food f : list) {
            System.out.println(f);
        }
        return true;
    }
}
