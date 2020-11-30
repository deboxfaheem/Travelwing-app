package com.travelwings.trav_client.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InsuranceVoucherModel {

   // "qid": "#DB003813 -  - 3 July 2020",
   //         "insuranceVoucher": "http://deboxglobal.co.in/travcrm-latestinbound/upload/1596033690care-freedom.pdf"

    @SerializedName("qid")
    @Expose
    private String qid;
    @SerializedName("insuranceVoucher")
    @Expose
    private String insuranceVoucher;

    public InsuranceVoucherModel(String qid, String insuranceVoucher) {
        this.qid = qid;
        this.insuranceVoucher = insuranceVoucher;
    }

    public String getQid() {
        return qid;
    }

    public void setQid(String qid) {
        this.qid = qid;
    }

    public String getInsuranceVoucher() {
        return insuranceVoucher;
    }

    public void setInsuranceVoucher(String insuranceVoucher) {
        this.insuranceVoucher = insuranceVoucher;
    }
}
