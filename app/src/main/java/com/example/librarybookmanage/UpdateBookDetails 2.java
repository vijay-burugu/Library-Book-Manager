package com.example.librarybookmanage;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class UpdateBookDetails extends AppCompatActivity {
    private FirebaseFirestore db;

    EditText name, udate, ustu_name, description,uvaliddays,udepartment;
    private Product_Books u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_books);
        db = FirebaseFirestore.getInstance();
        name = findViewById(R.id.ubookname);
        udate = findViewById(R.id.udate);
        ustu_name = findViewById(R.id.ustuname);
        description = findViewById(R.id.uescription);
        uvaliddays = findViewById(R.id.uvalidays);
        udepartment = findViewById(R.id.udepartment);

        u = getIntent().getParcelableExtra("books");
        name.setText(u.getName());
        udate.setText(u.getPrice());
        ustu_name.setText(u.getQty());
        description.setText(u.getDescription());
        uvaliddays.setText(u.getPvaliddays());
        udepartment.setText(u.getPdepartment());
        findViewById(R.id.uupdate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> product = new HashMap<>();
                product.put("bookname", name.getText().toString());
                product.put("date", udate.getText().toString());
                product.put("studentname", ustu_name.getText().toString());
                product.put("description", description.getText().toString());
                product.put("validdays", uvaliddays.getText().toString());
                product.put("department", udepartment.getText().toString());
                db.collection("books").document(u.getId()).update(product)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(UpdateBookDetails.this, "Success", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(UpdateBookDetails.this, "Failed", Toast.LENGTH_SHORT).show();
                                e.printStackTrace();
                            }
                        });
            }
        });
    }
}
