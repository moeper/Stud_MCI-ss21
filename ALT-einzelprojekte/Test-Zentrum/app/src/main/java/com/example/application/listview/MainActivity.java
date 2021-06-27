package com.example.application.listview;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

        ListView listView;
        Button testRegist;

//        int icons[] = {R.drawable.ic_inprogress, R.drawable.ic_positiv,R.drawable.ic_negativ,R.drawable.ic_negativ,R.drawable.ic_negativ,R.drawable.ic_negativ,R.drawable.ic_negativ,R.drawable.ic_negativ,R.drawable.ic_negativ,R.drawable.ic_negativ,R.drawable.ic_negativ,R.drawable.ic_negativ};
//        String dateOf[] = {"12.06.2021-14:35","12.06.2021-09:05","06.06.2021-11:00","01.06.2021-14:35","01.06.2021-14:35","01.06.2021-14:35","01.06.2021-14:35","01.06.2021-14:35","01.06.2021-14:35","01.06.2021-14:35","01.06.2021-14:35","01.06.2021-14:35"};
//        String testId[] = {"T-"+UUID.randomUUID().toString(),"T-"+UUID.randomUUID().toString(),"T-"+UUID.randomUUID().toString(),"T-"+UUID.randomUUID().toString(),"T-"+UUID.randomUUID().toString(),"T-"+UUID.randomUUID().toString(),"T-"+UUID.randomUUID().toString(),"T-"+UUID.randomUUID().toString(),"T-"+UUID.randomUUID().toString(),"T-"+UUID.randomUUID().toString(),"T-"+UUID.randomUUID().toString(),"T-"+UUID.randomUUID().toString()};
//        String personId[] = {"P-"+UUID.randomUUID().toString(),"P-"+UUID.randomUUID().toString(),"P-"+UUID.randomUUID().toString(),"P-"+UUID.randomUUID().toString(),"P-"+UUID.randomUUID().toString(),"P-"+UUID.randomUUID().toString(),"P-"+UUID.randomUUID().toString(),"P-"+UUID.randomUUID().toString(),"P-"+UUID.randomUUID().toString(),"P-"+UUID.randomUUID().toString(),"P-"+UUID.randomUUID().toString(),"P-"+UUID.randomUUID().toString()};
//        TestState testState[] = {TestState.INPROGRESS,TestState.POSITIV,TestState.NEGATIV,TestState.NEGATIV,TestState.NEGATIV,TestState.NEGATIV,TestState.NEGATIV,TestState.NEGATIV,TestState.NEGATIV,TestState.NEGATIV,TestState.NEGATIV,TestState.NEGATIV};

        public static List<Test> testList = new ArrayList<>();

        CustomAdapter customAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            listView = findViewById(R.id.viewList);
            testRegist = findViewById(R.id.testErfassen);

//            for (int i= 0; i<dateOf.length;i++){
//                Test test = new Test(dateOf[i],testId[i],personId[i],testState[i],icons[i]);
//                testList.add(test);
//            }

            customAdapter = new CustomAdapter(testList, this);
            listView.setAdapter(customAdapter);

            testRegist.setOnClickListener(v -> {
                openActivity();
            });

        }
    public void openActivity(){
        Intent intent = new Intent(this, AddTestActivity.class);
        startActivity(intent);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.infos, menu);
            getMenuInflater().inflate(R.menu.menu,menu);
            MenuItem menuItem = menu.findItem(R.id.search_view);
            SearchView searchView = (SearchView) menuItem.getActionView();

            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    customAdapter.getFilter().filter(newText);
                    return true;
                }
            });

            return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();
            if (id==R.id.search_view){
                return true;
            }
        switch(item.getItemId()){
            case R.id.aboutApp:
                Intent intent = new Intent(MainActivity.this, AboutAppActivity.class);
                startActivity(intent);
                return true;
            case R.id.faq:
                Intent intent2 = new Intent(MainActivity.this, FaqActivity.class);
                startActivity(intent2);
                return true;
            case R.id.funkt:
                Intent intent3 = new Intent(MainActivity.this, InfosFirstActivity.class);
                startActivity(intent3);
                return true;
            case R.id.privacy:
                Intent intent4 = new Intent(MainActivity.this, PrivacyActivity.class);
                startActivity(intent4);
                return true;
            case R.id.howTo:
                Intent intent5 = new Intent(MainActivity.this, HowToActivity.class);
                startActivity(intent5);
                return true;
            case R.id.impress:
                Intent intent6 = new Intent(MainActivity.this, ImpressActivity.class);
                startActivity(intent6);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    public class CustomAdapter extends BaseAdapter implements Filterable {

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
                TextView dateId = view.findViewById(R.id.dateId);

                imageView.setImageResource(listOfTestFiltered.get(position).getIcon());
                testState.setText(listOfTestFiltered.get(position).getTestResult().toString());
                testId.setText(listOfTestFiltered.get(position).getTestId());
                dateId.setText(listOfTestFiltered.get(position).getDateOf());

                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, testEvaluate.class).putExtra("test",listOfTestFiltered.get(position)));
                    }
                });

                return view;
            }

        @Override
        public Filter getFilter() {
                Filter filter = new Filter() {
                    @Override
                    protected FilterResults performFiltering(CharSequence constraint) {
                        FilterResults filterResults = new FilterResults();

                        if (constraint == null || constraint.length() == 0){
                            filterResults.count = listOfTest.size();
                            filterResults.values = listOfTest;
                        }else {
                            String searchStr = constraint.toString().toLowerCase();
                            List<Test> resultData = new ArrayList<>();
                            for (Test test:listOfTest){
                                if (test.getTestResult().toString().contains(searchStr) || test.getTestId().contains(searchStr)){
                                    resultData.add(test);
                                }
                                filterResults.count = resultData.size();
                                filterResults.values = resultData;
                            }
                        }

                        return filterResults;
                    }

                    @Override
                    protected void publishResults(CharSequence constraint, FilterResults results) {
                        listOfTestFiltered = (List<Test>) results.values;
                        notifyDataSetChanged();
                    }
                };
            return filter;
        }
    }

    }