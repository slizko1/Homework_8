package com.samoylenko;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //task1();
        task2();
    }

    //        1) Электронные часы показывают время в формате от 00:00 до 23:59.
//        Подсчитать сколько раз за сутки случается так, что слева от двоеточия
//        показывается симметричная комбинация для той, что справа от двоеточия (например, 02:20, 11:11 или 15:51).
    public static void task1() {
        String[] hours = new String[24];
        String[] minutes = new String[60];
        for (int i = 0; i < 60; i++) {
            if (i < 10) {
                hours[i] = "0" + Integer.toString(i);
                minutes[i] = "0" + Integer.toString(i);
            } else if (i < 24) {
                hours[i] = Integer.toString(i);
                minutes[i] = Integer.toString(i);
            } else
                minutes[i] = Integer.toString(i);
        }
        System.out.println(Arrays.toString(hours));
        System.out.println(Arrays.toString(minutes));
        int numberOfSymmetries = 0;
        for (String hour : hours) {
            for (String minute : minutes) {
                if (reverseString(hour).equals(minute)) {
                    numberOfSymmetries++;
                    break;
                }
            }
        }
        System.out.println("Number of symmetrical combinations: " + numberOfSymmetries);
    }

    public static String reverseString(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            result = str.charAt(i) + result;
        }
        return result;
    }

    //        2) Найти количество счастливых билетиков на трамвай от 000001 до 999999
    //        (те у которых сумма первых 3 цифр равна сумме последних 3)
    public static void task2() {
        StringBuilder[] tickets = new StringBuilder[999999];
        for (int i = 0; i < tickets.length; i++) {
            if (i < 10) {
                tickets[i] = new StringBuilder("00000").append(i + 1);
            } else if (i < 100) {
                tickets[i] = new StringBuilder("0000").append(i + 1);
            } else if (i < 1000) {
                tickets[i] = new StringBuilder("000").append(i + 1);
            } else if (i < 10000) {
                tickets[i] = new StringBuilder("00").append(i + 1);
            } else if (i < 100000) {
                tickets[i] = new StringBuilder("0").append(i + 1);
            } else {
                tickets[i] = new StringBuilder("").append(i + 1);
            }
        }
        int luckyTickets = 0;
        int sumFirstThreeDigits = 0;
        int sumLastThreeDigits = 0;
        for (StringBuilder ticket : tickets) {
            sumFirstThreeDigits = countTheSumOfFirstThreeDigits(ticket);
            sumLastThreeDigits = countTheSumOfLastThreeDigits(ticket);
            if (sumFirstThreeDigits == sumLastThreeDigits) {
                luckyTickets++;
            }
        }
        System.out.println("Number of lucky tickets = " + luckyTickets);
    }

    public static int countTheSumOfFirstThreeDigits(StringBuilder digits) {
        int n = Integer.parseInt(digits.substring(0, 3));
        int sum = 0;
        while (n != 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }

    public static int countTheSumOfLastThreeDigits(StringBuilder digits) {
        int n = Integer.parseInt(digits.substring(3, 6));
        int sum = 0;
        while (n != 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }
}




