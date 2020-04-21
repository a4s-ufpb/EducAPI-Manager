package br.ufpb.dcx.apps4society.educapimanager.utils;

import android.content.Context;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;



public class SearchEngineClient {
    private static final String API_BASE_URL = "https://www.googleapis.com/customsearch/v1?";
    private static final String API_KEY = "AIzaSyBKu8O9msyelwJPRG4hsiMEeW7G2NMjmZw";
    private static final String CX_KEY = "010983324265191686624:wanhkrbv8rc";
    private AsyncHttpClient client;

    public SearchEngineClient(){
        this.client = new AsyncHttpClient();
    }

    public String getAcessUrl(String relativeUrl){
        return  API_BASE_URL+relativeUrl;
    }

    public void search(final String query, int startPage, Context context,JsonHttpResponseHandler handler){
        try{
            String url = getAcessUrl("q="+
                    URLEncoder.encode(query,"utf-8")+
                    "&start="+
                    startPage+
                    "&cx="+
                    CX_KEY+
                    "&key="+
                    API_KEY);
            client.get(url,handler);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            Toast.makeText(context, "search_not_found", Toast.LENGTH_SHORT).show();
        }
    }


}
