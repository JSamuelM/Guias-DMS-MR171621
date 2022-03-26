package sv.edu.udb.componentesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Segunda extends AppCompatActivity {

    private TextView tvName;
    private TextView tvAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        tvName = (TextView) findViewById(R.id.txtViewName);
        tvAge = (TextView) findViewById(R.id.txtViewAge);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("txtName");
        String age = bundle.getString("txtAge");

        tvName.setText(name);
        tvAge.setText(age);
    }

    public void finish(View v) {
        finish();
    }
}