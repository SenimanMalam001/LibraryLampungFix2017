package senimanmalam.com.librarylampung.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import senimanmalam.com.librarylampung.Interface.ItemClickListener;
import senimanmalam.com.librarylampung.R;

/**
 * Created by asus on 29/12/2017.
 */

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txtjudul;
    public ImageView imggambar;

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public MenuViewHolder(View itemView) {
        super(itemView);
        txtjudul = (TextView)itemView.findViewById(R.id.menu_judul);
        imggambar = (ImageView)itemView.findViewById(R.id.menu_gambar);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view, getAdapterPosition(),false);
    }
}
