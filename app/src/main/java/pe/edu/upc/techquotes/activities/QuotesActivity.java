package pe.edu.upc.techquotes.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.techquotes.R;
import pe.edu.upc.techquotes.TechQuotesApp;
import pe.edu.upc.techquotes.adapters.QuotesAdapter;
import pe.edu.upc.techquotes.models.TechQuote;
import pe.edu.upc.techquotes.network.TechQuoteApi;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;

public class QuotesActivity extends AppCompatActivity {
    RecyclerView    quotesRecyclerView;
    QuotesAdapter   quotesAdapter;
    RecyclerView.LayoutManager  quotesLayoutManager;
    List<TechQuote> quotes;
    TechQuote quote;
    private static String TAG = "TechQuoteApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        quotesRecyclerView = (RecyclerView) findViewById(R.id.quotesRecyclerView);
        quotesAdapter = new QuotesAdapter();
        quotes = new ArrayList<>();
        quotesAdapter.setQuotes(quotes);

        quotesLayoutManager = new GridLayoutManager(this,1);
        quotesRecyclerView.setAdapter(quotesAdapter);
        quotesRecyclerView.setLayoutManager(quotesLayoutManager);


        //quote = TechQuotesApp.getInstance().getSelectedQuote();
        updateQuotes();
    }

    private void updateQuotes() {
        AndroidNetworking.get(TechQuoteApi.QUOTES_URL)
                //.addQueryParameter("source", source.getId())
                //.addQueryParameter("apiKey",getString(R.string.news_api_key))
                .setTag(TAG)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {

                        quotes = TechQuote.build(response);
                        quotesAdapter.setQuotes(quotes);
                        quotesAdapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d(TAG, anError.getLocalizedMessage());
                    }
                });
    }

}
