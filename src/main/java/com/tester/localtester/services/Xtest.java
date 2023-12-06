package com.tester.localtester.services;

import com.tester.localtester.model.XtestModel;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Xtest {

    public static void main(String[] args) throws IOException {

        Map<String, String> mailData = new HashMap<>();

        int count = 10;
        String fileDirectory = "/Users/sumitjadiya/Downloads/";
        Reader csvFile = new FileReader(fileDirectory + "wellness_data - " + count + ".csv");

        String[] HEADERS = {
                "businessType",
                "productCode",
                "planType",
                "planCode",
                "policyTerm",
                "insurerCode",
                "Insured_title",
                "insured_firstName",
                "insured_lastName",
                "insured_email",
                "insured_gender",
                "insured_mobile",
                "insured_dob",
                "city",
                "pincode",
                "address1",
                "Phone_Contactability",
                "_id",
                "vertical",
                "creationsource",
                "issuancedate",
                "salesdetail_intermediaryloginid",
                "salesdetail_intermediaryinternalid",
                "insurer",
                "planname",
                "Repcheck"
        };

        final String digitalPlanConstant = "digital_Plan";
        final String actiHealthConstant = "acti_Health";
        final String actiHealthPlusConstant = "acti_Health_Plus";
        final String healthAssureOneConstant = "health_Assure_One";
        final String healthAssureOnePlusConstant = "health_Assure_One_Plus";
        final String svaasOPDHeroConstant = "OPD_Hero";
        final String svaasOPDPlusConstant = "OPD_Plus";
        final String svaasOPDPremiumConstant = "OPD_Premium";
        final String svaasOPDEliteConstant = "OPD_Elite";

        final String eKinCare = "ekinCare";
        final String healthAssure = "healthAssure";
        final String svaas = "svaas";

        Map<String, Boolean> ekinCareItems = new HashMap<>();
        Map<String, Boolean> healthAssureItems = new HashMap<>();
        Map<String, Boolean> svaasItems = new HashMap<>();

        Map<String, Map<String, Boolean>> plans = new HashMap<>();

        CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader(HEADERS).withTrim();

        Iterable<CSVRecord> records = csvFormat.parse(csvFile);

        List<XtestModel> lists = new ArrayList<>();

        System.out.println("use turtlefin");
        System.out.println("db.wellnessTestXYZ.insertMany([");

        for (CSVRecord record : records) {
            XtestModel model = new XtestModel();
            String businessType = record.get("businessType").trim();
            String productCode = record.get("productCode").trim();
            String planType = record.get("planType").trim();
            String planCode = record.get("planCode").trim();
            String policyTerm = record.get("policyTerm").trim();
            String insurerCode = record.get("insurerCode").trim();
            String pincode = record.get("pincode").trim();
            String firstName = record.get("insured_firstName").trim();
            String lastName = record.get("insured_lastName").trim();
            String mobile = record.get("insured_mobile").trim();
            String InsuredTitle = record.get("Insured_title").trim();
            String insuredEmail = record.get("insured_email").trim();
            String insuredgender = record.get("insured_gender").trim();
            String insuredmobile = record.get("insured_mobile").trim();
            String insureddob = record.get("insured_dob").trim();
            String city = record.get("city").trim();
            String address1 = record.get("address1").trim();


//            String digiPlan = record.get("Digital_Plan").trim();
//            String actiHealthPlan = record.get("Acti_Health").trim();
//            String actiHealthPlusPlan = record.get("Acti_Health_Plus").trim();
//            String healthAssureOnePlan = record.get("Health_Assure_One").trim();
//            String healthAssureOnePlusPlan = record.get("Health_Assure_One_Plus").trim();
//
//            String opdHero = record.get(svaasOPDHeroConstant).trim();
//            String opdPlus = record.get(svaasOPDPlusConstant).trim();
//            String opdPremium = record.get(svaasOPDPremiumConstant).trim();
//            String opdElite = record.get(svaasOPDEliteConstant).trim();

//            if (pincode.equals("Pincode")) continue;

//            if (digiPlan.length() > 0) ekinCareItems.put(digitalPlanConstant, true);
//            if (actiHealthPlan.length() > 0) ekinCareItems.put(actiHealthConstant, true);
//            if (actiHealthPlusPlan.length() > 0) ekinCareItems.put(actiHealthPlusConstant, true);
//            if (healthAssureOnePlan.length() > 0) healthAssureItems.put(healthAssureOneConstant, true);
//            if (healthAssureOnePlusPlan.length() > 0) healthAssureItems.put(healthAssureOnePlusConstant, true);
//
//            if (opdHero.length() > 0) svaasItems.put(svaasOPDHeroConstant, true);
//            if (opdPlus.length() > 0) svaasItems.put(svaasOPDPlusConstant, true);
//            if (opdPremium.length() > 0) svaasItems.put(svaasOPDPremiumConstant, true);
//            if (opdElite.length() > 0) svaasItems.put(svaasOPDEliteConstant, true);

//            plans.put(eKinCare, ekinCareItems);
//            plans.put(healthAssure, healthAssureItems);
//            plans.put(svaas, svaasItems);
//
            model.setPlanCode(planCode);
            model.setPincode(pincode);
            model.setInsuredfirstName(firstName);
            model.setInsuredlastName(lastName);
            model.setInsuredmobile(mobile);
            model.setProductCode(productCode);
            model.setBusinessType(businessType);
            model.setInsuredEmail(insuredEmail);
            model.setInsuredTitle(InsuredTitle);
            model.setInsuredgender(insuredgender);
            model.setInsureddob(insureddob);
            model.setCity(city);
            model.setAddress1(address1);
//            model.setPlans(plans);
//            plans = new HashMap<>();
//            ekinCareItems = new HashMap<>();
//            healthAssureItems = new HashMap<>();
//            svaasItems = new HashMap<>();

            lists.add(model);
        }

//        for (var val : lists) {
//            System.out.println("{\"pincode\":\"" + val.getPincode() + "\", \"plans\":" + val.getPlans()+"},");
//        }
        System.out.println("]);");

        File tempFile = new File(fileDirectory + "final" + count + ".json");
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
        String line = null;
        pw.println("[");
        lists.remove(0);

        Map<String, String> planCodeMapper = Map.of("OPD Lite", "OPD_LITE", "OPD Hero", "OPD_HERO");
        StringBuffer sb = new StringBuffer();


        for (var val : lists) {

            line = """
                    {"quoteRequest":{"data": {"businessType":"NEW", "productCode": "wellness", "premiumRequest":{"riskInsured":{"planCode":"%plancode%","planType":"INDIVIDUAL","pinCode": "%pincode%","policyTerm":1,"insurerCode":"SVAAS","fullName": "%fullname%","mobile":"%mobile%"}}}},
                    "proposalRequest":{"data":{"premiumResultId":"","referenceId":"","insurerCode": "SVAAS","productCode": "wellness","personalDetails":{"title":"%title%","firstName":"%firstName%","lastName":"%firstName%","email":"%email%","gender":"%gender%","mobile":"%mobile%","dob":"%dob%","annualSalary":"0"},"registeredAddress":{"city":"%city%","pincode":"%pincode%","address1":"%address1%","address2":""},"otherDetails":{},"insuredMembers":[{"name":"%fullname%","dob":"%dob%","type":"SELF"}]}},
                    "paymentRequest":{"data":{"productCode":"wellness","insurerCode":"SVAAS"}}},
                    """;

//            line = """
//                    {"quoteRequest":{"data": {"businessType":"NEW", "productCode": "wellness", "premiumRequest":{"riskInsured":{"planCode":"%plancode%","planType":"INDIVIDUAL","pinCode": "%pincode%","policyTerm":1,"insurerCode":"SVAAS","fullName": "%fullname%","mobile":"%mobile%"}}}}},
//                    {"proposalRequest":{"personalDetails":{"title":"%title%","firstName":"%firstName%","lastName":"%firstName%","email":"%email%","gender":"%gender%","mobile":"%mobile%","dob":"%dob%","annualSalary":"0"},"registeredAddress":{"city":"%city%","pincode":"%pincode%","address1":"%address1%","address2":""},"otherDetails":{},"insuredMembers":[{"name":"%fullname%","dob":"%dob%","type":"SELF"}]}},
//                    {"paymentRequest":{"data":{"productCode":"wellness","insurerCode":"SVAAS"}}},
//                    """;


            line = line.replace("%plancode%", planCodeMapper.get(val.planCode)).replace("%pincode%", val.pincode).replace("%fullname%", val.insuredfirstName + " " + val.insuredlastName)
                    .replace("%mobile%", val.insuredmobile).replace("%title%", val.InsuredTitle).replace("%firstName%", val.insuredfirstName).replace("%lastName%", val.insuredlastName)
                    .replace("%email%", val.insuredEmail).replace("%gender%", val.insuredgender).replace("%dob%", (val.insureddob)).replace("%city%", val.city).replace("%address1%", val.address1).replace("\n", "");

//            line = "{\"quoteRequest\":{\"data\": {\"businessType\":\"NEW\", \"productCode\": \"wellness\", \"premiumRequest\":{\"riskInsured\":{\"planCode\":\"" + val.planCode + "\",\"planType\":\"INDIVIDUAL\",\"pinCode\":\""+ val.pincode +"\",\"policyTerm\":1,\"insurerCode\":\"SVAAS\",\"fullName\":\""+ val.insuredfirstName+" "+val.insuredlastName + "\",\"mobile\":\""+val.insuredmobile+"\"}}}}},";
//            line = "{\"businessType\":\"" + val.pincode + "\", \"productCode\":" + val.productCode + "},";
//            line = line.replace("=", ":");
//            line = line.replace("ekinCare", "\"ekinCare\"");
//            line = line.replace("svaas", "\"svaas\"");
//            line = line.replace("healthAssure", "\"healthAssure\"");
//
//            line = line.replace("acti_Health_Plus", "\"acti_Health_Plus\"");
//            line = line.replace("acti_Health:", "\"acti_Health\":");
//            line = line.replace("digital_Plan", "\"digital_Plan\"");
//
//            line = line.replace("health_Assure_One:", "\"health_Assure_One\":");
//            line = line.replace("health_Assure_One_Plus", "\"health_Assure_One_Plus\"");
//
//            line = line.replace(svaasOPDEliteConstant, "\"opd_Elite\"");
//            line = line.replace(svaasOPDPremiumConstant, "\"opd_Premium\"");
//            line = line.replace(svaasOPDPlusConstant, "\"opd_Plus\"");
//            line = line.replace(svaasOPDHeroConstant, "\"opd_Hero\"");
//            pw.println(line);
            sb.append(line);
        }
        String finalString = sb.substring(0, sb.length() - 1).toString();
        pw.println(finalString);
        pw.println("]");

        pw.flush();
    }


    public static String updateDateFormat(String dateF) {

        String[] vals = dateF.split("/");
        return vals[1] + "/" + vals[0] + "/" + vals[2];
    }
}