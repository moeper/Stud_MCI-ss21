package com.example.application.listview;
import com.example.application.listview.ExpandableListAdapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FaqActivity extends AppCompatActivity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    private int lastPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                if (lastPosition != -1
                        && groupPosition != lastPosition) {
                    expListView.collapseGroup(lastPosition);
                }
                lastPosition = groupPosition;
            }
        });
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Wofür brauchen wir die App?");
        listDataHeader.add("Wie funktioniert die App?");
        listDataHeader.add("Wann warnt die App?");
        listDataHeader.add("Wie werden die Datensicherheit gewaehrleisten?");
        listDataHeader.add("Welche personliche Daten speichert die App?");
        listDataHeader.add("Kann die App im Ausland benutzt werden?");


        // Adding child data
        List<String> n0 = new ArrayList<String>();
        n0.add("Die App soll helfen, die Ausbreitung von Coid 19 einzudaemmen. Die App kann schnell informieren, ob eine Test positiv oder negativ ist. Das wird zum System weitergeleitet, um die Kontaktpersonen zu warnen.");


        List<String> n1 = new ArrayList<String>();
        n1.add("Die App funktioniert ganz einfach. Bevor Sie mit den Testergebnisse loslegen, müssen Sie sich anmelden. Diese passiert in dem Sie in der App registrieren, danach wird Ihre Registrierung verifiziert, ob Sie in einem Test-Zentum arbeiten und führen die Test durch. Jetzt könne ganz bequem über die Anmeldungsseite anmelden. Nachdem Sie sich angemeldet haben, können Sie jetzt Test erfassen ");

        List<String> n2 = new ArrayList<String>();
        n2.add("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. ");

        List<String> n3 = new ArrayList<String>();
        n3.add("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. ");

        List<String> n4 = new ArrayList<String>();
        n4.add("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. ");

        List<String> n5 = new ArrayList<String>();
        n5.add("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. ");


        listDataChild.put(listDataHeader.get(0), n0); // Header, Child data
        listDataChild.put(listDataHeader.get(1), n1);
        listDataChild.put(listDataHeader.get(2), n2);
        listDataChild.put(listDataHeader.get(3), n3);
        listDataChild.put(listDataHeader.get(4), n4);
        listDataChild.put(listDataHeader.get(5), n5);
    }
}