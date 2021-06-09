package com.example.test_zentrum;

import androidx.annotation.ArrayRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class TestsActivity extends AppCompatActivity {


    SearchView searchView;
    ListView listView;

    ArrayList<Test> tests;

    String[] nameList = {"Test1", "Test2", "Test3", "Test4","Test5","Test6","Test7","Test8","Test9","Test10","Test11","Test12","Test13"};

    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);

        searchView = findViewById(R.id.search_bar);
        listView = findViewById(R.id.list_test);

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, nameList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener((adapterView, view, i, l) -> Toast.makeText(TestsActivity.this, "You Click -" + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show());

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                TestsActivity.this.arrayAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                TestsActivity.this.arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}

