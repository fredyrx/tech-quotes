package pe.edu.upc.techquotes.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import pe.edu.upc.techquotes.R;
import pe.edu.upc.techquotes.TechQuotesApp;
import pe.edu.upc.techquotes.models.TechQuote;

/**
 * Created by Fredy Ramos on 24/04/2017.
 */

public class MainActivity extends AppCompatActivity {

    private TechQuote lastQuote;

    private TextView messageTextView;
    private Button newQuote;
    private TextView quoteTextView;
    private TextView authorTextView;
    private CardView quoteCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        newQuote = (Button) findViewById(R.id.newQuoteButton);

        newQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuotesActivity.class);
                startActivity(intent);
            }
        });

        quoteTextView = (TextView) findViewById(R.id.quoteMainTextView);
        authorTextView = (TextView) findViewById(R.id.authorMainTextView);
        messageTextView = (TextView) findViewById(R.id.alertTextView);
        quoteCardView = (CardView) findViewById(R.id.techQuoteCardView);
        update();
    }

    public void update(){
        // Traemos al ultimo Quote almacenado en memoria
        lastQuote = TechQuotesApp.getInstance().getLastQuote();
        if (lastQuote == null){
            quoteCardView.setVisibility(View.GONE);
            messageTextView.setVisibility(View.VISIBLE);
            messageTextView.setText("No tienes Frases alamacenadas.");
        } else{
            // Mostramos datos de Quote en elememtos del cardView

            quoteCardView.setVisibility(View.VISIBLE);
            messageTextView.setVisibility(View.GONE);
            quoteTextView.setText(lastQuote.getDecoratedQuote());
            authorTextView.setText(lastQuote.getAuthor());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        update();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
