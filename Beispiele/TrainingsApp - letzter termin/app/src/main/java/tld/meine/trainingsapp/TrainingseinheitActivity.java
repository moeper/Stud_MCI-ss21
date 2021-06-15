package tld.meine.trainingsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class TrainingseinheitActivity extends AppCompatActivity {

    private TextView trainingsgeraetTextView;
    private TextView dauerTextView;
    private TextView kalorienTextView;
    private TrainingsProgramm tp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainingseinheit);

        //tp = ((MyApp)getApplication()).getTrainingsprogramm(((MyApp)getApplication()).gettpIndex());
        tp = ((MyApp)getApplication()).getTrainingsprogramm(((getIntent().getIntExtra(TrainingsprogrammeActivity.TPINDEX, 0))));

        //String title = getIntent().getStringExtra(TrainingsprogrammeActivity.TP);
        String title = "Trainingsprogramm " + Integer.toString(tp.getIndex() + 1);
        ((TextView)findViewById(R.id.tpTextView)).setText(title);

        trainingsgeraetTextView = ((TextView)findViewById(R.id.trainingsgeraetTextView));
        dauerTextView = ((TextView)findViewById(R.id.dauerTextView));
        kalorienTextView = ((TextView)findViewById(R.id.kalorienTextView));

        //teList = ((MyApp)getApplication()).getTeTransferList();


        setValues(tp.getTrainingseinheiten().getCurrent());
    }

    public void onClickPrevButton(View view)
    {
        setValues(tp.getTrainingseinheiten().prev());

    }

    public void onClickNextButton(View view)
    {
        setValues(tp.getTrainingseinheiten().next());
    }

    private void setValues(Trainingseinheit te)
    {
        trainingsgeraetTextView.setText(te.getFitnessgeraet().getName());
        dauerTextView.setText(Integer.toString(te.getDauerTraining()));
        kalorienTextView.setText(Integer.toString(te.verbrauchteKalorien()));
    }
}
