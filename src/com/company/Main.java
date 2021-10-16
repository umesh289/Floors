package com.company;

import java.util.*;

public class Main {

        int numberOfFloors;

        // Area
        List<Integer> areasList = new ArrayList<>();

        public static void main(String[] args) {
            // write your code here
            Scanner scanner = new Scanner(System.in);

            Main driver = new Main();
            driver.enterDetails(scanner);

            driver.performConstruction();
        }

        private void enterDetails(Scanner scanner){
            System.out.println("Enter the total no of floors in the building");
            numberOfFloors = scanner.nextInt();

            for (int i=1; i <= numberOfFloors; i++){
                System.out.println("enter the floor size given on day : " + i);
                int area  = scanner.nextInt();
                areasList.add(area);
            }
        }

        private void performConstruction() {
            int expectedArea = numberOfFloors;
            ArrayList<Integer> pendingList = new ArrayList<>();
            System.out.println("The order of construction is as follows");

            for (int day=0; day < numberOfFloors; day++) {
                int area = areasList.get(day);

                System.out.println("Day : " + (day + 1));

                if (area == expectedArea) {

                    pendingList.add(area);

                    Collections.sort(pendingList);

                    for (int i = pendingList.size() - 1; i >= 0; i--) {
                        if (expectedArea == pendingList.get(i)) {
                            System.out.print(pendingList.remove(i));
                            System.out.print(" ");

                            expectedArea --;
                        } else {
                            break;
                        }
                    }
                    System.out.println();

                } else {
                    pendingList.add(area);
                    System.out.println();
                }

            }
        }
}
