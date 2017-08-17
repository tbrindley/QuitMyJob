package com.quitmyjob.API;

import com.fp.dao.GetClient;
import com.fp.models.Clients;
import com.fp.models.Finances;
import com.quitmyjob.loginsystem.GetCookie;
import com.quitmyjob.secretstuff.APIkeys;
import com.quitmyjob.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by Travis Brindley on 8/16/2017.
 */
public class Indeed {
    public static String getIndeed(HttpServletRequest request){
        Clients userClient = GetClient.getclient(request);
        String job = noSpace(userClient.getJob());
       // String jsonString = callURL("http://api.indeed.com/ads/apisearch?publisher="+ APIkeys.indeed+"&q=java&l=detroit&format=json&sort=&radius=&st=&jt=&start=&limit=50&fromage=&filter=&latlong=1&co=us&chnl=&userip=1.2.3.4&useragent=Mozilla/%2F4.0%28Firefox%29&v=2");
        String jsonString = callURL("http://api.indeed.com/ads/apisearch?publisher="+ APIkeys.indeed+"&q="+job+"&l=detroit&format=json&sort=&radius=&st=&jt=&start=&limit=50&fromage=&filter=&latlong=1&co=us&chnl=&userip=1.2.3.4&useragent=Mozilla/%2F4.0%28Firefox%29&v=2");

        System.out.println("\n\njsonString: " + jsonString);

// Replace this try catch block for all below subsequent examples
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray jsonArray = jsonObject.getJSONArray("results");
            int count = jsonArray.length(); // get totalCount of all jsonObjects
            for (int i = 0; i < count; i++) {   // iterate through jsonArray
                JSONObject jsonPosts = jsonArray.getJSONObject(i);  // get jsonObject @ i position
                System.out.println("jsonObject " + i + ": " + jsonPosts.get("jobtitle"));
                System.out.println(("jsonObject " + i + ": " + jsonPosts.get("company")));
                System.out.println();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //String to hold data for our loop once we return the json array
        String text = "";
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray jsonArray = jsonObject.getJSONArray("results");
        jsonArray.toString();

        //create a json array to hold the data in the "text" array node
        //also
        JSONArray ar = jsonObject.getJSONArray("results");



        //loop through json array
        for (int i = 0; i < ar.length(); i++) {
            text += ("<h3><a href=\"" + ar.getJSONObject(i).getString("url") + "\" target=\"_blank\">" +
                    ar.getJSONObject(i).getString("jobtitle") + "</a></h3>" +
                    "<h5> " + ar.getJSONObject(i).getString("company") + "</h5>"+
                    "<p>Description: " + ar.getJSONObject(i).getString("snippet") + "<hr>");

        }
        return text;
    }
    public static String callURL(String myURL) {
        System.out.println("Requested URL:" + myURL);
        StringBuilder sb = new StringBuilder();
        URLConnection urlConn = null;
        InputStreamReader in = null;
        try {
            URL url = new URL(myURL);
            urlConn = url.openConnection();
            if (urlConn != null)
                urlConn.setReadTimeout(60 * 1000);
            if (urlConn != null && urlConn.getInputStream() != null) {
                in = new InputStreamReader(urlConn.getInputStream(),
                        Charset.defaultCharset());
                BufferedReader bufferedReader = new BufferedReader(in);
                if (bufferedReader != null) {
                    int cp;
                    while ((cp = bufferedReader.read()) != -1) {
                        sb.append((char) cp);
                    }
                    bufferedReader.close();
                }
            }
            in.close();
        } catch (Exception e) {
            throw new RuntimeException("Exception while calling URL:" + myURL, e);
        }

        return sb.toString();
    }
    private static String noSpace(String job){
        StringBuilder userJob = new StringBuilder(job);
        System.out.println(userJob);
        for(int i=0; i < userJob.length(); i++){
            if(userJob.charAt(i) == ' '){
                userJob.setCharAt(i,'+');
            }
        }
        String newJob = userJob.toString();
        System.out.println(newJob);
        return newJob;
    }

}
