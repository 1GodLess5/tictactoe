import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] field = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        String[] userNames = userName();
        System.out.println(Arrays.toString(userNames));
        drawField(field);



    }

    public static void drawField(int[][] field){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (field[i][j] == 0) {
                    if (j == 2){
                        System.out.print(" ");
                    }else{
                        System.out.print(" |");
                    }
                } else if (field[i][j] == 1) {
                    if (j == 2){
                        System.out.print("0");
                    }else{
                        System.out.print("0|");
                    }
                } else {
                    if (j == 2){
                        System.out.print("X");
                    }else{
                        System.out.print("X|");
                    }
                }
            }
            if (i != 2){
                System.out.println();
                System.out.print("-----");
                System.out.println();
            }
        }
    }

    public static String[] userName(){
        Scanner scanner = new Scanner(System.in);
        String[] userNames = new String[2];

        for (int i = 0; i < 2; i++){
            System.out.println("User " + (i + 1) + " please enter your name:");
            userNames[i] = scanner.nextLine();
        }

        return userNames;
    }

//    public static int[][] playerMove(int whichPlayer, int[][] field, String[][] userNames) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println(Arrays.toString(userNames[whichPlayer]) + "please enter 1 - 9: ");
//        int move;
//        while (true) {
//            try {
//                move = scanner.nextInt();
//
//                if (move < 1 || move > 9) {
//                    continue;
//                }
//                break;
//            } catch (Exception e) {
//                System.out.println("Invalid input.");
//            }
//        }
//
//        int[] coordinates = intToCoordinates(move);
//        field[coordinates[0]][coordinates[1]] = whichPlayer + 1;
//
//    }

    public static int[] intToCoordinates(int move){
        int[] coordinates = new int[2];

        switch (move){
            case 1 -> {
                coordinates[0] = 0;
                coordinates[1] = 0;
            }case 2 -> {
                coordinates[0] = 0;
                coordinates[1] = 1;
            }case 3 -> {
                coordinates[0] = 0;
                coordinates[1] = 2;
            }case 4 -> {
                coordinates[0] = 1;
                coordinates[1] = 0;
            }case 5 -> {
                coordinates[0] = 1;
                coordinates[1] = 1;
            }case 6 -> {
                coordinates[0] = 1;
                coordinates[1] = 2;
            }case 7 -> {
                coordinates[0] = 2;
                coordinates[1] = 0;
            }case 8 -> {
                coordinates[0] = 2;
                coordinates[1] = 1;
            }case 9 -> {
                coordinates[0] = 2;
                coordinates[1] = 2;
            }
        }
        return coordinates;
    }

    public static boolean isMoveValid(int[][] field, int move){
        int[] coordinates = intToCoordinates(move);
        boolean validity = false;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (coordinates[0] == i && coordinates[1] == j) {
                    if (field[i][j] == 0){
                        validity = true;
                    }
                }
            }
        }
        return validity;
    }

}