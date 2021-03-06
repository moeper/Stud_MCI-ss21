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
        listDataHeader.add("Wof??r brauchen wir die App?");
        List<String> n0 = new ArrayList<String>();
        n0.add("Die App soll helfen, die Ausbreitung von Coid 19 einzudaemmen. Die App kann schnell informieren, wenn Sie Kontakt mit einer positiv getesteten Person hatten. Wenn Sie die Information schnell erhalten, verringert auch die Gefahr, dass sich viele Menschen anstecken.");
        listDataChild.put(listDataHeader.get(0), n0);

        listDataHeader.add("Wie funktioniert die App?");
        List<String> n1 = new ArrayList<String>();
        n1.add("??ber das untere Men?? k??nnen Sie die einzelnen Funktionen aufrufen. Wenn Sie eine Ladenlokal betreten wollen k??nnen Sie ??ber den Punkt \"QR-Code\" einen Checkin durchf??hren. ??ber den Punkt \"Tests\" k??nnen Corona-Tests registriert werden.");
        listDataChild.put(listDataHeader.get(1), n1);

        listDataHeader.add("Wann warnt die App?");
        List<String> n2 = new ArrayList<String>();
        n2.add("Die App warnt Sie, wenn bei einem Besuch in einem Ladenlokal zur selben Zeit ein Corona-Infizierter anwesend war.");
        listDataChild.put(listDataHeader.get(2), n2);

        listDataHeader.add("Wie wird die Datensicherheit gewaehrleistet?");
        List<String> n3 = new ArrayList<String>();
        n3.add("Die App verfolgt einen dezentralen Ansatz, somit werden alle Pers??nlichen Daten nur auf Ihrem Handy lokal gespeichert. Die App ruft regelm????ig in der Zentrale die Problematischen Veranstaltungen ab und gleicht diese mit Ihren lokal gespeicherten ab, falls eine ??bereinstimmung auftritt werden Sie gewarnt");
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
        n6.add("Auf dem Startseite k??nnen Sie ??ber ein Dropdown Men?? Ihr gew??nschtes Bundesland w??hlen um die aktuellen Reglen einsehen zu k??nnen.");
        listDataChild.put(listDataHeader.get(6), n6);

        listDataHeader.add("Wie f??hre ich einen Checkin durch?");
        List<String> n7 = new ArrayList<String>();
        n7.add("Sie klicken im Men?? auf \"QR-Code\" und starten den Checkin mit \"neuen Checkin starten\". Sie fotografieren den ausgeh??ngten QR-Code, best??tigen diesen und geben Sie vorraussichtliche Aufenthaltsdauer an. Ihnen wird jetzt der aktuelle Checkin angezeigt.");
        listDataChild.put(listDataHeader.get(7), n7);

        listDataHeader.add("Was passiert wenn die Aufenthaltsdauer abgelaufen ist?");
        List<String> n8 = new ArrayList<String>();
        n8.add("Sie bekommen eine Benachrichtigung auf dem Handy angezeigt, wobei Sie die Dauer verl??ngern oder den Checkin beenden k??nnen.");
        listDataChild.put(listDataHeader.get(8), n8);

        listDataHeader.add("Wie f??hre ich einen Corona-Test durch?");
        List<String> n9 = new ArrayList<String>();
        n9.add("Sie tippen im Men?? auf \"Tests\", hier k??nnen Sie einen neuen Test anlegen. Es wird Ihnen ein QR-Code angezeigt den Sie im Testzentrum vorzeigen k??nnen. Nachdem der Test durch das Testzentrum erfasst wurde wird dieser unter Tests angezeigt. Das Ergebnis wird automatisch mit angezeigt wenn es vorliegt");
        listDataChild.put(listDataHeader.get(9), n9);

        listDataHeader.add("Was passiert wenn meine Aufenthaltsdauer abgelaufen ist?");
        List<String> n10 = new ArrayList<String>();
        n10.add("Sie werden Benachrichtigt und k??nnen w??hlen ob Sie die Aufenthaltsdauer verl??ngern oder den Aufenthalt beenden wollen (Checkout).");
        listDataChild.put(listDataHeader.get(10), n10);

        listDataHeader.add("Was nutzt die Angebe der Aufenthaltsdauer?");
        List<String> n11 = new ArrayList<String>();
        n11.add("So kann gew??hrleistet werden, dass Sie nur gewarnt werden, wenn w??hrend Ihres Besuchs in einem Ladenlokal kontakt mit einem Infizierten bestand.");
        listDataChild.put(listDataHeader.get(11), n11);

        listDataHeader.add("Was bedeutet das Warn Status Symbol auf der Startseite?");
        List<String> n12 = new ArrayList<String>();
        n12.add("Hier sehen Sie Ihren Corona Warn-Status, ist es gr??n waren Sie nicht in Kontakt mit einem Infizierten. Ist es rot, gab es eine Ladenlokal-Besuch wo Sie und ein Infizierter gleichzeitig eingekauft haben.");
        listDataChild.put(listDataHeader.get(12), n12);
         // Header, Child data





    }
}