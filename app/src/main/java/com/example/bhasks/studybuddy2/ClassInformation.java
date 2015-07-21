package com.example.bhasks.studybuddy2;

/**
 * Created by cordom2 on 6/25/2015.
 */

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.app.ListActivity;
import android.widget.Toast;

import java.util.Scanner;

public class ClassInformation extends AppCompatActivity {

    public ClassInformation() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_info);


        String[] myClasses = { "CS2", "FOCS", "FOA" };

        ListAdapter classListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myClasses);

        ListView classListView = (ListView) findViewById(R.id.classListView);

        classListView.setAdapter(classListAdapter);

        classListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                String classPicked = "You selected " + String.valueOf(adapterView.getItemAtPosition(position));

                Toast.makeText(ClassInformation.this, classPicked, Toast.LENGTH_SHORT).show();
            }
        });

        String class1Name= "CS2";
        String class1Assignment1= "HW1";
        int class1Ass1Weight= 4;
        int class1Ass1Grade= 90;
        String class1Assignment2= "Exam 1";
        int class1Ass2Weight= 10;
        int class1Ass2Grade= 70;

        double class1Ass1Final= class1Ass1Grade*class1Ass1Weight/100;
        double class1Ass2Final= class1Ass2Grade*class1Ass2Weight/100;
        double class1PercentIn= class1Ass1Weight + class1Ass2Weight;
        double class1CurrentGrade= (100*class1PercentIn)*(class1Ass1Final+class1Ass2Final);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_class_info, menu);
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



//    public class ClassInformationApplication {
//        public static void main(String[] args) {
//            System.out.println("Enter a password: ");
//            Scanner input = new Scanner(System.in);
//            String data = input.nextLine();
//            System.out.println(data);
//
//
//            String[] myClasses = { "CS2", "FOCS", "FOA" };
//        }
//    }


}
