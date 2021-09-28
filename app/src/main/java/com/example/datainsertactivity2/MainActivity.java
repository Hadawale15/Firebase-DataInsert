package com.example.datainsertactivity2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText Name_obj,Email_obj,Mobile_obj,Date_obj,Password_obj;
    Button button;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name_obj=findViewById(R.id.Name_id);
        Email_obj=findViewById(R.id.Email_id);
        Mobile_obj = findViewById(R.id.Mobile_id);
        Date_obj=findViewById(R.id.Dob_id);
        Password_obj=findViewById(R.id.Password1_id);
        button=findViewById(R.id.button_id);

        databaseReference = FirebaseDatabase.getInstance().getReference("User1");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String NAME=Name_obj.getText().toString();
               String EMAIL=Email_obj.getText().toString();
               String MOBILE=Mobile_obj.getText().toString();
               String DATE=Date_obj.getText().toString();
               String PASSWORD=Password_obj.getText().toString();

                        String ID= databaseReference.push().getKey();
                        Model model=new Model(ID,NAME,EMAIL,MOBILE,DATE,PASSWORD);
                        databaseReference.child(NAME).setValue(model).addOnCompleteListener(new OnCompleteListener<Void>() {

                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(MainActivity.this, "Added", Toast.LENGTH_SHORT).show();
                                }

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

            }
        });
    }
}