package com.example.librarybookmanage;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

public class ViewDetails extends AppCompatActivity {

    FirebaseFirestore db;

    BooksAdapter productsAdapter;
    ArrayList<Product_Books> arrayList = new ArrayList<>();
    RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = FirebaseFirestore.getInstance();
        productsAdapter = new BooksAdapter(this, arrayList);
        list = findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
        list.setAdapter(productsAdapter);

//        db.collection("products")
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
//
//                            for (QueryDocumentSnapshot document : task.getResult()) {
//                                Map<String, Object> data = document.getData();
//                                Product u = new Product();
//                                u.setId(document.getId());
//                                u.setName(String.valueOf(data.get("name")));
//                                u.setPrice(String.valueOf(data.get("price")));
//                                u.setQty(String.valueOf(data.get("qty")));
//                                u.setDescription(String.valueOf(data.get("description")));
//                                arrayList.add(u);
//                            }
//                            productsAdapter.notifyDataSetChanged();
//                        } else {
//                            Log.w(Constants.TAG, "Error getting documents.", task.getException());
//                        }
//                    }
//                });
        db.collection("books")

                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value,
                                        @Nullable FirebaseFirestoreException e) {

                        arrayList.clear();
                        for (QueryDocumentSnapshot document :value) {
                            Map<String, Object> data = document.getData();
                            Product_Books u = new Product_Books();
                            u.setId(document.getId());
                            u.setName(String.valueOf(data.get("bookname")));
                            u.setPrice(String.valueOf(data.get("date")));
                            u.setQty(String.valueOf(data.get("studentname")));
                            u.setDescription(String.valueOf(data.get("description")));
                            u.setPvaliddays(String.valueOf(data.get("validdays")));
                            u.setPdepartment(String.valueOf(data.get("department")));
                            arrayList.add(u);
                        }
                        productsAdapter.notifyDataSetChanged();
                    }
                });

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if (item.getItemId() == R.id.add) {
//            startActivity(new Intent(getApplicationContext(), com.example.firestoredemo.AddActivity.class));
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
