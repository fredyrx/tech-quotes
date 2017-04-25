package pe.edu.upc.techquotes;

import android.app.Application;

import java.util.List;

import pe.edu.upc.techquotes.models.TechQuote;
import pe.edu.upc.techquotes.network.TechQuoteApi;

/**
 * Created by Fredy Ramos on 24/04/2017.
 */


public class TechQuotesApp extends Application {

    private TechQuoteApi techApi = new TechQuoteApi();

    private static TechQuotesApp instance;

    public TechQuotesApp(){
        super();
        instance = this;
    }

    public static TechQuotesApp getInstance(){
        return instance;
    }

    public void setSelectedQuote(TechQuote quote){
        techApi.setSelectedQuote(quote);
    }

    public TechQuote getSelectedQuote(){
        return techApi.getSelectedQuote();
    }

    public void addQuote(TechQuote quote){
        techApi.addQuote(quote);
    }

    public TechQuote getLastQuote(){
        return techApi.getLastQuote();
    }

    public List<TechQuote> getAllQuotes(){
        return techApi.getQuotes();
    }

}
