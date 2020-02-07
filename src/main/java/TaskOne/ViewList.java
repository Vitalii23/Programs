package TaskOne;

import java.util.Random;

public class ViewList {

    public void run() {
        int[] array = new int[10];
        int[] count = new int[10];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
            System.out.print(array[i] + " ");
        }

        System.out.println();

        for (int i = 0; i < array.length; i++){
            count[array[i]]++;
        }

        System.out.println("number\tcount");
        for (int i = 0; i < count.length; i++){
            System.out.println(i + "\t" + count[i]);
        }
    }
}
