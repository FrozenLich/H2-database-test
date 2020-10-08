package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Scanner;

@Component
public class DAO {
    private static ArrayList<HuluRegistration> registeredUser = new ArrayList<HuluRegistration>();

    public DAO() {
    }

    public HuluRegistration registerUser(HuluRegistration user) {
        registeredUser.add(user);
        return user;
    }

    public void deleteUser(String name) {
        registeredUser.removeIf(user -> user.getName().equals(name));
    }

    /*
     * This method only updates the user's name by input
     */
    public void updateUser(HuluRegistration user) {
        Scanner in = new Scanner(System.in);
        String newName = in.nextLine();

        user.setName(newName);
    }

//    public void printAllUser() {
//        for (HuluRegistration user : registeredUser) {
//            System.out.print(user.getName());
//            System.out.println("  " + user.getEmail());
//        }
//    }

    public ArrayList<HuluRegistration> printAllUser() {
        return registeredUser;
    }
}