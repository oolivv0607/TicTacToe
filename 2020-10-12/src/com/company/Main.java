package com.company;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static String mR, ruch;

    public static void main(String[] args) {
    	ruchMoj();

		System.out.println("Ruch komputera...");

		ruchKomp();

		System.out.println("Wynik...");

		ktoWygral();
    }

    public static void ruchMoj(){
		System.out.println("Podaj swoj ruch");
		Scanner scan = new Scanner(System.in);
		mR = scan.nextLine();
	}

	public static void ruchKomp(){
    	Random r = new Random();
		int liczba = r.nextInt(3) + 1;

		switch (liczba){
			case 1:
				ruch = "kamien";
				System.out.println(ruch);
				break;
			case 2:
				ruch = "papier";
				System.out.println(ruch);
				break;
			default:
				ruch = "nozyce";
				System.out.println(ruch);
		}
	}

	public static void ktoWygral(){
		if (mR.equals(ruch))
		{
			System.out.println("Remis!");
		}
		else if ((mR.equals("kamien") && ruch.equals("nozyce")) || (mR.equals("nozyce") && ruch.equals("papier")) || (mR.equals("papier") && ruch.equals("kamien")))
		{
			System.out.println("Gratulacje! Wygrywasz!");
		}
		else
		{
			System.out.println("Niestety, przegrales :(");
		}
    }
}
