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
        listDataHeader.add("Wofür brauchen wir die App?");
        listDataHeader.add("Wie funktioniert die App?");
        listDataHeader.add("Wann warnt die App?");
        listDataHeader.add("Wie wird die Datensicherheit gewaehrleistet?");
        listDataHeader.add("Wie aussagekräftig ist die aktuelle Kundenanzahl?");
        listDataHeader.add("Kann die App im Ausland benutzt werden?");
        listDataHeader.add("Wie kann ich den QR-Code drucken?");
        listDataHeader.add("Wie wie die aktuelle maximale Kundenanzahl berechnet?");
        listDataHeader.add("Sind die Corona Regeln für mein Bundesland einsehbar?");
        listDataHeader.add("Wozu dient die typische Aufenthaltsdauer?");

        // Adding child data
        List<String> n0 = new ArrayList<String>();
        n0.add("Die App soll helfen, die Ausbreitung von Coid 19 einzudaemmen. Die App kann schnell informieren, wenn Sie Kontakt mit einer positiv getesteten hatten. Wenn Sie die Information schnell erhalten, verringert auch die Gefahr, dass sich viele Menschen anstecken.");


        List<String> n1 = new ArrayList<String>();
        n1.add("Als Einzelhändler erstellen Sie einen QR-Code für Ihr Ladenlokal, diesen können Sie ausdrucken und den Kunden zur Verfügung stellen, damit Sie disen einscannen können. So können die Nutzer gewarnt werden falls Sie in kontakt mit einem infizierten waren.");

        List<String> n2 = new ArrayList<String>();
        n2.add("Im Fall eines Überschreitens der maximalen Kundenanzahl.");

        List<String> n3 = new ArrayList<String>();
        n3.add("Alle persönlichen Daten werden nur lokal auf dem Handy gespeichert, Daten für die zentrale Verwaltung sind stets anonym hinterlegt.");

        List<String> n4 = new ArrayList<String>();
        n4.add("Es kann nicht gewährleistet werden, dass die Angaben immer richtig sind. Diese Funktion soll nur als Hilfsmittel dienen um Sie im alltag zu unterstützen.");

        List<String> n5 = new ArrayList<String>();
        n5.add("Nein");

        List<String> n6 = new ArrayList<String>();
        n6.add("Tippen Sie auf \"QR-Code als PDF herunterladen\", das PDF kann dann über das Handy gedruckt oder auf einen PC übertragen und von dort ausgedruckt werden.");

        List<String> n7 = new ArrayList<String>();
        n7.add("Diese wird durch die Flächenangabe und die aktuellen Corona Regeln errechnet.");

        List<String> n8 = new ArrayList<String>();
        n8.add("Auf dem Startbildschirm können Sie über ein Dropdown Menü Ihr gewünschtes Bundesland wählen um die aktuellen Reglen einsehen zu können.");

        List<String> n9 = new ArrayList<String>();
        n9.add("Hier können Sie angeben wie viel Zeit ein Kunde durchschnittlich in Ihrem Ladenlokal verbringt. Dies dient ggf. dazu dem Kunden die Bedienung der App zu erleichtern.");

        listDataChild.put(listDataHeader.get(0), n0); // Header, Child data
        listDataChild.put(listDataHeader.get(1), n1);
        listDataChild.put(listDataHeader.get(2), n2);
        listDataChild.put(listDataHeader.get(3), n3);
        listDataChild.put(listDataHeader.get(4), n4);
        listDataChild.put(listDataHeader.get(5), n5);
        listDataChild.put(listDataHeader.get(6), n6);
        listDataChild.put(listDataHeader.get(7), n7);
        listDataChild.put(listDataHeader.get(8), n8);
        listDataChild.put(listDataHeader.get(9), n9);
    }
}