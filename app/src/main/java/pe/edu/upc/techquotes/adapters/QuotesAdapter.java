package pe.edu.upc.techquotes.adapters;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.techquotes.R;
import pe.edu.upc.techquotes.TechQuotesApp;
import pe.edu.upc.techquotes.activities.AboutActivity;
import pe.edu.upc.techquotes.models.TechQuote;

/**
 * Created by proyecto on 24/04/2017.
 */

public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.ViewHolder>  {

    private List<TechQuote> quotes;

    public QuotesAdapter(){
        quotes = new ArrayList<>();
    }

    @Override
    public QuotesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.card_quote, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(QuotesAdapter.ViewHolder holder, final int position) {
        holder.authorTextView.setText(quotes.get(position).getAuthor());
        holder.quoteTextView.setText(quotes.get(position).getResumeQuote());
        holder.quoteCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TechQuote quoteClicked = quotes.get(position);
                TechQuotesApp.getInstance().setSelectedQuote(quoteClicked);
                Intent intent = new Intent(v.getContext(), AboutActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }

    public List<TechQuote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<TechQuote> quotes) {
        this.quotes = quotes;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView quoteCardView;
        TextView quoteTextView;
        TextView authorTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            quoteCardView = (CardView) itemView.findViewById(R.id.quoteCardView);
            quoteTextView = (TextView) itemView.findViewById(R.id.quoteTextView);
            authorTextView = (TextView) itemView.findViewById(R.id.authorTextView);
        }
    }
}
