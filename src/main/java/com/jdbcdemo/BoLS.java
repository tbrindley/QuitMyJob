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
        String[] userdata = new String[8];
        try {
            //the HTTPClient Interface represents the contract for the HTTP Request execution
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost postRequest = new HttpPost("https://api.bls.gov/publicAPI/v2/timeseries/data/");
            StringEntity input = new StringEntity("{\"seriesid\":[\"SUUR0000SAF\",\"SUUR0000SAH\"]}");

            //Housing annual average:  need to divide by 12     CXUHOUSINGLB0701M
            //Transportation annual averages:  need to divide by 12    CXUTRANSLB1103M
            // savings
            //food annual averages:  need to divide by 12   CXUFOODTOTLLB1103M
            //other expenses annual averages:  need to divide by 12    CXUMISCLB1103M
            // debt  expenses annual "divide by 12"   5,252

            input.setContentType("application/json");
            postRequest.setEntity(input);
            // HttpResponse response = httpClient.execute(postRequest);
            //  jsonString = EntityUtils.toString(response.getEntity());
            String jsonString = "{\"status\":\"REQUEST_SUCCEEDED\",\"responseTime\":41,\"message\":[],\"Results\":{\n" +
                    "\"series\":\n" +
                    "[{\"seriesID\":\"SUUR0000SAF\",\"data\":[{\"year\":\"2017\",\"period\":\"M06\",\"periodName\":\"June\",\"value\":\"142.970\",\"footnotes\":[{\"code\":\"I\",\"text\":\"Initial\"}]},{\"year\":\"2017\",\"period\":\"M05\",\"periodName\":\"May\",\"value\":\"143.196\",\"footnotes\":[{\"code\":\"I\",\"text\":\"Initial\"}]},{\"year\":\"2017\",\"period\":\"M04\",\"periodName\":\"April\",\"value\":\"143.088\",\"footnotes\":[{\"code\":\"I\",\"text\":\"Initial\"}]},{\"year\":\"2017\",\"period\":\"M03\",\"periodName\":\"March\",\"value\":\"142.776\",\"footnotes\":[{\"code\":\"U\",\"text\":\"Interim\"}]},{\"year\":\"2017\",\"period\":\"M02\",\"periodName\":\"February\",\"value\":\"142.563\",\"footnotes\":[{\"code\":\"U\",\"text\":\"Interim\"}]},{\"year\":\"2017\",\"period\":\"M01\",\"periodName\":\"January\",\"value\":\"142.269\",\"footnotes\":[{\"code\":\"U\",\"text\":\"Interim\"}]},{\"year\":\"2016\",\"period\":\"M12\",\"periodName\":\"December\",\"value\":\"141.721\",\"footnotes\":[{\"code\":\"U\",\"text\":\"Interim\"}]},{\"year\":\"2016\",\"period\":\"M11\",\"periodName\":\"November\",\"value\":\"141.797\",\"footnotes\":[{\"code\":\"U\",\"text\":\"Interim\"}]},{\"year\":\"2016\",\"period\":\"M10\",\"periodName\":\"October\",\"value\":\"142.161\",\"footnotes\":[{\"code\":\"U\",\"text\":\"Interim\"}]},{\"year\":\"2016\",\"period\":\"M09\",\"periodName\":\"September\",\"value\":\"142.047\",\"footnotes\":[{\"code\":\"U\",\"text\":\"Interim\"}]},{\"year\":\"2016\",\"period\":\"M08\",\"periodName\":\"August\",\"value\":\"141.919\",\"footnotes\":[{\"code\":\"U\",\"text\":\"Interim\"}]},{\"year\":\"2016\",\"period\":\"M07\",\"periodName\":\"July\",\"value\":\"141.836\",\"footnotes\":[{\"code\":\"U\",\"text\":\"Interim\"}]},{\"year\":\"2016\",\"period\":\"M06\",\"periodName\":\"June\",\"value\":\"141.804\",\"footnotes\":[{}]},{\"year\":\"2016\",\"period\":\"M05\",\"periodName\":\"May\",\"value\":\"142.112\",\"footnotes\":[{}]},{\"year\":\"2016\",\"period\":\"M04\",\"periodName\":\"April\",\"value\":\"142.404\",\"footnotes\":[{}]},{\"year\":\"2016\",\"period\":\"M03\",\"periodName\":\"March\",\"value\":\"142.190\",\"footnotes\":[{}]},{\"year\":\"2016\",\"period\":\"M02\",\"periodName\":\"February\",\"value\":\"142.615\",\"footnotes\":[{}]},{\"year\":\"2016\",\"period\":\"M01\",\"periodName\":\"January\",\"value\":\"142.500\",\"footnotes\":[{}]},{\"year\":\"2015\",\"period\":\"M12\",\"periodName\":\"December\",\"value\":\"142.060\",\"footnotes\":[{}]},{\"year\":\"2015\",\"period\":\"M11\",\"periodName\":\"November\",\"value\":\"142.334\",\"footnotes\":[{}]},{\"year\":\"2015\",\"period\":\"M10\",\"periodName\":\"October\",\"value\":\"142.765\",\"footnotes\":[{}]},{\"year\":\"2015\",\"period\":\"M09\",\"periodName\":\"September\",\"value\":\"142.491\",\"footnotes\":[{}]},{\"year\":\"2015\",\"period\":\"M08\",\"periodName\":\"August\",\"value\":\"141.821\",\"footnotes\":[{}]},{\"year\":\"2015\",\"period\":\"M07\",\"periodName\":\"July\",\"value\":\"141.396\",\"footnotes\":[{}]},{\"year\":\"2015\",\"period\":\"M06\",\"periodName\":\"June\",\"value\":\"141.317\",\"footnotes\":[{}]},{\"year\":\"2015\",\"period\":\"M05\",\"periodName\":\"May\",\"value\":\"141.324\",\"footnotes\":[{}]},{\"year\":\"2015\",\"period\":\"M04\",\"periodName\":\"April\",\"value\":\"141.279\",\"footnotes\":[{}]},{\"year\":\"2015\",\"period\":\"M03\",\"periodName\":\"March\",\"value\":\"141.175\",\"footnotes\":[{}]},{\"year\":\"2015\",\"period\":\"M02\",\"periodName\":\"February\",\"value\":\"141.414\",\"footnotes\":[{}]},{\"year\":\"2015\",\"period\":\"M01\",\"periodName\":\"January\",\"value\":\"141.363\",\"footnotes\":[{}]}]},\n" +
                    "{\"seriesID\":\"SUUR0000SAH\",\"data\":[{\"year\":\"2017\",\"period\":\"M06\",\"periodName\":\"June\",\"value\":\"148.115\",\"footnotes\":[{\"code\":\"I\",\"text\":\"Initial\"}]},{\"year\":\"2017\",\"period\":\"M05\",\"periodName\":\"May\",\"value\":\"147.386\",\"footnotes\":[{\"code\":\"I\",\"text\":\"Initial\"}]},{\"year\":\"2017\",\"period\":\"M04\",\"periodName\":\"April\",\"value\":\"146.884\",\"footnotes\":[{\"code\":\"I\",\"text\":\"Initial\"}]},{\"year\":\"2017\",\"period\":\"M03\",\"periodName\":\"March\",\"value\":\"146.577\",\"footnotes\":[{\"code\":\"U\",\"text\":\"Interim\"}]},{\"year\":\"2017\",\"period\":\"M02\",\"periodName\":\"February\",\"value\":\"146.421\",\"footnotes\":[{\"code\":\"U\",\"text\":\"Interim\"}]},{\"year\":\"2017\",\"period\":\"M01\",\"periodName\":\"January\",\"value\":\"145.978\",\"footnotes\":[{\"code\":\"U\",\"text\":\"Interim\"}]},{\"year\":\"2016\",\"period\":\"M12\",\"periodName\":\"December\",\"value\":\"145.280\",\"footnotes\":[{\"code\":\"U\",\"text\":\"Interim\"}]},{\"year\":\"2016\",\"period\":\"M11\",\"periodName\":\"November\",\"value\":\"144.970\",\"footnotes\":[{\"code\":\"U\",\"text\":\"Interim\"}]},{\"year\":\"2016\",\"period\":\"M10\",\"periodName\":\"October\",\"value\":\"144.993\",\"footnotes\":[{\"code\":\"U\",\"text\":\"Interim\"}]},{\"year\":\"2016\",\"period\":\"M09\",\"periodName\":\"September\",\"value\":\"144.915\",\"footnotes\":[{\"code\":\"U\",\"text\":\"Interim\"}]},{\"year\":\"2016\",\"period\":\"M08\",\"periodName\":\"August\",\"value\":\"144.523\",\"footnotes\":[{\"code\":\"U\",\"text\":\"Interim\"}]},{\"year\":\"2016\",\"period\":\"M07\",\"periodName\":\"July\",\"value\":\"144.218\",\"footnotes\":[{\"code\":\"U\",\"text\":\"Interim\"}]},{\"year\":\"2016\",\"period\":\"M06\",\"periodName\":\"June\",\"value\":\"143.827\",\"footnotes\":[{}]},{\"year\":\"2016\",\"period\":\"M05\",\"periodName\":\"May\",\"value\":\"142.966\",\"footnotes\":[{}]},{\"year\":\"2016\",\"period\":\"M04\",\"periodName\":\"April\",\"value\":\"142.419\",\"footnotes\":[{}]},{\"year\":\"2016\",\"period\":\"M03\",\"periodName\":\"March\",\"value\":\"142.220\",\"footnotes\":[{}]},{\"year\":\"2016\",\"period\":\"M02\",\"periodName\":\"February\",\"value\":\"141.936\",\"footnotes\":[{}]},{\"year\":\"2016\",\"period\":\"M01\",\"periodName\":\"January\",\"value\":\"141.661\",\"footnotes\":[{}]},{\"year\":\"2015\",\"period\":\"M12\",\"periodName\":\"December\",\"value\":\"141.157\",\"footnotes\":[{}]},{\"year\":\"2015\",\"period\":\"M11\",\"periodName\":\"November\",\"value\":\"141.124\",\"footnotes\":[{}]},{\"year\":\"2015\",\"period\":\"M10\",\"periodName\":\"October\",\"value\":\"141.214\",\"footnotes\":[{}]},{\"year\":\"2015\",\"period\":\"M09\",\"periodName\":\"September\",\"value\":\"141.377\",\"footnotes\":[{}]},{\"year\":\"2015\",\"period\":\"M08\",\"periodName\":\"August\",\"value\":\"141.177\",\"footnotes\":[{}]},{\"year\":\"2015\",\"period\":\"M07\",\"periodName\":\"July\",\"value\":\"141.123\",\"footnotes\":[{}]},{\"year\":\"2015\",\"period\":\"M06\",\"periodName\":\"June\",\"value\":\"140.761\",\"footnotes\":[{}]},{\"year\":\"2015\",\"period\":\"M05\",\"periodName\":\"May\",\"value\":\"140.011\",\"footnotes\":[{}]},{\"year\":\"2015\",\"period\":\"M04\",\"periodName\":\"April\",\"value\":\"139.779\",\"footnotes\":[{}]},{\"year\":\"2015\",\"period\":\"M03\",\"periodName\":\"March\",\"value\":\"139.604\",\"footnotes\":[{}]},{\"year\":\"2015\",\"period\":\"M02\",\"periodName\":\"February\",\"value\":\"139.405\",\"footnotes\":[{}]},{\"year\":\"2015\",\"period\":\"M01\",\"periodName\":\"January\",\"value\":\"139.200\",\"footnotes\":[{}]}]}]\n" +
                    "}}\n";
            System.out.println(jsonString);
            JSONObject json = new JSONObject(jsonString);

            JSONArray series = json.getJSONObject("Results").getJSONArray("series");

            for(int i=0;i< series.length();i++){
                JSONArray data = series.getJSONObject(0).getJSONArray("data");
                String output = data.getJSONObject(i).getString("value");
                userdata[i] = output;
            }

            System.out.println("Housing: "+ userdata[0]);
            System.out.println("Expenses: "+ userdata[1]);
            //}

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return userdata;
    }
}
