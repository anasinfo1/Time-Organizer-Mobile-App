package com.example.salamabook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Emploi extends AppCompatActivity {



    String A="\n Salle : A";
    String B = "\n Salle : B";
    String C = "\n Salle : C";
    String D = "\n Salle : D";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE );
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_emploi);








                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Lundi");

                //Lundi Matiere
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.


                        String lundi1 = dataSnapshot.child("8:00-10:00").child("Matiere").getValue(String.class);
                        String lundi2 = dataSnapshot.child("10:15-12:00").child("Matiere").getValue(String.class);
                        String lundi3 = dataSnapshot.child("14:00-16:00").child("Matiere").getValue(String.class);
                        String lundi4 = dataSnapshot.child("16:15-18:00").child("Matiere").getValue(String.class);




                        TextView lundiOne, lundiTwo, lundiTree, lundiFoor;

                         lundiOne=findViewById(R.id.lundi1);
                         lundiTwo=findViewById(R.id.lundi2);
                        lundiTree=findViewById(R.id.lundi3);
                        lundiFoor=findViewById(R.id.lundi4);





                        //affectation

                      if (lundi1!= null){
                          lundiOne.setText(lundi1+A);
                      }
                      if (lundi2 !=null){
                          lundiTwo.setText(lundi2+B);
                      }
                      if (lundi3 != null){
                          lundiTree.setText(lundi3+C);
                      }

                      if (lundi4!=null){
                          lundiFoor.setText(lundi4 + D);
                      }












                    }
                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Toast.makeText(Emploi.this, "Failed to read value.", Toast.LENGTH_SHORT).show();
                    }
                });










        //Mardi Matiere
        DatabaseReference myRef2 = database.getReference("Mardi");
        myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.


                String Mardi1 = dataSnapshot.child("8:00-10:00").child("Matiere").getValue(String.class);
                String Mardi2 = dataSnapshot.child("10:15-12:00").child("Matiere").getValue(String.class);
                String Mardi3 = dataSnapshot.child("14:00-16:00").child("Matiere").getValue(String.class);
                String Mardi4 = dataSnapshot.child("16:15-18:00").child("Matiere").getValue(String.class);



                TextView MardiOne, MardiTwo, MardiTree, MardiFoor;

               MardiOne=findViewById(R.id.mardi1);
              MardiTwo=findViewById(R.id.mardi2);
               MardiTree=findViewById(R.id.mardi3);
               MardiFoor =findViewById(R.id.mardi4);


                //affectation

                   if (Mardi1 != null){
                       MardiOne.setText(Mardi1 +A);
                   }
                  if (Mardi2 != null){
                      MardiTwo.setText(Mardi2 +B);
                  }
                   if (Mardi3!=null){
                       MardiTree.setText(Mardi3 +C);
                   }
                   if (Mardi4!=null){
                       MardiFoor.setText(Mardi4+D);
                   }


            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(Emploi.this, "Failed to read value.", Toast.LENGTH_SHORT).show();
            }
        });







//Mercredi Matiere
        DatabaseReference myRef3 = database.getReference("Mercredi");
        myRef3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.


                String Mercredi1 = dataSnapshot.child("8:00-10:00").child("Matiere").getValue(String.class);
                String Mercredi2 = dataSnapshot.child("10:15-12:00").child("Matiere").getValue(String.class);
                String Mercredi3 = dataSnapshot.child("14:00-16:00").child("Matiere").getValue(String.class);
                String Mercredi4 = dataSnapshot.child("16:15-18:00").child("Matiere").getValue(String.class);


                TextView MercrediOne, MercrediTwo, MercrediTree, MercrediFoor;

                MercrediOne =findViewById(R.id.mercredi1);
               MercrediTwo =findViewById(R.id.mercredi2);
                MercrediTree =findViewById(R.id.mercredi3);
               MercrediFoor =findViewById(R.id.mercredi4);


                //affectation

                  if (Mercredi1 != null){

                      MercrediOne.setText(Mercredi1 +A);
                  }
                  if (Mercredi2!=null){

                      MercrediTwo.setText(Mercredi2+B);
                  }
                 if (Mercredi3!=null){
                     MercrediTree.setText(Mercredi3+C);
                 }
                 if (Mercredi4 != null){

                     MercrediFoor.setText(Mercredi4+D);

                 }

            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(Emploi.this, "Failed to read value.", Toast.LENGTH_SHORT).show();
            }
        });




//Jeudi Matiere
        DatabaseReference myRef4 = database.getReference("Jeudi");
        myRef4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.


                String Jeudi1 = dataSnapshot.child("8:00-10:00").child("Matiere").getValue(String.class);
                String Jeudi2 = dataSnapshot.child("10:15-12:00").child("Matiere").getValue(String.class);
                String Jeudi3 = dataSnapshot.child("14:00-16:00").child("Matiere").getValue(String.class);
                String Jeudi4 = dataSnapshot.child("16:15-18:00").child("Matiere").getValue(String.class);



                TextView JeudiOne, JeudiTwo, JeudiTree, JeudiFoor;

                JeudiOne =findViewById(R.id.jeudi1);
              JeudiTwo =findViewById(R.id.jeudi2);
                 JeudiTree =findViewById(R.id.jeudi3);
                JeudiFoor =findViewById(R.id.jeudi4);


                //affectation

                if (Jeudi1!=null){
                JeudiOne.setText(Jeudi1 + A);
                }
                if (Jeudi2!=null){

                    JeudiTwo.setText(Jeudi2 + B);

                }
                if (Jeudi3!=null){

                    JeudiTree.setText(Jeudi3 + C);
                }
                if (Jeudi4!=null){

                    JeudiFoor.setText(Jeudi4 +D);

                }




            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(Emploi.this, "Failed to read value.", Toast.LENGTH_SHORT).show();
            }
        });




//Vendredi Matiere

        DatabaseReference myRef5 = database.getReference("Vendredi");
        myRef5.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.


                String Vendredi1 = dataSnapshot.child("8:00-10:00").child("Matiere").getValue(String.class);
                String Vendredi2 = dataSnapshot.child("10:15-12:00").child("Matiere").getValue(String.class);
                String Vendredi3 = dataSnapshot.child("14:00-16:00").child("Matiere").getValue(String.class);
                String Vendredi4 = dataSnapshot.child("16:15-18:00").child("Matiere").getValue(String.class);




                TextView VendrediOne, VendrediTwo, VendrediTree, VendrediFoor;

               VendrediOne =findViewById(R.id.vendredi1);
               VendrediTwo =findViewById(R.id.vendredi2);
               VendrediTree =findViewById(R.id.vendredi3);
               VendrediFoor =findViewById(R.id.vendredi4);


                //affectation

                if (Vendredi1!=null){
                    VendrediOne.setText(Vendredi1 + A);

                }
                if (Vendredi2!=null){

                    VendrediTwo.setText(Vendredi2 + B);
                }
                if (Vendredi3!=null){

                    VendrediTree.setText(Vendredi3 + C);
                }
                if (Vendredi4!=null){

                    VendrediFoor.setText(Vendredi4 + D);
                }


            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(Emploi.this, "Failed to read value.", Toast.LENGTH_SHORT).show();
            }
        });





//Samedi Matiere
        DatabaseReference myRef6 = database.getReference("Samedi");
        myRef5.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.


                String Samedi1 = dataSnapshot.child("8:00-10:00").child("Matiere").getValue(String.class);
                String Samedi2 = dataSnapshot.child("10:15-12:00").child("Matiere").getValue(String.class);
                String Samedi3 = dataSnapshot.child("14:00-16:00").child("Matiere").getValue(String.class);
                String Samedi4 = dataSnapshot.child("16:15-18:00").child("Matiere").getValue(String.class);


                TextView SamediOne, SamediTwo, SamediTree, SamediFoor;

                SamediOne =findViewById(R.id.samedi1);
                SamediTwo =findViewById(R.id.samedi2);
                SamediTree =findViewById(R.id.samedi3);
                SamediFoor =findViewById(R.id.samedi4);


                //affectation

                if (Samedi1!=null){

                    SamediOne.setText(Samedi1 + A);
                }
                if (Samedi2!=null){

                    SamediTwo.setText(Samedi2 + B);
                }
                  if (Samedi3!=null){
                      SamediTree.setText(Samedi3 + C);
                  }
                 if (Samedi4!=null){
                     SamediFoor.setText(Samedi4 + D);

                 }

            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(Emploi.this, "Failed to read value.", Toast.LENGTH_SHORT).show();
            }
        });











    }







            }


