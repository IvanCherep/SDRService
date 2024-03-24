package cdrservice;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import com.google.gson.Gson;

public class UDRReportGenerator {
    private static final String REPORTS_DIRECTORY = "reports/";

    public void generateReport(Map<String, UDR> udrMap) {
        for (UDR udr : udrMap.values()) {
            String fileName = REPORTS_DIRECTORY + udr.getMsisdn() + ".json";
            saveReportToFile(udr, fileName);
        }
        printAllReportSummary(udrMap);
    }

    public void generateReport(String msisdn, int month, Map<String, UDR> udrMap) {
        String fileName = REPORTS_DIRECTORY + msisdn + "_" + month + ".json";
        UDR udr = udrMap.get(msisdn);
        saveReportToFile(udr, fileName);
        printReportSummary(udr);
    }

    public void generateReport(String msisdn, Map<String, UDR> udrMap) {
        String fileName = REPORTS_DIRECTORY + msisdn + ".json";
        UDR udr = udrMap.get(msisdn);
        saveReportToFile(udr, fileName);
        printReportSummary(udr);
    }

    private void saveReportToFile(UDR udr, String fileName) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(udr, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printAllReportSummary(Map<String, UDR> udrMap) {
        for (UDR udr : udrMap.values()) {
            printReportSummary(udr);
        }
    }

    private void printReportSummary(UDR udr) {
        System.out.println("MSISDN: " + udr.getMsisdn());
        System.out.println("Incoming Call Total Time: " + formatDuration(udr.getIncomingCall().getTotalTime()));
        System.out.println("Outgoing Call Total Time: " + formatDuration(udr.getOutgoingCall().getTotalTime()));
        System.out.println();
    }

    private String formatDuration(long seconds) {
        long hours = seconds / 3600;
        long minutes = (seconds % 3600) / 60;
        long remainingSeconds = seconds % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, remainingSeconds);
    }
}
