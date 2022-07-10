/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Check;
import DTO.Food;
import DTO.FoodList;
import java.util.Scanner;

/**
 *
 * @author Xqy
 */
public class MyMenu {
    public static void main(String[] args) {
        FoodList list = new FoodList();
        Check c = new Check();
        System.out.println("Welcome to Food Management - @ 2021 by <SE150511 - Nguyen Thanh Trung>");
        boolean cont = false;
        int choice = 0;
        String filename = "";
        System.out.print("File name you want save: ");
        filename = c.checkFileName();
        list.readFromFile(filename);
        do {
            do {
                System.out.println("Select the options below: ");
                System.out.println("1. Add a new food");
                System.out.println("2. Search a food by name");
                System.out.println("3. Remove the food by ID");
                System.out.println("4. Print the food list in the descending order of expired date");
                System.out.println("5. Quit");
                System.out.print("Your choice: ");
                Scanner sc = new Scanner(System.in);
                choice = c.checkInt();
            } while (cont);
            
            switch (choice) {
                case 1:
                    int choice1 = 0;
                    do {
                        Food f = new Food();
                        do {
                            try {
                                f.input();
                                if (list.findFood(f.getId()) != -1) {
                                    throw new Exception();
                                }
                            } catch (Exception e) {
                                System.out.println("ID already exists, please retype !");
                            }
                        } while (list.findFood(f.getId()) != -1);
                        if (list.addFood(f)) {
                            System.out.println("Added.");
                        } else {
                            System.out.println("Add Failed, retype!");
                        }
                        System.out.println("Do you want to continue adding another food? Yes or No(1/0)");
                        choice1 = c.checkInt();
                    } while (choice1 == 1);
                    list.writeFile(filename);
                    break;
                case 2:
                    String name = "";                   
                    int choice2 = 0;
                    do {
                        name = c.checkName();
                        if (list.searchFoodByName(name) != null) {
                            list.printByname(name);
                        } else {
                            System.out.println("This food does not exist");
                        }
                        System.out.println("Do you want to continue search another food? Yes or No(1/0)");
                        choice2 = c.checkInt();
                    } while (choice2 == 1);
                    break;
                case 3:
                    String idR = "";
                    idR = c.checkId();
                    int choice3 =0;
                    System.out.print("Are you sure you want to delete this food?  Yes or No(1/0)");
                    choice3 = c.checkInt();
                    if(choice3 == 1){
                        if (list.removeFood(idR)) {
                            System.out.println("Removed.");
                        } else {
                            System.out.println("Removed failed!");
                        }
                    }
                    break;
                case 4:
                    list.printDes(filename);
                    break;
            }
        } while (choice > 0 && choice < 5);
        list.writeFile(filename);
    }
}
