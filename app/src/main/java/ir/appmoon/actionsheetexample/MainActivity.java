package ir.appmoon.actionsheetexample;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import ir.appmoon.amactionsheet.AmActionSheet;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FloatingActionButton fab = findViewById(R.id.fab);
        final CoordinatorLayout coordinatorLayout = findViewById(R.id.coordinator_layout);
        final List<String> buttonsNameList = new ArrayList<>();
        buttonsNameList.add("a");
        buttonsNameList.add("b");
        buttonsNameList.add("c");
        buttonsNameList.add("d");


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AmActionSheet amActionSheet = new AmActionSheet(MainActivity.this, coordinatorLayout);
                amActionSheet.setButtonsNameList(buttonsNameList);
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

                View rootView = inflater.inflate(R.layout.custom_layout, null);
                amActionSheet.setView(rootView);

                amActionSheet.setCancelTitle("cancel");
                amActionSheet.initAmActionSheet();
                amActionSheet.showAmActionSheet();


            }
        });
    }


}
