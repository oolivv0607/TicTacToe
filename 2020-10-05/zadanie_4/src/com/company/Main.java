package com.company;

public class Main {

    public static void main(String[] args) {
        double liczba = 2.0;
        int dzielniki;
        int i = 0;

        for (dzielniki = 1; dzielniki <= liczba/2; dzielniki++)
        {
            if(liczba % dzielniki == 0)
            {
                i++;
            }
        }

        if(i <= 1)
        {
            if (liczba == 1.0)
            {
                System.out.println("To nie jest ani liczba pierwsza ani zlozona");
            }
            else if (liczba == 0.0)
            {
                System.out.println("To nie jest ani liczba pierwsza ani zlozona");
            }
            else
            {
                System.out.println("Liczba pierwsza" + i);
            }

        }
        else if (liczba == 2.0)
        {
            System.out.println("Liczba pierwsza" +i);
        }
        else
        {
            System.out.println("Liczba zlozona" +i);
        }

    }
}
