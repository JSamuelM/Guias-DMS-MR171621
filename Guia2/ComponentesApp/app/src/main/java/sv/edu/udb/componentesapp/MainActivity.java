package sv.edu.udb.componentesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.txtName);
        etAge = findViewById(R.id.txtAge);
    }

    public void secondActivity(View v) {
        Intent i = new Intent(this, Segunda.class);
        i.putExtra("txtName", etName.getText().toString());
        i.putExtra("txtAge", etAge.getText().toString());
        startActivity(i);
    }
}