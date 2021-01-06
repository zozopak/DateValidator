package com.example;

import java.util.Scanner;

public class DateApp {


    public static void main(String[] args) {
        int mount;
        int day;
        int targetmount;
        int targetDay;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("please enter a date");

            String string = scanner.nextLine();
            String[] strings = string.split("/");
            if (dateValidator(strings)) {
                mount = Integer.parseInt(strings[0]);
                day = Integer.parseInt(strings[1]);
                break;
            } else {
                System.err.println("not valid");
            }

        }
        System.out.println("please enter a day");
        String dayName = scanner.nextLine();
        int dayNumber = Integer.parseInt(dayName);

        while (true) {
            System.out.println("please enter target date!");

            String string = scanner.next();
            String[] strings = string.split("/");
            if (dateValidator(strings)) {
                targetmount = Integer.parseInt(strings[0]);
                targetDay = Integer.parseInt(strings[1]);
                break;
            } else {
                System.err.println("not valid");
            }

        }
        goToTarget(mount, day, targetmount, targetDay, dayNumber);


    }


    private static boolean dateValidator(String[] strings) {
        boolean b = false;
        int mount = Integer.parseInt(strings[0]);


        int day = Integer.parseInt(strings[1]);


        if ((mount < 7 && day < 32))
            b = true;
        if (mount > 6 && mount < 12 && day < 31)
            b = true;
        if (mount == 12 && day < 30)
            b = true;

        return b;
    }

    private static void goToTarget(int mount, int day, int targetmount, int targetDay, int dayNumber) {
        int dayDiff;
        int mountDiff = targetmount - mount;

        if (mountDiff == 0) {
            dayDiff = targetDay - day;

        }else {

            int first;
            int last = targetDay;
            if(mount<7){
                first=31-day;
            }else {
                first= 30-day;
            }
            int sum=0;
            if (mountDiff>0){

                for (int i = mount+1; i < targetmount; i++) {

                    if (i < 7) {
                        sum += 31;

                    } else {
                        sum += 30;
                    }
                }
            }else {
                for (int i = (12-mount)+1; i <targetmount ; i++) {


                    if (i < 7) {
                        sum += 31;

                    } else {
                        sum += 30;
                    }
                }
            }
            dayDiff = first + last+sum;
            getDayNumber(dayDiff, dayNumber);



        }
    }



    private static void getDayNumber(int dayDiff, int dayNumber) {
        int day= dayDiff%7+dayNumber;
        if(day>6) {
            day -= 7;

        }
        switch (day){
            case 0 :System.out.println("the day  is : Saturday");
                break;
            case 1 :System.out.println("the day  is : Sunday");
                break;
            case 2 :System.out.println("the day  is : Monday");
                break;
            case 3 :System.out.println("the day  is : Thuesday");
                break;
            case 4 :System.out.println("the day  is : Wednesday");
                break;
            case 5 :System.out.println("the day  is : Thursday");
                break;
            case 6 :System.out.println("the day  is : Friday");
                break;
            default:
                break;
        }


    }
}


