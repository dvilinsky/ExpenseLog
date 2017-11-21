package edu.brandeis.cs.dvilinsk.expenselog;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddItem extends Activity {

    Button btnSave;
    Button btnCancel;
    EditText notes;
    EditText description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        getReferences();
        setClickHandlers();
    }

    private void getReferences() {
        this.btnSave = (Button) findViewById(R.id.btn_save);
        this.btnCancel = (Button) findViewById(R.id.btn_cancel);
        this.notes = (EditText) findViewById(R.id.new_notes_item);
        this.description = (EditText) findViewById(R.id.new_description_item);
    }

    private void setClickHandlers() {
        this.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("notes", notes.getText().toString());
                data.putExtra("description", description.getText().toString());
                setResult(RESULT_OK, data);
                finish();
            }
        });

        this.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); //silently exit activity
            }
        });
    }
}
