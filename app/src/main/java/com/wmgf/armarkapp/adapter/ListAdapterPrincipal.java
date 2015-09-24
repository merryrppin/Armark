package com.wmgf.armarkapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wmgf.armarkapp.R;
import com.wmgf.armarkapp.dominio.ItemLista;

import java.util.List;

/**
 * Created by WMGF on 24/09/2015.
 */
public class ListAdapterPrincipal extends ArrayAdapter {

    private Context context;

    public ListAdapterPrincipal(Context context, List items) {
        super(context, android.R.layout.simple_list_item_1, items);
        this.context = context;
    }

    /**
     * Holder for the list items.
     */
    private class ViewHolder {
        TextView row_lista_prin_txtSup;
        TextView row_lista_prin_txtMedio;
        TextView row_lista_prin_txtInferior;
        ImageView row_lista_prin_img;
    }

    /**
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        ItemLista item = (ItemLista) getItem(position);
        View viewToUse = null;

        // This block exists to inflate the settings list item conditionally based on whether
        // we want to support a grid or list view.
        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            viewToUse = mInflater.inflate(R.layout.row_lista_principal, null);

            holder = new ViewHolder();
            holder.row_lista_prin_txtSup = (TextView) viewToUse.findViewById(R.id.row_lista_prin_txtSup);
            holder.row_lista_prin_txtMedio = (TextView) viewToUse.findViewById(R.id.row_lista_prin_txtMedio);
            holder.row_lista_prin_txtInferior = (TextView) viewToUse.findViewById(R.id.row_lista_prin_txtInferior);
            holder.row_lista_prin_img = (ImageView) viewToUse.findViewById(R.id.row_lista_prin_img);
            viewToUse.setTag(holder);
        } else {
            viewToUse = convertView;
            holder = (ViewHolder) viewToUse.getTag();
        }

        holder.row_lista_prin_txtSup.setText(item.getTextoSuperior());
        holder.row_lista_prin_txtMedio.setText(item.getTextoMedio());
        holder.row_lista_prin_txtInferior.setText(item.getTextoInferior());
        //holder.row_lista_prin_img.setText(item.getItemTitle());
        return viewToUse;
    }
}