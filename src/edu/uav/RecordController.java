package edu.uav;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class RecordController {

    RecordService server = new RecordService();

    public void readFromFile(String s) throws FileNotFoundException {
        File file = new File(s);
        Scanner sc = new Scanner(file);
        String message;
        while (sc.hasNextLine()){
            message = sc.nextLine();
            Record record;
            record = server.createRecord(message);
            server.addRecord(record);
        }
        sc.close();
    }

     public String getIndex(int index) {
        String result = server.getIndex(index);
        return result;
    }
}
