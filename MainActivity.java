package com.example.mohaned.firstandroid;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    private EditText inputTF;
    private TextView outputLabel;
    private EditText inputTF2;
    private TextView outputLabel4;

    private Integer[] bloom = new Integer[10000000];

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        this.inputTF = (EditText) this.findViewById(R.id.inputTF);
        this.outputLabel = (TextView) this.findViewById(R.id.outputLabel);
        this.inputTF2 = (EditText) this.findViewById(R.id.inputTF2);
        this.outputLabel4 = (TextView) this.findViewById(R.id.outputLabel4);
        createarry();



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    public void pressMeButtonClicked(View v) {
        //this.outputLabel.setText(this.inputTF.getText());
        Editable y=this.inputTF.getText();
        //int h = Integer.parseInt(y.toString());
        int h = Integer.parseInt(String.valueOf(y));
        murmur2 u = new murmur2();

        this.outputLabel.setText(String.valueOf(u.hashInt(h)));
    }
    public void createarry()
    {
        for(int i =0; i<2000000; i++)
        {
            bloom[i]=0;
        }
        Random rn = new Random();
        murmur2 j = new murmur2();


        for (int i=0; i<300000; i++)
        {
            int answer = rn.nextInt(1000000);
            bloom[j.hashInt(answer)]=1;
        }
    }
    public void lookforvalue(View v)
    {
        //this.outputLabel4.setText(this.inputTF2.getText());
        Editable y=this.inputTF2.getText();
        //int h = Integer.parseInt(y.toString());
        int h = Integer.parseInt(String.valueOf(y));
        murmur2 u = new murmur2();
        if(bloom[u.hashInt(h)]==1)
        {
            this.outputLabel4.setText("Yes, the value is in the Set");

        }
        else {

            this.outputLabel4.setText("No, the value is not in the set");
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.mohaned.firstandroid/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.mohaned.firstandroid/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
