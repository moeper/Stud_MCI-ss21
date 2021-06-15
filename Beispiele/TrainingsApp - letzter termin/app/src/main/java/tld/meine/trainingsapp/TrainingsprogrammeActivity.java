package tld.meine.trainingsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class TrainingsprogrammeActivity extends Activity {

    final public static String TPINDEX = "TPINDEX";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainingsprogramme);

        ArrayList<TrainingsProgramm> tp = ((MyApp)getApplication()).getTrainingsprogramme();

        LinearLayout lin = (LinearLayout) findViewById(R.id.tpLinearLayout);

        for(TrainingsProgramm i: tp){
            TextView tv = new TextView(TrainingsprogrammeActivity.this);
            tv.setText(i.getName());
            lin.addView(tv);
        }
    }

    public void onClickTrainingHinzufuegen(View view)
    {

        Log.v("Ausgabe", "onClickTrainingHinzufuegen");
        ArrayList<TrainingsProgramm> tp = ((MyApp)getApplication()).getTrainingsprogramme();

        Muskelgruppe beine = new Muskelgruppe("Beine", new String[]{"Abduktoren", "Adduktoren",
                "Quadrizeps", "Beinbizeps", "Zwillingswadenmuskel"});
        Muskelgruppe arme = new Muskelgruppe("Arme", new String[]{"Bizeps", "Brachialis", "Trizeps"});

        Fitnessgeraet crosstrainer = new Fitnessgeraet("Crosstrainer", "Cardio", beine, 45, 203, true);
        Fitnessgeraet hantelbank = new Fitnessgeraet("Hantelbank", "Krafttraining", arme, 20, 80, false);
        Fitnessgeraet huepfer = new Fitnessgeraet("Hüpfen", "Krafttraining", beine, 10, 20, false);


        Trainingseinheit te1 = new Trainingseinheit(crosstrainer);
        trainiereRandom(te1);
        Trainingseinheit te2 = new Trainingseinheit(hantelbank);
        trainiereRandom(te2);
        Trainingseinheit te3 = new Trainingseinheit(huepfer);
        trainiereRandom(te3);

        final TrainingsProgramm t = new TrainingsProgramm(500);
        //String nr = Integer.toString(tp.size() + 1);
        //t.setName("Trainingsprogramm " + nr);

        t.addTrainingseinheit(te1);
        t.addTrainingseinheit(te2);
        t.addTrainingseinheit(te3);

        tp.add(t);
        t.setIndex(tp.indexOf(t));
        Log.v("x", Integer.toString(tp.indexOf(t)));

        LinearLayout lin = (LinearLayout)findViewById(R.id.tpLinearLayout);

        TextView tv = new TextView(TrainingsprogrammeActivity.this);
        tv.setText("Trainingsprogramm " + Integer.toString(t.getIndex() + 1));
        //addTrainingsprogListener(tv);
        lin.addView(tv);

        tv.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.v("Ausgabe", "addTrainingsprogListener");
                Intent intent = new Intent(getApplicationContext(), TrainingseinheitActivity.class);
                //intent.putExtra(TP, ((TextView) v).getText());
                intent.putExtra(TPINDEX, t.getIndex());
                //((MyApp)getApplication()).setTeTransferList(t.getTrainingseinheiten());
                startActivity(intent);

            }
        });
    }

    private void addTrainingsprogListener(View view)
    {

    }

    private void trainiereRandom(Trainingseinheit te){
        int zufall = (int)(Math.random() * 100);
        Log.v("rand", "random: " + Integer.toString(zufall));
        for(int i = 0; i < zufall; i++)
        {
            te.trainieren();
        }
    }
}
