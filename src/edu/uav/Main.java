package edu.uav;

import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        RecordController controller = new RecordController();
        controller.readFromFile("src/message.txt");

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String com = scanner.next();
            if (com.matches("\\d+")) {
                int index = Integer.valueOf(com);
                String result = controller.getIndex(index);
                System.out.println(result);
            } else {
                break;
            }
        }
    }
}