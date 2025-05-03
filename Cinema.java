package cinema;
import java.util.Scanner;
public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        UserUI userUI = new UserUI(sc);
        userUI.start();
    }
}