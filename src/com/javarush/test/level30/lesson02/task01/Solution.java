package com.javarush.test.level30.lesson02.task01;

/* Осваиваем методы класса Integer
Используя метод Integer.parseInt(String, int) реализуйте логику метода convertToDecimalSystem,
который должен переводить переданную строку в десятичное число и возвращать его в виде строки.
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        String temp;
        if(s.startsWith("0x"))
        {
            temp = s.replace("0x", "");
            temp = String.valueOf(Integer.parseInt(temp, 16));
        }else
        if(s.startsWith("0b"))
        {
            temp = s.replace("0b", "");
            temp = String.valueOf(Integer.parseInt(temp, 2));
        }else
        if(s.startsWith("0"))
        {
            temp = s.replace("0", "");
            temp = String.valueOf(Integer.parseInt(temp, 8));
        }else
            temp = s;

        return temp;
    }
}
