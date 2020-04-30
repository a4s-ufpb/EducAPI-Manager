package br.ufpb.dcx.apps4society.educapimanager.utils;



import androidx.core.util.Pools;

import com.google.api.client.googleapis.batch.BatchRequest;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.customsearch.Customsearch;
import com.google.api.services.customsearch.model.Result;
import com.google.api.services.customsearch.model.Search;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class SearchEngineClient {
    private static final String API_KEY = "AIzaSyBKu8O9msyelwJPRG4hsiMEeW7G2NMjmZw";
    private static final String CX_KEY = "010983324265191686624:wanhkrbv8rc";

    private List<Result> resultado = new ArrayList<>();


    public  List<Result> search(final String query) {


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
                SearchExecutor executor = new SearchExecutor(list);
                executor.start();
                executor.join();
                if(executor.isFailure() == true){

                }else{
                    resultado = executor.getSearchResult().getItems();
                }


            } catch (Exception e) {e.printStackTrace();}


        return resultado;

    }

    }
    class SearchExecutor extends Thread {

        private Customsearch.Cse.List list;
        private Search results;
        private boolean failure;

        SearchExecutor(Customsearch.Cse.List list){
            this.list = list;
            this.results = null;
            this.failure = false;
        }

        public Search getSearchResult(){
            return results;
        }

        public boolean isFailure(){
            return this.failure;
        }

        @Override
        public void run() {
            try {
                 this.results = list.execute();
            } catch (IOException e) {
                e.printStackTrace();
                this.failure = true;
            }
        }
    }

