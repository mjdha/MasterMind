package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        while (true) {
            ArrayList<String> colorValues = new ArrayList<>();
            colorValues.add("white");
            colorValues.add("blue");
            colorValues.add("red");
            colorValues.add("green");
            colorValues.add("orange");
            colorValues.add("yellow");

            int one = getRandomNumberInRange(0, 5);
            int two = getRandomNumberInRange(0, 5);
            int three = getRandomNumberInRange(0, 5);
            int four = getRandomNumberInRange(0, 5);


            ArrayList<String> thisGame = new ArrayList<>();
            thisGame.add(colorValues.get(one));
            thisGame.add(colorValues.get(two));
            thisGame.add(colorValues.get(three));
            thisGame.add(colorValues.get(four));
            System.out.println(thisGame);
            int colpos = 0;
            for (int i = 0; i < 12; i++) {
                colpos = logic(thisGame, dataentry(colorValues));
                if (colpos == 4) {
                    break;
                }
            }
            System.out.println(colpos);

            Scanner input = new Scanner(System.in);
            String playAgain = "";

            while (!playAgain.equalsIgnoreCase("yes") && !playAgain.equalsIgnoreCase("no")) {
                System.out.println("Would you like to play again? \nplease Enter Yes or No: ");
                playAgain = input.nextLine();
            }
            if (playAgain.equalsIgnoreCase("no")) {
                System.out.println("Game Over. Thanks for playing. :)");
                break;
            }

        }
    }

    public static ArrayList<String> dataentry(ArrayList<String> colors) {
        ArrayList<String> userin = new ArrayList<>(Arrays.asList("", "", "", "", "", "", ""));

        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {

            while (!colors.contains(userin.get(i))) {
                int colornum = i + 1;
                System.out.println("Please enter color " + colornum);
                userin.set(i, input.nextLine());
            }
            userin.set(4, "1");
            userin.set(5, "2");
            userin.set(6, "3");
        }
        return userin;
    }

    public static int logic(ArrayList<String> game, ArrayList<String> user) {
        int col = 0;
        int colpos = 0;
        ArrayList<String> unique = removeDuplicates(user);
        for (String element : unique) {
        }
        for (int i = 0; i < 4; i++) {

            if (game.get(i).equalsIgnoreCase(user.get(i))) {
                colpos += 1;
            }
            if (game.contains(unique.get(i))) {
                col += 1;

            }

        }
        System.out.println("correct color and position : " + colpos);
        System.out.println("colors that exist :" + col);
        return colpos;
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }


    static ArrayList<String> removeDuplicates(ArrayList<String> list) {

        // Store unique items in result.
        ArrayList<String> result = new ArrayList<>();

        // Record encountered Strings in HashSet.
        HashSet<String> set = new HashSet<>();

        // Loop over argument list.
        for (String item : list) {

            // If String is not in set, add it to the list and the set.
            if (!set.contains(item)) {
                result.add(item);
                set.add(item);
            }
        }
        return result;
    }
}

