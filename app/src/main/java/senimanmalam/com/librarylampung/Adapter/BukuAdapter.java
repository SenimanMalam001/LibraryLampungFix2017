package senimanmalam.com.librarylampung.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import senimanmalam.com.librarylampung.Model.Buku;
import senimanmalam.com.librarylampung.R;

/**
 * Created by asus on 26/12/2017.
 */

public class BukuAdapter extends RecyclerView.Adapter<BukuAdapter.BukuHolder> {

    List<Buku> list = new ArrayList<>();
    Context context;

    public BukuAdapter(List<Buku> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public BukuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.detail_buku_layout, parent, false);
        BukuHolder bukuHolder = new BukuHolder(view);

        return bukuHolder;
    }

    @Override
    public void onBindViewHolder(BukuHolder bukuHolder, int position) {
        Buku bukulist = list.get(position);
        bukuHolder.judul.setText(bukulist.getJudul());
        //bukuHolder.gambar.set(bukulist.getGambar());
    }

    @Override
    public int getItemCount() {
        int arr = 0;
        try {
            if(list.size()==0){
                arr = 0;
            }
            else{
                arr = list.size();
            }
        }catch (Exception e){

        }
        return  arr;
        /*return list.size();*/
    }

    class BukuHolder extends RecyclerView.ViewHolder {
        TextView judul;
        ImageView gambar;

        public BukuHolder(View itemView) {
            super(itemView);
            judul = (TextView) itemView.findViewById(R.id.judul);
            gambar = (ImageView) itemView.findViewById(R.id.gambar);
        }
    }
}
