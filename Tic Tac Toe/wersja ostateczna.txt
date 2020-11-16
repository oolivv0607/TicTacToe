package com.company;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static int size;
    public static String input, usersChar, computersChar, anyChar;
    public static String[][] ticTacToeBoard;
    public static int row, column, input2, input3;

    public static void DataDownloading() {
        System.out.println("Enter the size of the array");
        Scanner scan = new Scanner(System.in);
        size = scan.nextInt();
        boolean condition1 = false;
        do {
            if (size < 3) {
                System.out.println("Error! The size of the array cannot be smaller than 3. Enter a value again.");
                size = scan.nextInt();
            } else {
                condition1 = true;
                ticTacToeBoard = new String[size+1][size+1];
            }
        } while (!condition1);

        for (int i = 0; i < ticTacToeBoard.length; i++) {
            for(int j = 0; j < ticTacToeBoard[i].length; j++) {
                ticTacToeBoard[i][j] = " ";
                ticTacToeBoard[0][i] = String.valueOf(i);
                ticTacToeBoard[j][0] = String.valueOf(j);
            }
        }
    }

    public static void ArrayDisplaying(String[][] ticTacToeBoard){
        for (String[] strings : ticTacToeBoard) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    public static void CharSelection(){
        System.out.println("Choose x or o");
        Scanner scan2 = new Scanner(System.in);
        input = scan2.next();
        boolean condition2 = false;
        do {
            if (input.equals("x")) {
                condition2 = true;
                usersChar = "x";
                computersChar = "o";
            } else if (input.equals("o")) {
                condition2 = true;
                usersChar = "o";
                computersChar = "x";
            } else {
                System.out.println("Error! The given char does not meet the requirements. Try again.");
                input = scan2.next();
            }
        } while(!condition2);
    }

    public static boolean YourTurn(String[][] ticTacToeBoard, String usersMark){
        System.out.println("Enter the row number");
        Scanner scan = new Scanner(System.in);
        input2 = scan.nextInt();
        if (input2 < 1 || input2 > size) {
            do {
                System.out.println("Error! The given number is outside the array index! Try again");
                input2 = scan.nextInt();
            } while (input2 < 1 || input2 > size);
        }
        row = input2;

        System.out.println("Enter the column number");
        Scanner scan2 = new Scanner(System.in);
        input3 = scan2.nextInt();
        if (input3 < 1 || input3 > size) {
            do {
                System.out.println("Error! The given number is outside the array index! Try again");
                input3 = scan.nextInt();
            } while (input3 < 1 || input3 > size);
        }
        column = input3;

        if (ticTacToeBoard[row][column].equals(" ")) {
            ticTacToeBoard[row][column] = usersMark;
            anyChar = usersMark;
            return true;
        } else {
            System.out.println("Invalid movement! Try again");
            return false;
        }
    }

    public static boolean ComputersTurn(String[][] ticTacToeBoard, String computersMark) {
        Random los = new Random();
        row = los.nextInt(size) + 1;
        Random los2 = new Random();
        column = los2.nextInt(size) + 1;
        if (ticTacToeBoard[row][column].equals(" ")) {
            ticTacToeBoard[row][column] = computersMark;
            anyChar = computersMark;
            return true;
        } else {
            return false;
        }
    }

    public static boolean WinInRows(String[][] ticTacToeBoard, String mark) {
        for (int w = 1; w <= size; w++) {
            boolean wygrana = true;
            for (int k = 1; k <= size; k++) {
                if (!ticTacToeBoard[w][k].equals(mark)) {
                    wygrana = false;
                    break;
                }
            }
            if (wygrana) {
                return true;
            }
        }
        return false;
    }

    public static boolean WinInColumns(String[][] ticTacToeBoard, String mark) {
        for (int k = 1; k <= size; k++) {
            boolean wygrana = true;
            for (int w = 1; w <= size; w++) {
                if (!ticTacToeBoard[w][k].equals(mark)) {
                    wygrana = false;
                    break;
                }
            }
            if (wygrana) {
                return true;
            }
        }
        return false;
    }

    public static boolean WinDiagonally1(String[][] ticTacToeBoard, String mark) {
        for (int i = 1; i <= size; i++) {
            if (!ticTacToeBoard[i][i].equals(mark)) {
                return false;
            }
        }
        return true;
    }

    public static boolean WinDiagonally(String[][] ticTacToeBoard, String mark) {
        for (int i = 0; i < size; i++) {
            if (!ticTacToeBoard[i + 1][size - i].equals(mark)) {
                return false;
            }
        }
        return true;
    }

    public static boolean CheckingWinning(String[][] ticTacToeBoard, String mark) {
        return WinInRows(ticTacToeBoard, mark) ||
                WinInColumns(ticTacToeBoard, mark) ||
                WinDiagonally1(ticTacToeBoard, mark) ||
                WinDiagonally(ticTacToeBoard, mark);
    }

    public static void main(String[] args) {
        DataDownloading();
        ArrayDisplaying(ticTacToeBoard);
        CharSelection();

        int move = 0;
        boolean win, finish = false;
        boolean uTurn, cTurn;

        while (move < size*size) {
            do {
                uTurn = YourTurn(ticTacToeBoard, usersChar);
            } while (!uTurn);
            move++;
            ArrayDisplaying(ticTacToeBoard);
            win = CheckingWinning(ticTacToeBoard, anyChar);
            if (win) {
                if (anyChar.equals(usersChar)) {
                    System.out.println("\nCongratulations! You won!");
                    finish = true;
                }
                else
                    System.out.println("\nYou lost");
                break;
            }

            System.out.println("\nComputer movement... ");
            do {
                cTurn = ComputersTurn(ticTacToeBoard, computersChar);
            } while (!cTurn);
            move++;
            ArrayDisplaying(ticTacToeBoard);
            win = CheckingWinning(ticTacToeBoard, anyChar);
            if (win) {
                if (anyChar.equals(usersChar)) {
                    System.out.println("\nCongratulations! You won!");
                    finish = true;
                }
                else
                    System.out.println("\nYou lost");
                break;
            }
        }
        if (!finish) {
            System.out.println("\nDraw!");
        }
    }
}