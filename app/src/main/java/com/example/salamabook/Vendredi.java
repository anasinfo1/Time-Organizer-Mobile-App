package com.example.salamabook;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class Vendredi extends Fragment {
    private Button btnadd;
    LinearLayout layout;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Vendredi");


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_vendredi, container, false);

        btnadd = view.findViewById(R.id.add);
        layout = view.findViewById(R.id.container);


        //code




        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
                View mView = getLayoutInflater().inflate(R.layout.activity_dialog, null);
                mBuilder.setTitle("Nouvelle Element");
                Spinner mSpinner = (Spinner) mView.findViewById(R.id.spinnerD);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.heur));
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mSpinner.setAdapter(adapter);
                mBuilder.setPositiveButton("Ajouter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        final View Cardview = getLayoutInflater().inflate(R.layout.card,null);

                        TextView nameView = Cardview.findViewById(R.id.heur);
                        TextView nameView2 = Cardview.findViewById(R.id.matiere);
                        Button delete = Cardview.findViewById(R.id.delete);


                        TextView matiere;
                        matiere = mView.findViewById(R.id.matiere);

                        nameView2.setText(matiere.getText().toString());

                        String matiere_txt = matiere.getText().toString();
                        nameView.setText(mSpinner.getSelectedItem().toString());




                        HashMap<String , String> map = new HashMap<>();

                        map.put("Matiere", matiere_txt);


                        switch (mSpinner.getSelectedItem().toString()){

                            case "8:00-10:00":
                                map.put("Salle", "A");
                                break;
                            case "10:15-12:00":
                                map.put("Salle", "B");
                                break;
                            case "14:00-16:00":
                                map.put("Salle", "C");
                                break;
                            case "16:15-18:00":
                                map.put("Salle", "D");
                                break;
                        }


                        myRef.child(mSpinner.getSelectedItem().toString()).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(getActivity(), "Les donner est enregistrer", Toast.LENGTH_SHORT).show();

                            }

                        });




                        delete.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                layout.removeView(Cardview);

                                DatabaseReference ref;
                                ref = myRef.child(mSpinner.getSelectedItem().toString());
                                Task<Void> mTask = ref.removeValue();

                            }
                        });
                        layout.addView(Cardview);

                        dialogInterface.dismiss();

                    }
                });


                mBuilder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();

                    }
                });


                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();




            }
        });



        return view;
    }}