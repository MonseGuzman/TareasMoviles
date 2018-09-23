package com.monse.andrea.practica7;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class listviewAdapter extends BaseAdapter
{
    private Context context;
    private ArrayList<tablita> list;// agregar Lista de datitos
    private int layout;

    public listviewAdapter(Context context, ArrayList<tablita> list) {
        this.context = context;
        this.list = list;
        this.layout = R.layout.listview_item;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;

        if(convertView == null)
        {
            convertView = LayoutInflater.from(context).inflate(layout, null);
            vh = new ViewHolder();
            vh.IdTextView = (TextView)convertView.findViewById(R.id.IdTextView);
            vh.TituloTextView = (TextView)convertView.findViewById(R.id.TituloTextView);
            vh.imagenImagenView = (ImageView) convertView.findViewById(R.id.imagenImagenView);

            convertView.setTag(vh);
        }
        else
            vh = (ViewHolder) convertView.getTag();


        vh.IdTextView.setText(list.get(position).getId());
        vh.TituloTextView.setText(list.get(position).getNombre());

        Bitmap bp;
        if(!list.get(position).getRuta().equals(""))
        {
            bp = BitmapFactory.decodeFile(list.get(position).getRuta());
            vh.imagenImagenView.setImageBitmap(bp);
        }

        return convertView;
    }

    public class ViewHolder
    {
        TextView IdTextView, TituloTextView;
        ImageView imagenImagenView;
    }
}
