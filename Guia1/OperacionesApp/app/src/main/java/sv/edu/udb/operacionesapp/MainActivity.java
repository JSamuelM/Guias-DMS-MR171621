package sv.edu.udb.operacionesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSum, btnSubtract, btnMultiply, btnDivider;
    private EditText num1, num2;
    private TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.numOne);
        num2 = findViewById(R.id.numTwo);
        total = findViewById(R.id.total);

        btnSum = findViewById(R.id.sum);
        btnSubtract = findViewById(R.id.substract);
        btnMultiply = findViewById(R.id.multiply);
        btnDivider = findViewById(R.id.divider);

        btnSum.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivider.setOnClickListener(this);
    }

    public void sum() {
        String numOne = num1.getText().toString();
        String numTwo = num2.getText().toString();
        double n1 = Double.parseDouble(numOne);
        double n2 = Double.parseDouble(numTwo);
        double result = n1 + n2;
        total.setText(String.valueOf(result));
    }

    public void subtract() {
        String numOne = num1.getText().toString();
        String numTwo = num2.getText().toString();
        double n1 = Double.parseDouble(numOne);
        double n2 = Double.parseDouble(numTwo);
        double result = n1 - n2;
        total.setText(String.valueOf(result));
    }

    public void multiply() {
        String numOne = num1.getText().toString();
        String numTwo = num2.getText().toString();
        double n1 = Double.parseDouble(numOne);
        double n2 = Double.parseDouble(numTwo);
        double result = n1 * n2;
        total.setText(String.valueOf(result));
    }

    public void divider() {
        String numOne = num1.getText().toString();
        String numTwo = num2.getText().toString();
        double n1 = Double.parseDouble(numOne);
        double n2 = Double.parseDouble(numTwo);
        double result = n1 / n2;
        total.setText(String.valueOf(result));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sum:
                sum();
                break;
            case R.id.substract:
                subtract();
                break;
            case R.id.multiply:
                multiply();
                break;
            case R.id.divider:
                divider();
                break;
        }
    }
}