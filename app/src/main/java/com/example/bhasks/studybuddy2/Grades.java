package com.example.bhasks.studybuddy2;

import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;


public class Grades extends AppCompatActivity {

    TextView textRow2Col1, textRow2Col2, textRow2Col3, textRow2Col4, textRow2Col5, textRow2Col6, textRow2Col7,
            textRow3Col1, textRow3Col2, textRow3Col3, textRow3Col4, textRow3Col5, textRow3Col6, textRow3Col7,
            textRow4Col1, textRow4Col2, textRow4Col3, textRow4Col4, textRow4Col5, textRow4Col6, textRow4Col7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        DecimalFormat df = new DecimalFormat("00.00");

        ClassData CS2= new ClassData("CS2",4);
        CS2.addAnAssignment("exam1", 30, 85.5);
        CS2.addAnAssignment("exam2", 13, 92);
        textRow2Col1 = (TextView)findViewById(R.id.textRow2Col1);
        textRow2Col1.setText(CS2.getClassName());
        textRow2Col2 = (TextView)findViewById(R.id.textRow2Col2);
        textRow2Col2.setText(Integer.toString(CS2.getCredits()));
        textRow2Col3 = (TextView)findViewById(R.id.textRow2Col3);
        textRow2Col3.setText(CS2.getPercentInSTR());
        textRow2Col4 = (TextView)findViewById(R.id.textRow2Col4);
        textRow2Col4.setText(CS2.getGradeSTR());
        textRow2Col5 = (TextView)findViewById(R.id.textRow2Col5);
        textRow2Col5.setText(CS2.getLetterGPA());
        textRow2Col6 = (TextView)findViewById(R.id.textRow2Col6);
        textRow2Col6.setText(CS2.getMaxPossibleSTR());
        textRow2Col7 = (TextView)findViewById(R.id.textRow2Col7);
        textRow2Col7.setText(CS2.getMinPossibleSTR());

        ClassData FOCS= new ClassData("FOCS",4);
        FOCS.addAnAssignment("assignment1", 27, 90);
        FOCS.addAnAssignment("assignment2", 14, 96.5);
        FOCS.addAnAssignment("assignment3", 9, 80);
        FOCS.addAnAssignment("assignment4", 20, 92);
        FOCS.addAnAssignment("assignment5", 22, 89);
        textRow3Col1 = (TextView)findViewById(R.id.textRow3Col1);
        textRow3Col1.setText(FOCS.getClassName());
        textRow3Col2 = (TextView)findViewById(R.id.textRow3Col2);
        textRow3Col2.setText(Integer.toString(FOCS.getCredits()));
        textRow3Col3 = (TextView)findViewById(R.id.textRow3Col3);
        textRow3Col3.setText(FOCS.getPercentInSTR());
        textRow3Col4 = (TextView)findViewById(R.id.textRow3Col4);
        textRow3Col4.setText(FOCS.getGradeSTR());
        textRow3Col5 = (TextView)findViewById(R.id.textRow3Col5);
        textRow3Col5.setText(FOCS.getLetterGPA());
        textRow3Col6 = (TextView)findViewById(R.id.textRow3Col6);
        textRow3Col6.setText(FOCS.getMaxPossibleSTR());
        textRow3Col7 = (TextView)findViewById(R.id.textRow3Col7);
        textRow3Col7.setText(FOCS.getMinPossibleSTR());

/*
        ClassData MultiVar= new ClassData("MultiVar",4);
        MultiVar.addAnAssignment("ass1", 30, 85);
        MultiVar.addAnAssignment("ass2", 13, 92);
        MultiVar.addAnAssignment("ass3", 36, 75);
        textRow4Col1.setText(MultiVar.getClassName());
        textRow4Col2 = (TextView)findViewById(R.id.textRow4Col2);
        textRow4Col2.setText(Integer.toString(MultiVar.getCredits()));
        textRow4Col3 = (TextView)findViewById(R.id.textRow4Col3);
        textRow4Col3.setText(MultiVar.getPercentInSTR());
        textRow4Col4 = (TextView)findViewById(R.id.textRow4Col4);
        textRow4Col4.setText(MultiVar.getGradeSTR());
        textRow4Col5 = (TextView)findViewById(R.id.textRow4Col5);
        textRow4Col5.setText(MultiVar.getLetterGPA());
        textRow4Col6 = (TextView)findViewById(R.id.textRow4Col6);
        textRow4Col6.setText(MultiVar.getMaxPossibleSTR());
        textRow4Col7 = (TextView)findViewById(R.id.textRow4Col7);
        textRow4Col7.setText(MultiVar.getMinPossibleSTR());
*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_grades, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
