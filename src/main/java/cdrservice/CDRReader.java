package cdrservice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CDRReader {
    public static Map<String, CallStats> readCDRFile(String fileName) {
        Map<String, CallStats> cdrData = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String callType = parts[0];
                    String phoneNumber = parts[1];
                    long startTime = Long.parseLong(parts[2]);
                    long endTime = Long.parseLong(parts[3]);
                    long duration = endTime - startTime;

                    cdrData.putIfAbsent(phoneNumber, new CallStats());
                    CallStats callStats = cdrData.get(phoneNumber);
                    callStats.addDuration(duration);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cdrData;
    }
}
