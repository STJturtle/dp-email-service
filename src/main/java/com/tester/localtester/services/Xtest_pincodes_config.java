package com.tester.localtester.services;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;

public class Xtest_pincodes_config {

    public static void main(String[] args) throws IOException {

        String fileDirectory = "/Users/sumitjadiya/Downloads/";
        Reader csvFile = new FileReader(fileDirectory + "ltf - Sheet1.csv");

        String[] HEADERS = {
                "pincodes",
                "provider"
        };

        CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader(HEADERS).withTrim();
        Iterable<CSVRecord> records = csvFormat.parse(csvFile);

        File tempFile = new File(fileDirectory + "OUTPUT_PROD_main.json");
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
        pw.println("use turtlefin;");

        for (CSVRecord record : records) {
            if (record.get("pincodes").trim().equalsIgnoreCase("pincodes")) continue;

            pw.println("db.pincodesConfig.update({'pincode':" + record.get("pincodes").trim() + "},{'$push': {'personalLoan.providers': " + record.get("provider").trim() + "}},{'upsert': true}),");
        }

        pw.flush();
        System.out.println("done!");
    }
}