package senimanmalam.com.librarylampung.Kategori;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import senimanmalam.com.librarylampung.Adapter.BukuAdapter;
import senimanmalam.com.librarylampung.Model.Buku;
import senimanmalam.com.librarylampung.R;

public class ListBukuActivity extends AppCompatActivity {

    List<Buku> list;
    FirebaseDatabase database;
    DatabaseReference myRef;

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_buku);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_buku);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("category");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list = new ArrayList<Buku>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    Buku buku = dataSnapshot1.getValue(Buku.class);
                    Buku bukufire = new Buku();
                    String judul = buku.getJudul();
                    bukufire.setJudul(judul);
                    list.add(bukufire);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        BukuAdapter adapter = new BukuAdapter(list, ListBukuActivity.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListBukuActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
}
