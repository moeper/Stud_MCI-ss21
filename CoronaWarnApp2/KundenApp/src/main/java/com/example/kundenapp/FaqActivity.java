package com.example.kundenapp;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ExpandableListView;

import com.example.kundenapp.databinding.ActivityFaqBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FaqActivity extends AppCompatActivity {

    private ActivityFaqBinding binding;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    private int lastPosition = -1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFaqBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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







        // Adding child data
        listDataHeader.add("Wofür brauchen wir die App?");
        List<String> n0 = new ArrayList<String>();
        n0.add("Die App soll helfen, die Ausbreitung von Coid 19 einzudaemmen. Die App kann schnell informieren, wenn Sie Kontakt mit einer positiv getesteten Person hatten. Wenn Sie die Information schnell erhalten, verringert auch die Gefahr, dass sich viele Menschen anstecken.");
        listDataChild.put(listDataHeader.get(0), n0);

        listDataHeader.add("Wie funktioniert die App?");
        List<String> n1 = new ArrayList<String>();
        n1.add("Über das untere Menü können Sie die einzelnen Funktionen aufrufen. Wenn Sie eine Ladenlokal betreten wollen können Sie über den Punkt \"QR-Code\" einen Checkin durchführen. Über den Punkt \"Tests\" können Corona-Tests registriert werden.");
        listDataChild.put(listDataHeader.get(1), n1);

        listDataHeader.add("Wann warnt die App?");
        List<String> n2 = new ArrayList<String>();
        n2.add("Die App warnt Sie, wenn bei einem Besuch in einem Ladenlokal zur selben Zeit ein Corona-Infizierter anwesend war.");
        listDataChild.put(listDataHeader.get(2), n2);

        listDataHeader.add("Wie wird die Datensicherheit gewaehrleistet?");
        List<String> n3 = new ArrayList<String>();
        n3.add("Die App verfolgt einen dezentralen Ansatz, somit werden alle Persönlichen Daten nur auf Ihrem Handy lokal gespeichert. Die App ruft regelmäßig in der Zentrale die Problematischen Veranstaltungen ab und gleicht diese mit Ihren lokal gespeicherten ab, falls eine Übereinstimmung auftritt werden Sie gewarnt");
        listDataChild.put(listDataHeader.get(3), n3);

        listDataHeader.add("Welche personliche Daten speichert die App?");
        List<String> n4 = new ArrayList<String>();
        n4.add("Auf dem Handy wird gespeichert welche Veranstaltung/Ladenlokal Sie zu welcher Zeit besucht haben.");
        listDataChild.put(listDataHeader.get(4), n4);

        listDataHeader.add("Kann die App im Ausland benutzt werden?");
        List<String> n5 = new ArrayList<String>();
        n5.add("Nein.");
        listDataChild.put(listDataHeader.get(5), n5);

        listDataHeader.add("Wo sehe ich die aktuellen Corona Regeln?");
        List<String> n6 = new ArrayList<String>();
        n6.add("Auf der Startseite.");
        listDataChild.put(listDataHeader.get(6), n6);

        listDataHeader.add("Wie führe ich einen Checkin durch?");
        List<String> n7 = new ArrayList<String>();
        n7.add("Sie klicken im Menü auf \"QR-Code\" und starten den Checkin mit \"neuen Checkin starten\". Sie fotografieren den ausgehängten QR-Code, bestätigen diesen und geben Sie vorraussichtliche Aufenthaltsdauer an. Ihnen wird jetzt der aktuelle Checkin angezeigt.");
        listDataChild.put(listDataHeader.get(7), n7);

        listDataHeader.add("Was passiert wenn die Aufenthaltsdauer abgelaufen ist?");
        List<String> n8 = new ArrayList<String>();
        n8.add("Sie bekommen eine Benachrichtigung auf dem Handy angezeigt, wobei Sie die Dauer verlängern oder den Checkin beenden können.");
        listDataChild.put(listDataHeader.get(8), n8);

        listDataHeader.add("Wie führe ich einen Corona-Test durch?");
        List<String> n9 = new ArrayList<String>();
        n9.add("Sie tippen im Menü auf \"Tests\", hier können Sie einen neuen Test anlegen. Es wird Ihnen ein QR-Code angezeigt den Sie im Testzentrum vorzeigen können. Nachdem der Test durch das Testzentrum erfasst wurde wird dieser unter Tests angezeigt. Das Ergebnis wird automatisch mit angezeigt wenn es vorliegt");
        listDataChild.put(listDataHeader.get(9), n9);

         // Header, Child data





    }
}