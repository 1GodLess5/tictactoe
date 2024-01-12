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
        while (true){
            field = playerMove(0, field, userNames);
        }




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
        System.out.println();
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

    public static int[][] playerMove(int whichPlayer, int[][] field, String[] userNames) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(userNames[whichPlayer] + " ,please enter 1 - 9: ");
        int move;
        while (true) {
            try {
                move = scanner.nextInt();

                if (move < 1 || move > 9) {
                    System.out.println("Please choose 1 to 9.");
                    continue;
                }
                if (!isMoveValid(field, move)){
                    System.out.println("This square is already taken.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input.");
                scanner.next();
            }
        }

        int[] coordinates = intToCoordinates(move);
        field[coordinates[0]][coordinates[1]] = whichPlayer + 1;
        return field;
    }

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
    
    public static int checkWin(int[][] field){
        int totalTakenCount = 0;

        // check for horizontal and vertical win
        for (int i = 0; i < 3; i++){
            if (field[i][0] == field[i][1] && field[i][1]== field[i][2] && field[i][0] != 0){
                return field[i][0] - 1;
            }
            if (field[0][i] == field[1][i] && field[1][i]== field[2][i] && field[0][i] != 0){
                return field[i][0] - 1;
            }
        }

        // check for diagonal win
        if (field[0][0] == field[1][1] && field[1][1] == field[2][2] && field[0][0] != 0){
            return field[0][0] - 1;
        } else if (field[0][2] == field[1][1] && field[1][1] == field[2][0] && field[0][2] != 0){
            return field[0][2] - 1;
        }

        // check for tie
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                if (field[i][j] != 0){
                    totalTakenCount++;
                }
            }
        }
        if (totalTakenCount == 9){
            return 2;
        }

        // no winner, game continues
        return 3;
    }
    
    
    
    
    
}