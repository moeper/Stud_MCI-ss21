package com.example.application.capp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class TestsActivity extends AppCompatActivity {

    ListView listView;

    int icons[] = {R.drawable.ic_inprogress, R.drawable.ic_positiv,R.drawable.ic_negativ,R.drawable.ic_negativ};
    String dateOf[] = {"12.06.2021-14:35","12.06.2021-09:05","06.06.2021-11:00","01.06.2021-14:35"};
    String testId[] = {"T556677","T336622","T551199","T772299"};
    String personId[] = {"P556677","P336622","P551199","P772299"};
    TestState testState[] = {TestState.INPROGRESS,TestState.NEGATIV,TestState.NEGATIV,TestState.POSITIV};

    List<Test> testList = new ArrayList<>();

    CustomAdapter CustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_tests);

        listView = findViewById(R.id.listview);

        for (int i= 0; i<dateOf.length;i++){
            Test test = new Test(dateOf[i],testId[i],personId[i],testState[i],icons[i]);
            testList.add(test);
        }
        CustomAdapter = new CustomAdapter(testList, this);
        listView.setAdapter(CustomAdapter);
    }

    public class CustomAdapter extends BaseAdapter{

        private List<Test> listOfTest;
        private List<Test> listOfTestFiltered;
        private Context context;

        public CustomAdapter(List<Test> listOfTest, Context context) {
            this.listOfTest = listOfTest;
            this.listOfTestFiltered = listOfTest;
            this.context = context;
        }

        @Override
        public int getCount() {
            return listOfTestFiltered.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = getLayoutInflater().inflate(R.layout.row_tests,null);

            ImageView imageView = view.findViewById(R.id.imageView);
            TextView testState = view.findViewById(R.id.testState);
            TextView testId = view.findViewById(R.id.testId);

            imageView.setImageResource(listOfTestFiltered.get(position).getIcon());
            testState.setText(listOfTestFiltered.get(position).getTestResult().toString());
            testId.setText(listOfTestFiltered.get(position).getTestId());

            return view;
        }
    }

}