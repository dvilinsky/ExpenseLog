package edu.brandeis.cs.dvilinsk.expenselog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends Activity {
    ListView expenseLog;
    private int addItemRequestCode = 1;
    private ExpenseItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.expenseLog = (ListView) findViewById(R.id.expenseList);
        this.adapter = new ExpenseItemAdapter(MainActivity.this);
        this.expenseLog.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //So considering that there's only one item, this might be
        //unnecessary, but I think it's good practice
        switch (item.getItemId()) {
            case R.id.menu_add:
                startActivityForResult(new Intent(MainActivity.this, AddItem.class), addItemRequestCode);
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == addItemRequestCode) {
            if (resultCode == RESULT_OK) {
                ExpenseLogEntryData item = new ExpenseLogEntryData();
                item.setDescription(data.getStringExtra("description"));
                item.setNotes(data.getStringExtra("notes"));
                this.adapter.addItem(item);
            }
        }
    }
}
