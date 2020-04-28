package br.ufpb.dcx.apps4society.educapimanager.utils;



import androidx.core.util.Pools;

import com.google.api.client.googleapis.batch.BatchRequest;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.customsearch.Customsearch;
import com.google.api.services.customsearch.model.Result;
import com.google.api.services.customsearch.model.Search;


import java.util.ArrayList;
import java.util.List;


public class SearchEngineClient {
    private static final String API_KEY = "AIzaSyBKu8O9msyelwJPRG4hsiMEeW7G2NMjmZw";
    private static final String CX_KEY = "010983324265191686624:wanhkrbv8rc";

    private List<Result> resultado = new ArrayList<>();






    public static void fill(List<Result> foraThread,List<Result> dentro){
        dentro = foraThread;
    }

    public synchronized List<Result> search(final String query) {


            Customsearch.Builder customse = null;
            try {
                customse = new Customsearch.Builder(new NetHttpTransport(), new JacksonFactory(), httpRequest -> {
                    try {

                        httpRequest.setConnectTimeout(20000);
                        httpRequest.setReadTimeout(20000);

                    } catch (Exception ex) {ex.printStackTrace();}});
                    } catch (Exception e) {e.printStackTrace();}


            try {
                customse.setApplicationName("EducAPI Manager");
                Customsearch.Cse.List list = customse.build().cse().list(query);
                list.setKey(API_KEY);
                list.setCx(CX_KEY);
                Search results = list.execute();
                resultado = results.getItems();
            } catch (Exception e) {e.printStackTrace();

            }

        return resultado;
    }

    }

