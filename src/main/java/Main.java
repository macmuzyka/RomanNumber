import java.util.Scanner;

/**
 * Created by Maciej Muzyka
 * on 18.04.2021
 * TODO:
 */

class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        while(!quit) {
            try {
                System.out.println("Enter the number to be converted to its Roman representation:");
                int input = scanner.nextInt();
                RomanConverter converter = new RomanConverter();
                String romanSymbol = converter.convertToRoman(input);
                System.out.println(romanSymbol);
                quit = true;
            } catch (OutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
