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

    public static int[] getBoLS() {
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


        int[] userdata = new int[12];
        String jsonString;
        try {

            //the HTTPClient Interface represents the contract for the HTTP Request execution
            HttpClient httpClient = HttpClientBuilder.create().build();

            //connects to bls api
            HttpPost postRequest = new HttpPost("https://api.bls.gov/publicAPI/v2/timeseries/data/");

            //pulls specific search parameters
            StringEntity input = new StringEntity("{\"seriesid\":[\"CXUHOUSINGLB1103M\",\"CXUUTILSLB1103M\",\"CXUGASOILLB1103M\"," +
                    "\"CXU500110LB1103M\",\"CXUVEHPURCHLB1103M\",\"CXUFOODHOMELB1103M\",\"CXUFOODAWAYLB1103M\"," +
                    "\"CXUEDUCATNLB1103M\",\"CXUHLTHINSRLB1103M\",\"CXUMISCLB1103M\"]," +
                    " \"registrationkey\": \"7d91307a15b744eca9c42ac828a1d070\"}");


            input.setContentType("application/json");
            postRequest.setEntity(input);
            HttpResponse response = httpClient.execute(postRequest);
            jsonString = EntityUtils.toString(response.getEntity());
            System.out.println(jsonString); //test to ensure complete raw data is being returned
            JSONObject json = new JSONObject(jsonString);

            JSONArray series = json.getJSONObject("Results").getJSONArray("series");

            for (int i = 0; i < series.length(); i++) {  //checks each data series being pulled
                JSONArray data = series.getJSONObject(i).getJSONArray("data");
                String output = data.getJSONObject(0).getString("value");
                userdata[i] = Integer.parseInt(output)/12; // raw data is annual average so we divide by 12 to make it a monthly average

                System.out.println(userdata[i]); //test to verify specific
            }
            userdata[10] = 189; //national average CC payment per google search...no data was available on BLS
            userdata[11] = 0;  //represents misc. debt... set to 0 since it'll be different for everyone

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return userdata;
    }
}
