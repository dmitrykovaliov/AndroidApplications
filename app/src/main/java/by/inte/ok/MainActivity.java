package by.inte.ok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mEnterTextView;
    TextView mResultTextView;
    EditText mResultEditText;
    Button mButton;
    Button mButton2;
    Generate mGenerate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEnterTextView = findViewById(R.id.enterTextView);
        mResultTextView = findViewById(R.id.resultTextView);
        mResultEditText = findViewById(R.id.resultEditText);
        mButton = findViewById(R.id.button);
        mButton.setEnabled(false);
        mButton2 = findViewById(R.id.button2);

        mGenerate = new Generate();
        nextGenerate();

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compareResult();
            }
        });

        mResultTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compareResult();
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mResultEditText.setText("");
                nextGenerate();
            }
        });
    }

    void nextGenerate() {
        mGenerate.generateRandom();
        mEnterTextView.setText(mGenerate.toString());
        mResultTextView.setText("");
        mResultEditText.setEnabled(true);
        mButton.setEnabled(false);
    }

    void compareResult () {
        Integer resultValue = Integer.parseInt(mResultEditText.getText().toString());
        if((resultValue - mGenerate.getSum()) == 0) {
            mButton.setEnabled(true);
            mResultTextView.setText(R.string.ok_text);
            mResultEditText.setEnabled(false);
        } else {
            mResultTextView.setText(R.string.check_text);
            mButton.setEnabled(false);
        }
    }
}
