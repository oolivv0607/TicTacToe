package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	System.out.println("Podaj promien kuli");
	Scanner scan = new Scanner(System.in);
	String promien = scan.nextLine();
	double r = Double.parseDouble(promien);
	double obj = 4.0 / 3 * 3.14 * r * r * r;

	System.out.println("Objetosc kuli wynosi: " + obj);

    }
}
