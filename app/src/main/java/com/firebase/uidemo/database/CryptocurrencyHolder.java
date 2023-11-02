package com.firebase.uidemo.database;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.uidemo.R;
import com.firebase.uidemo.api.models.Cryptocurrency;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import androidx.recyclerview.widget.RecyclerView;

public class CryptocurrencyHolder extends RecyclerView.ViewHolder {

    private final TextView tvTimestamp;
    private final TextView tvName;
    private final TextView tvSymbol;
    private final TextView tvRank;
    private final TextView tvPriceUsd;
    private final TextView tvMarketCapUsd;
    private final TextView tvSupply;
    private final TextView tvVolumeUsd24Hr;
    private final TextView tvChangePercent24Hr;


    public CryptocurrencyHolder(View itemView) {
        super(itemView);
        this.tvTimestamp = itemView.findViewById(R.id.textViewTimestamp);
        this.tvName = itemView.findViewById(R.id.textViewName);
        this.tvSymbol = itemView.findViewById(R.id.textViewSymbol);
        this.tvRank = itemView.findViewById(R.id.textViewRank);
        this.tvPriceUsd = itemView.findViewById(R.id.textViewPriceUsd);
        this.tvMarketCapUsd = itemView.findViewById(R.id.textViewMarketCapUsd);
        this.tvSupply = itemView.findViewById(R.id.textViewSupply);
        this.tvVolumeUsd24Hr = itemView.findViewById(R.id.textViewVolumeUsd24Hr);
        this.tvChangePercent24Hr = itemView.findViewById(R.id.textViewChangePercent24Hr);
    }

    public void bind(Cryptocurrency cryptocurrency) {
        String formattedDate = formatTimestamp(cryptocurrency.getTimestamp());
        this.tvTimestamp.setText(formattedDate);
        this.tvName.setText(cryptocurrency.getData().getName());
        this.tvSymbol.setText(cryptocurrency.getData().getSymbol());
        this.tvRank.setText(cryptocurrency.getData().getRank());
        this.tvPriceUsd.setText(cryptocurrency.getData().getPriceUsd());
        this.tvMarketCapUsd.setText(cryptocurrency.getData().getMarketCapUsd());
        this.tvSupply.setText(cryptocurrency.getData().getSupply());
        this.tvVolumeUsd24Hr.setText(cryptocurrency.getData().getVolumeUsd24Hr());
        String formatPercentage = formatPercentage(cryptocurrency.getData().getChangePercent24Hr());
        this.tvChangePercent24Hr.setText(formatPercentage);
    }

    public static CryptocurrencyHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cryptocurrency, parent, false);
        return new CryptocurrencyHolder(view);
    }

    private String formatTimestamp(Long timestamp) {
        Date date = new Date(timestamp);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());
        return sdf.format(date);
    }

    private String formatPercentage(String percentage) {
        try {
            if (percentage == null) {
                return "-%";
            }
            double percentageValue = Double.parseDouble(percentage);
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            return decimalFormat.format(percentageValue) + "%";
        } catch (NumberFormatException e) {
            return percentage;
        }
    }
}
