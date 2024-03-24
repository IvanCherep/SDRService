package cdrservice;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.Random;

public class CDRGenerator {
    private static final int NUMBER_OF_RECORDS = 100;
    private static final long ONE_YEAR_SECONDS = 365 * 24 * 60 * 60;

    public static void generateCDRFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            Random random = new Random();

            for (int i = 0; i < NUMBER_OF_RECORDS; i++) {
                String callType = random.nextBoolean() ? "01" : "02";
                String phoneNumber = getPhoneNumberFromDatabase();
                long startTime = getRandomTimeWithinOneYear(random);
                long endTime = startTime + random.nextInt(3600);
                String cdrRecord = String.format("%s,%s,%d,%d%n", callType, phoneNumber, startTime, endTime);
                writer.write(cdrRecord);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPhoneNumberFromDatabase() {
        return "79876543221";
    }

    private static long getRandomTimeWithinOneYear(Random random) {
        long currentTimestamp = Instant.now().getEpochSecond();
        long oneYearAgoTimestamp = currentTimestamp - ONE_YEAR_SECONDS;
        return oneYearAgoTimestamp + random.nextInt((int) ONE_YEAR_SECONDS);
    }
}

