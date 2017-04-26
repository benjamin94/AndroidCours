package com.androidtutoriels.meteos;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

import okhttp3.internal.Util;

/**
 * Created by benjaminlize on 25/04/2017.
 */

public class ClimatAdaptateur extends RecyclerView.Adapter<ClimatAdaptateur.ViewHolder> {

    Climat climat;

    public ClimatAdaptateur(Climat climat) {
        this.climat = climat;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Declare que item_climat est le template.
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_climat, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ClimatInfo climatInfo = climat.climatInfosArray.get(position);
        Temps temps = climat.getTempsArray().get(position);

        String temperatureString = (int) climatInfo.getTemperature() + "°C";

        holder.jour.setText(temps.getNomDeJour());
        holder.temperature.setText(temperatureString);

        Context context = holder.icon.getContext();

        String iconUri = Utilites.getIconUri(climatInfo.getClimat_id());
        int iconId = context.getResources().getIdentifier(iconUri,null,context.getPackageName());

        Drawable iconDrawable = context.getResources().getDrawable(iconId);
        holder.icon.setImageDrawable(iconDrawable);

    }

    @Override
    public int getItemCount() {
        return climat.climatInfosArray.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView jour;
        TextView temperature;
        ImageView icon;

        public ViewHolder(View itemView) {
            super(itemView);

            jour = (TextView)itemView.findViewById(R.id.jour_tv);
            temperature = (TextView)itemView.findViewById(R.id.temperature_tv);
            icon = (ImageView)itemView.findViewById(R.id.icon_iv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    int position = getLayoutPosition();
                    Toast.makeText(context, "hello", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context,DetailActivity.class);
                    intent.putExtra(DetailActivity.LOCATION_CLEF, climat.location);
                    intent.putExtra(DetailActivity.TEMPS_CLEF, climat.tempsArray.get(position));
                    intent.putExtra(DetailActivity.CLIMATINFO_CLEF, climat.climatInfosArray.get(position));
                    context.startActivity(intent);
                }
            });
        }
    }


}
