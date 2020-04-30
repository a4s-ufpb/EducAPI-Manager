package br.ufpb.dcx.apps4society.educapimanager.model.bean;



import java.io.Serializable;
import java.util.ArrayList;

public class SearchResponseModel implements Serializable {

    private ArrayList<String> urls;

    public SearchResponseModel(ArrayList<String> searchResult) {
        this.urls = searchResult;
    }
    public SearchResponseModel(){
        this.urls= new ArrayList<>();
    }

    @Override
    public String toString() {
        return "items = " + urls;
    }

   }

