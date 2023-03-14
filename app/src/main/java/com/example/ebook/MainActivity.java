package com.example.ebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ebook.adapter.BookAdapter;
import com.example.ebook.models.Books;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Books> list = new ArrayList<>();
    RecyclerView recyclerView;
    BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_books);
        adapter = new BookAdapter(list,MainActivity.this);
        recyclerView.setAdapter(adapter);
        
        loadData();
    }

    private void loadData() {
        FirebaseDatabase.getInstance().getReference()
                .child("books")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        list.clear();
                        adapter.notifyDataSetChanged();

                        for(DataSnapshot dataSnapshot : snapshot.getChildren())
                        {
                            String title = dataSnapshot.child("title").getValue().toString();
                            String cover = dataSnapshot.child("cover").getValue().toString();
                            String content = dataSnapshot.child("content").getValue().toString();
                            String type = dataSnapshot.child("type").getValue().toString();

                            list.add(new Books(title, cover,content,type));
                            adapter.notifyDataSetChanged();

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
    }
}