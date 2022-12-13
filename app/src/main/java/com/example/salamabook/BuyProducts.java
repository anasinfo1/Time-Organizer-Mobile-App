package com.example.salamabook;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class BuyProducts extends AppCompatActivity {


    private Button lundi;
    private Button mardi;
    private Button mercredi;
    private Button jeudi;
    private Button vendredi;
    private Button Samedi;
    private Button generer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE );
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_buy_products);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);


        //list view






        //fragments
        lundi = findViewById(R.id.lundi);
        lundi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView16, Lundi.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("lundi") // name can be null
                        .commit();
            }
        });

        mardi = findViewById(R.id.mardi);
        mardi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView16, Mardi.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("mardi") // name can be null
                        .commit();
            }
        });


        mercredi=findViewById(R.id.mercredi);
        mercredi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView16, Mercredi.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("mercredi") // name can be null
                        .commit();
            }
        });


        jeudi=findViewById(R.id.jeudi);
        jeudi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView16, com.example.salamabook.jeudi.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("jeudi") // name can be null
                        .commit();
            }
        });


        vendredi=findViewById(R.id.vendredi);
        vendredi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView16, Vendredi.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("vendredi") // name can be null
                        .commit();
            }
        });


        Samedi = findViewById(R.id.samedi);

        Samedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView16, com.example.salamabook.Samedi.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("samedi") // name can be null
                        .commit();
            }
        });

        generer = findViewById(R.id.generer);
        generer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                     startActivity(new Intent(BuyProducts.this, Emploi.class));
            }
        });



    }
}