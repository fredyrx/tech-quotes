package pe.edu.upc.techquotes.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import pe.edu.upc.techquotes.R;
import pe.edu.upc.techquotes.TechQuotesApp;
import pe.edu.upc.techquotes.models.TechQuote;

public class AboutActivity extends AppCompatActivity {

    private TechQuote quote;

    private TextView quoteTextView;
    private TextView authorTextView;
    private CardView quoteCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Traemos quote seleccionado previamente
        quote = TechQuotesApp.getInstance().getSelectedQuote();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TechQuotesApp.getInstance().addQuote(quote);
                Snackbar.make(view, "Quote Saved", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        quoteCardView = (CardView) findViewById(R.id.techQuoteCardView);

        quoteTextView = (TextView) findViewById(R.id.quoteMainTextView);
        authorTextView = (TextView) findViewById(R.id.authorMainTextView);
        // Mostramos datos de Quote en elememtos del cardView
        quoteTextView.setText(quote.getDecoratedQuote());
        authorTextView.setText(quote.getAuthor());

    }

}
