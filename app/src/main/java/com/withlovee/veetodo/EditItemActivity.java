package com.withlovee.veetodo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class EditItemActivity extends ActionBarActivity {

    TextView etEditItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        String itemText = getIntent().getStringExtra("item");
        etEditItem = (TextView) findViewById(R.id.etEditItem);
        etEditItem.setText(itemText);
    }

    public void onEditItem(View v){
        String newText = etEditItem.getText().toString();
        int position = getIntent().getIntExtra("itemPosition", 0);
        Intent data = new Intent();
        data.putExtra("item", newText);
        data.putExtra("itemPosition", position);
        setResult(200, data);
        Toast.makeText(this, "Updating..", Toast.LENGTH_SHORT).show();
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
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
