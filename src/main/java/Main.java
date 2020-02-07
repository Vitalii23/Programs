import TaskFour.ArrayFetch;
import TaskOne.ViewList;
import TaskThree.Zero;
import TaskTwo.ValidationChecks;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if(args.length < 1){
            System.out.println("Please, enter the program\r\n" +
                    "java Main one\r\n" +
                    "java Main two\r\n" +
                    "java Main three\r\n" +
                    "java Main four\r\n");
            return;
        }
        Scanner command = new Scanner(System.in);
        switch (args[0]) {
            case "one":
                System.out.println("First program selected");
                ViewList one = new ViewList();
                one.run();
                break;
            case "two":
                System.out.println("Second program selected");
                ValidationChecks two = new ValidationChecks();
                System.out.println("Enter brackets to verify correctness\n" +
                        "Example: ([]) - right(true), ([]} - wrong(false)");
                two.run(command.nextLine());
                break;
            case "three":
                System.out.println("Third program selected");
                Zero three = new Zero();
                System.out.println("Enter the number that turn the right zero into one");
                three.run(command.nextLine());
                break;
            case "four":
                System.out.println("Fourth program selected");
                ArrayFetch four = new ArrayFetch();
                System.out.println("Enter array numbers");
                int[] array = new int[100];
                    for (int i = 0; i < array.length; i++) {
                        array[i] = command.nextInt();
                        four.insert(new int[]{array[i]});
                        four.selectNumber();
                        four.selectMissedNumber();
                    }
                    four.delete();
                    break;
            default:
                System.out.println("No such program");
                break;
        }
    }
}
