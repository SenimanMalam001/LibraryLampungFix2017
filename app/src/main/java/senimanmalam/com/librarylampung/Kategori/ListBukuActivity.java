package senimanmalam.com.librarylampung.Kategori;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import senimanmalam.com.librarylampung.Adapter.BukuAdapter;
import senimanmalam.com.librarylampung.Interface.ItemClickListener;
import senimanmalam.com.librarylampung.Model.Buku;
import senimanmalam.com.librarylampung.R;
import senimanmalam.com.librarylampung.ViewHolder.MenuViewHolder;

import static senimanmalam.com.librarylampung.R.*;

public class ListBukuActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    //List<Buku> list;
    FirebaseDatabase database;
    DatabaseReference myRef;
    //ImageView view;

    //Query category;
    FirebaseRecyclerAdapter<Buku,MenuViewHolder>adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_list_buku);


        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("category");

        recyclerView = (RecyclerView) findViewById(id.recycler_buku);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        loadMenu();



        /*//Get Intent here
        if (getIntent() != null)
            judulId = getIntent().getStringExtra("CategoryId");
        if (!judulId.isEmpty() && judulId != null) {
            loadListFood(judulId);
        }
    }

        private void loadListFood(String judulId){
//            adapter = new FirebaseRecyclerAdapter<Buku, MenuViewHolder>(Buku.class,
//                            R.layout.detail_buku_layout,
//                    MenuViewHolder.class,
//
//                    ); {
//                @Override
//                protected void populateViewHolder(MenuViewHolder viewHolder, Buku model, int position) {
//
//                }
            }*/


//
//        database = FirebaseDatabase.getInstance();
//        try {
//            myRef = database.getReference().child("category");
//        }catch(Exception e){
//            Log.d("Error", e+"");
//        }
//        txt = (TextView) findViewById(R.id.textView2);
//        recyclerView.setHasFixedSize(true);
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                list = new ArrayList<Buku>();
//                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
//                    Buku buku = dataSnapshot1.getValue(Buku.class);
//                    Buku bukufire = new Buku();
//                    String judul = buku.getJudul();
//                    bukufire.setJudul(judul);
//                    list.add(bukufire);
//                }
//                String tes = dataSnapshot.getValue(String.class);
//                txt.setText(tes);
//
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                Log.w("Hello", "Firebase LOHH Eror Boy.");
//            }
//        });
//
//
//                BukuAdapter adapter = new BukuAdapter(list, ListBukuActivity.this);
//                RecyclerView.LayoutManager layoutManager = new GridLayoutManager(ListBukuActivity.this,2);
//                recyclerView.setLayoutManager(layoutManager);
//                recyclerView.setItemAnimator(new DefaultItemAnimator());
//                recyclerView.setAdapter(adapter);
//
      }

    private void loadMenu()
    {
        FirebaseRecyclerAdapter<Buku, MenuViewHolder> adapter = new FirebaseRecyclerAdapter<Buku, MenuViewHolder>(Buku.class, R.layout.detail_buku_layout, MenuViewHolder.class, myRef) {

            @Override
            protected void populateViewHolder(MenuViewHolder viewHolder, Buku model, int position) {
                try {
                Picasso.with(getBaseContext()).load(model.getGambar()).into(viewHolder.imggambar);
                } catch (Exception e){
                    Toast.makeText(ListBukuActivity.this,""+e, Toast.LENGTH_SHORT).show();
                }
                viewHolder.txtjudul.setText(model.getJudul());
                final Buku clickItem = model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Toast.makeText(ListBukuActivity.this,""+clickItem.getGambar(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };
        recyclerView.setAdapter(adapter);
    }


    }
