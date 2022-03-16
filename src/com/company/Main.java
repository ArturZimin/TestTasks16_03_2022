package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {


        copyArrayTwoDimensional(createTwoDimensionalArrayRandomNumbers());


//        System.out.println(countOnSalaryWeekly(6, 45));
//
//        guessTheGame();
//        findPrimeNumbersUpTo100(100);
//
//        double[] arr = new double[10];
//        arr[0] = 8.9;
//        arr[1] = 3.5;
//        arr[2] = 3.5;
//        arr[3] = 3.5;
//        arr[4] = 3.5;
//        arr[5] = 3.3;
//        arr[6] = 3.5;
//        arr[7] = 7.2;
//        arr[8] = 2.7;
//        arr[9] = 9.5;
//
//        System.out.println("\n The average number from the array is : " + findAverageArray(arr));

    }

    /**
     * 1. Напишите программу, которая вычислит простые числа в пределах от 2
     * до 100.
     */
    public static ArrayList<Integer> findPrimeNumbersUpTo100(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>(80);
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                list.add(i);
            }
        }
        for (Integer i : list
        ) {
            System.out.print("[" + i + "], ");

        }
        return list;
    }


    /**
     * 2. Найдите среднее арифметическое массива из 10 элементов типа double.
     */

    public static double findAverageArray(double[] d) {

        double sum = 0;
        for (int i = 0; i < d.length; i++) {
            sum += d[i];

        }
        return (sum / d.length);
    }


    /**
     * 3. Создайте простую игру, основанную на угадывании букв.
     * Пользователь должен угадать загаданную букву A-Z введя ее в консоль.
     * Если пользователь угадал букву, программа выведет «Right» и игра
     * закончится, если нет, то пользователь продолжит вводить буквы.
     * (Опционально) Вывести «You’re too low»- если пользователь ввел букву
     * меньше загаданной, «You’re too high»- если пользователь ввел букву
     * больше загаданной.
     */

    public static void guessTheGame() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String check = "[A-Z]";
        System.out.println("Welcome to the guessing game! Enter a letter from A-Z");
        Random random = new Random();
        int randomNumber = random.nextInt((90 - 65)) + 65;
        char c = (char) randomNumber;
        int count = 0;
        String readTxt = "";
        try {
            readTxt = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (readTxt.matches(check)) {
            count++;
            if (readTxt.equals(Character.toString(c))) {
                System.out.println("Right! You guessed right on the " + count + " try.");
                break;
            } else {
                System.out.println("Try again!");
                try {
                    readTxt = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    /**
     * 4. Создайте метод, который будет считать, сколько денег получает
     * работник в неделю. Метод должен принимать на входе два аргумента
     * (зарплата в час, кол-во проработанных часов).
     * Условия:
     * 1) Каждый час после 40 считается за полтора.
     * 2) Работник не может работать больше, чем 60 часов в неделю.
     * 3) Работник не может получать меньше 8 долларов в час.
     */

    public static double countOnSalaryWeekly(int salaryInHour, int countWorkedHours) {
        double salaryWeekly = 0;
        if (salaryInHour < 8) {
            salaryInHour = 8;
        } else if (countWorkedHours > 60) {
            countWorkedHours = 60;
        }
        if (countWorkedHours > 40) {
            int subtract = countWorkedHours - 40;
            salaryWeekly = (salaryInHour * 40) + ((subtract * 1.5) * salaryInHour);
        } else {
            salaryWeekly = salaryInHour * countWorkedHours;
        }

        return salaryWeekly;
    }

    /**
     * 5. У вас есть двухмерный массив наполненный случайными числами, в
     * той же последовательности перенесите эти числа в одномерный массив.
     */

    public static int[][] copyArrayTwoDimensional(int[][] arr) {
        if (arr == null) {
            return null;
        }
        int[][] newArr = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i].clone();
        }
        return newArr;

    }

    public static int[][] createTwoDimensionalArrayRandomNumbers() {
        Random random = new Random();
        int[][] arr = new int[10][10];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = ((int) ((Math.random() * 61) + 20));//от 20-60
            }
        }
        for (int[] array : arr) {
            for (int array2 : array
            ) {
                System.out.println(array2 + " ");
            }
            System.out.println();
        }
        return arr;
    }
}



