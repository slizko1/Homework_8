package com.samoylenko;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //task1();
        //task2();
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
}



