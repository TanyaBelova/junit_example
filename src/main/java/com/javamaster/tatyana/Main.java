package com.javamaster.tatyana;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        UsersService us = new UsersService();
        System.out.println("Write the name of the user: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("Write the date of birth of the user: ");
        LocalDate dateOfBirth = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        us.createNewUser(name, dateOfBirth);
        System.out.println("The user is created");
    }
}
