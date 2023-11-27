package com.tester.localtester.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class XtestModel implements Serializable {

    public String businessType;
    public String productCode;
    public String planType;
    public String planCode;
    public Integer policyTerm;
    public String insurerCode;
    public String InsuredTitle;
    public String insuredfirstName;
    public String insuredlastName;
    public String insuredEmail;
    public String insuredgender;
    public String insuredmobile;
    public String insureddob;
    public String city;
    public String pincode;
    public String address1;
    public String Phone;
    public Map<String, Map<String, Boolean>> plans;

    public String getPincode() {
        return pincode;
    }

//    public String getProductCode() {
//        return productCode;
//    }
//    public String getBusinessType() {
//        return businessType;
//    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
//    public void setProductCode(String productCode) {
//        this.productCode = productCode;
//    }
//    public void setBusinessType(String businessType) {
//        this.businessType = businessType;
//    }

    public Map<String, Map<String, Boolean>> getPlans() {
        return plans;
    }

    public void setPlans(Map<String, Map<String, Boolean>> plans) {
        this.plans = plans;
    }
}
