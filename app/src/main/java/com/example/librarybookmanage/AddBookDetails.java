package com.example.librarybookmanage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddBookDetails extends AppCompatActivity {

    private FirebaseFirestore db;

    EditText bookname, mdate, studentname,description,mvaliddays,mdepartment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addbookdetails);
        db = FirebaseFirestore.getInstance();
        bookname = findViewById(R.id.bookname);
        mdate = findViewById(R.id.date);
        studentname = findViewById(R.id.stu_name);
        description= findViewById(R.id.description);
        mvaliddays=findViewById(R.id.validdays);
        mdepartment=findViewById(R.id.department);

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> product = new HashMap<>();
                product.put("bookname", bookname.getText().toString());
                product.put("date", mdate.getText().toString());
                product.put("studentname", studentname.getText().toString());
                product.put("description",description.getText().toString());
                product.put("validdays",mvaliddays.getText().toString());
                product.put("department",mdepartment.getText().toString());
                db.collection("books")
                        .add(product)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d(Constants.TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                                Toast.makeText(AddBookDetails.this, "Added", Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(AddBookDetails.this, ViewDetails.class));
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(Constants.TAG, "Error adding document", e);
                            }
                        });
            }
        });

        findViewById(R.id.viewbooks).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddBookDetails.this, ViewDetails.class));
            }
        });


    }
}
