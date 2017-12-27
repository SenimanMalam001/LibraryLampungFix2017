package senimanmalam.com.librarylampung.Kategori;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import senimanmalam.com.librarylampung.R;
import senimanmalam.com.librarylampung.Utils.BottomNavigationViewHelper;

/**
 * Created by asus on 22/12/2017.
 */

public class KategoriActivity  extends AppCompatActivity{

    private static final String TAG = "KategoriActivity";
    private static final int ACTIVITY_NUM =1;
    private Context mContext = KategoriActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_kategori);
        Log.d(TAG, "onCreate: starting.");

        setupBottomNavigationView();
        //setupToolbar();
    }

    public void btn_agama(View view){
    Intent intent = new Intent(KategoriActivity.this, ListBukuActivity.class);
    startActivity(intent);
    }

    private void setupToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.profileToolBar);
        setSupportActionBar(toolbar);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Log.d(TAG, "onMenuItemClick: clicked menu item : " + item);
                switch (item.getItemId()){
                    case R.id.kategoriMenu:
                        Log.d(TAG, "onMenuItemClick: Navigation to Profile Preferences.");
                }

                return false;
            }
        });
    }

    /*
   *ButtomNavigationView setup
  */
    private void setupBottomNavigationView() {
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNabigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.btn_nav_view_bar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);

        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.kategori_menu, menu);
        return true;
    }

    public void btnagama(View view) {
        Intent tampil = new Intent(this, ListBukuActivity.class);
        startActivity(tampil);
    }


}
