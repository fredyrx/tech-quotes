package pe.edu.upc.techquotes.network;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.techquotes.models.TechQuote;

/**
 * Created by Fredy Ramos on 24/04/2017.
 */

public class TechQuoteApi {;
    public static String QUOTES_URL = "http://quotes.stormconsultancy.co.uk/quotes.json";

    private TechQuote selectedQuote;
    private List<TechQuote> quotes;

    public TechQuoteApi(){
        quotes = new ArrayList<>();
        selectedQuote = new TechQuote();
    }

    public static String getQuotesUrl() {
        return QUOTES_URL;
    }

    public static void setQuotesUrl(String quotesUrl) {
        QUOTES_URL = quotesUrl;
    }

    public TechQuote getSelectedQuote() {
        return selectedQuote;
    }

    public void setSelectedQuote(TechQuote selectedQuote) {
        this.selectedQuote = selectedQuote;
    }

    public List<TechQuote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<TechQuote> quotes) {
        this.quotes = quotes;
    }

    public void addQuote(TechQuote quote){
        quotes.add(quote);
    }

    public TechQuote getLastQuote(){
        int lastIndex = quotes.size();
        if (lastIndex > 0){
            return quotes.get(lastIndex-1);
        }else{
            return null;
        }
    }


}
