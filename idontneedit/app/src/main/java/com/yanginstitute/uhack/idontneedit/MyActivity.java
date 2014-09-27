package com.yanginstitute.uhack.idontneedit;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Button;
import android.util.Log;
import android.content.Context;

public class MyActivity extends Activity {

    EditText tEdit;
    Button tButton;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        tButton = (Button)findViewById(R.id.button1);
        tEdit = (EditText)findViewById(R.id.editText2);

        tButton.setOnClickListener(
            new View.OnClickListener() {
                public void onClick (View view){

                    // Log.v("EditText", tEdit.getText().toString()); //TEST
                    Intent intent = new Intent(MyActivity.this, SearchScreen.class);
                    intent.putExtra("searchString", tEdit.getText().toString());
                    startActivity(intent);

                }
            }
        );


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
