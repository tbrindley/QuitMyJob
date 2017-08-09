package com.jdbcdemo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Travis Brindley on 8/8/2017.
 */
public class BoLS {

    public String[] getBoLS(){
 /*     CATEGORY          BoLS Series ID      Array Position
        rent:             CXUHOUSINGLB1103M     0
        Utilities:       CXUUTILSLB1103M        1

        Auto Gas:        CXUGASOILLB1103M       2
        Insurance:       CXU500110LB1103M       3
        Car bill:        CXUVEHPURCHLB1103M     4

        Groceries:       CXUFOODHOMELB1103M     5
        Restaurants:     CXUFOODAWAYLB1103M     6

        Credit Card Debt: 189                   10
        Student Loans:   CXUEDUCATNLB1103M      7
        Other Debt: 0                           11

        MedicalInsurance:CXUHLTHINSRLB1103M     8
        Misc. Expenses:  CXUMISCLB1103M         9*/


        String[] userdata = new String[11];
        String jsonString;
        try {
            //the HTTPClient Interface represents the contract for the HTTP Request execution
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost postRequest = new HttpPost("https://api.bls.gov/publicAPI/v2/timeseries/data/");
            // StringEntity input = new StringEntity("{\"seriesid\":[\"CXUHOUSINGLB1103M\",\"CXUTRANSLB1103M\",\"CXUFOODTOTLLB1103M\",\"CXUMISCLB1103M\"]}");
            StringEntity input = new StringEntity("{\"seriesid\":[\"CXUHOUSINGLB1103M\",\"CXUUTILSLB1103M\",\"CXUGASOILLB1103M\",\"CXU500110LB1103M\",\"CXUVEHPURCHLB1103M\",\"CXUFOODHOMELB1103M\",\"CXUFOODAWAYLB1103M\"," +
                    "\"CXUEDUCATNLB1103M\",\"CXUHLTHINSRLB1103M\",\"CXUMISCLB1103M\"], \"registrationkey\": \"7d91307a15b744eca9c42ac828a1d070\"}");


            input.setContentType("application/json");
            postRequest.setEntity(input);
            HttpResponse response = httpClient.execute(postRequest);
            jsonString = EntityUtils.toString(response.getEntity());
            System.out.println(jsonString);
            JSONObject json = new JSONObject(jsonString);

            JSONArray series = json.getJSONObject("Results").getJSONArray("series");

            for(int i=0;i< series.length();i++){
                JSONArray data = series.getJSONObject(i).getJSONArray("data");
                String output = data.getJSONObject(0).getString("value");
                userdata[i] = output;
                System.out.println(userdata[i]);
            }

            int rent = Integer.parseInt(userdata[0])/12;
            int utilities = Integer.parseInt(userdata[1])/12;
            int gas = Integer.parseInt(userdata[2])/12;
            int carInsurance = Integer.parseInt(userdata[3])/12;
            int carPayment = Integer.parseInt(userdata[4])/12;
            int groceries = Integer.parseInt(userdata[5])/12;
            int restaurants = Integer.parseInt(userdata[6])/12;
            String cc = "189";
            int studentLoans = Integer.parseInt(userdata[7])/12;
            String miscDebt = "0";
            int medInsurance = Integer.parseInt(userdata[8])/12;
            int otherMisc = Integer.parseInt(userdata[9])/12;
            userdata[10]=cc;
            userdata[11]=miscDebt;

            System.out.println("------HOUSING STUFF-----");
            System.out.println("Housing: "+ rent);
            System.out.println("Utilities: "+ utilities);
            System.out.println("-------- TRANSPORTATION STUFF--------");
            System.out.println("Gas: "+ gas);
            System.out.println("Car Insurance: "+ carInsurance);
            System.out.println("Car Payment: "+ carPayment);
            System.out.println("------ FOOD STUFF --------");
            System.out.println("Groceries: "+ groceries);
            System.out.println("Restaurants: "+ restaurants);
            System.out.println("--------DEBT ---------");
            System.out.println("Monthly Credit Card Payments: " + cc);
            System.out.println("Monthly Student Loan Payment: " + studentLoans);
            System.out.println("Monthly Misc. Debt:" + miscDebt);
            System.out.println("-------- MISC -------");
            System.out.println("Monthly Medical Insurance: " + medInsurance);
            System.out.println("Other Misc:" + otherMisc);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return userdata;
    }
}
