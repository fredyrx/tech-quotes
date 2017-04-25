package pe.edu.upc.techquotes.network;

import java.util.List;

import pe.edu.upc.techquotes.models.TechQuote;

/**
 * Created by proyecto on 24/04/2017.
 */

public class TechQuoteApi {;
    public static String QUOTES_URL = "http://quotes.stormconsultancy.co.uk/quotes.json";

    private TechQuote selectedQuote;
    private List<TechQuote> quotes;

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

    private TechQuote currentTechQuote;

    public TechQuote getCurrentSource() {
        return currentTechQuote;
    }

    public void setCurrentSource(TechQuote currentTechQuote) {
        this.currentTechQuote = currentTechQuote;
    }
}
