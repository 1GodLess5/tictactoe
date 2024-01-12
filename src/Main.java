import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] field = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        int userCount = 1;
        String firstPlayerName = userName(userCount);
        userCount++;
        String secondPlayerName = userName(userCount);

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

    public static String userName(int userCount){
        Scanner scanner = new Scanner(System.in);

        System.out.println("User " + userCount + " please enter your name:");
        return scanner.nextLine();
    }
}