package com.saigauravpurushothaman.stemsimulations;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> projectNames;
    ArrayAdapter<String> arrayAdapter;
    ListView listView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Set the action bar to the utd background color, remove any text title
        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFF9D5C")));
        bar.setTitle(Html.fromHtml("<font color='#FFFF9D5C'>STEMulations </font>"));

        projectNames = new ArrayList<>();
        projectNames.add("Ball Drop");
        projectNames.add("Ball Drop Code");
        projectNames.add("Ball Drop More");
        projectNames.add("Projectile Motion");
        projectNames.add("Projectile Motion Code");
        projectNames.add("Projectile Motion More");
        //findViewByID - finds id in XML, put into listView
        listView = findViewById(R.id.projects_list);

        //pass ArrayAdapter what data looks like
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.list_item, projectNames);
        //connect adaptor to listView
        listView.setAdapter(arrayAdapter);

        //anonymous class, implementing onItemClick method on the fly, context shifted to Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position) {
                    case 0:
                        //intents used to open new windows/activities
                        //need to set context to ProjectsActivity
                        intent = new Intent(MainActivity.this, Simulation1.class);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, Simulation1Code.class);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, Simulation1More.class);
                        break;
                    case 3:
                        intent = new Intent(MainActivity.this, Simulation2.class);
                        break;
                    case 4:
                        intent = new Intent(MainActivity.this, Simulation2Code.class);
                        break;
                    case 5:
                        intent = new Intent(MainActivity.this, Simulation2More.class);
                        break;
                    default:
                        intent = new Intent(MainActivity.this, MainActivity.class);
                        break;
                }

                startActivity(intent);
            }
        });
    }
}
