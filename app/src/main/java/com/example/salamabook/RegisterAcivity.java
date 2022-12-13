package com.example.salamabook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterAcivity extends AppCompatActivity {
    private TextView login;
    private Button register;
    private EditText Fullname;
    private EditText Email;
    private EditText Password;
    private FirebaseAuth auth;

    ProgressDialog pd;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Application Users");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE );
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register_acivity);

        login = (TextView) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterAcivity.this,BuyProducts.class));

            }
        });

        register = findViewById(R.id.register);
        Fullname = findViewById(R.id.fullname);
        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);
        auth = FirebaseAuth.getInstance();
        pd = new ProgressDialog(this);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text_email = Email.getText().toString();
                String text_password = Password.getText().toString();
                String text_name = Fullname.getText().toString();

                if(TextUtils.isEmpty(text_email) || TextUtils.isEmpty(text_password) || TextUtils.isEmpty(text_name)){
                    Toast.makeText(RegisterAcivity.this, "Entrer toutes les infos", Toast.LENGTH_SHORT).show();
                }else if (text_password.length()<6){
                    Toast.makeText(RegisterAcivity.this, "Password trop petit!", Toast.LENGTH_SHORT).show();
                }else{
                    registerUser(text_email,text_password,text_name);

                }
            }
        });

    }

    private void registerUser(String email, String password, String name) {
        pd.setMessage("Veuillez Patienter");
        pd.show();
        auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                    pd.dismiss();
                    HashMap<String , String> map = new HashMap<>();
                    map.put("Name", name);
                    map.put("Email",email);
                    map.put("Password",password);
                    map.put("id", auth.getCurrentUser().getUid());

                    myRef.child(auth.getCurrentUser().getUid()).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                startActivity(new Intent(RegisterAcivity.this,MainActivity.class));
                                Toast.makeText(RegisterAcivity.this, "Vous avez eregistrer", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                pd.dismiss();
                Toast.makeText(RegisterAcivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

