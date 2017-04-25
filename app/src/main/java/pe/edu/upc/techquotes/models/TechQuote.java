package pe.edu.upc.techquotes.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fredy Ramos on 24/04/2017.
 */

public class TechQuote {

    private int id;
    private String author;
    private String quote;
    private String permalink;

    public int getId() {
        return id;
    }

    public TechQuote setId(int id) {
        this.id = id;
        return this;
    }

    public String getResumeQuote(){
        return quote.substring(0,40).concat("...");
    }

    public String getAuthor() {
        return author;
    }

    public TechQuote setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getQuote() {
        return "\""+quote+"\"";
    }

    public TechQuote setQuote(String quote) {
        this.quote = quote;
        return this;
    }

    public String getPermalink() {
        return permalink;
    }

    public TechQuote setPermalink(String permalink) {
        this.permalink = permalink;
        return this;
    }

    public static TechQuote build(JSONObject jsonQuote) {
        if(jsonQuote == null) return null;
        //if(source == null) return null;
        TechQuote quote = new TechQuote();
        try {
            quote.setAuthor(jsonQuote.getString("author"))
                    .setId(jsonQuote.getInt("id"))
                    .setQuote(jsonQuote.getString("quote"))
                    .setPermalink(jsonQuote.getString("permalink"));
                    //.setSource(source);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return quote;
    }

    public static List<TechQuote> build(JSONArray jsonQuotes) {
        if(jsonQuotes == null) return null;
        //if(source == null) return null;
        int length = jsonQuotes.length();
        List<TechQuote> quotes = new ArrayList<>();
        for(int i = 0; i < length; i++) {
            try {
                quotes.add(TechQuote.build(jsonQuotes.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return quotes;
    }
}
