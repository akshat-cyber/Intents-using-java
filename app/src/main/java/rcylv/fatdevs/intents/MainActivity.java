package rcylv.fatdevs.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
public final static String EXTRA_TEXT = "rcylv.fatdevs.intents.TEXT";
public final static String EXTRA_NUMBER = "rcylv.fatdevs.intents.NUMBER";
    public final static String EXTRA_MESSAGE = "rcylv.fatdevs.intents.MESSAGE";
            String message;
    public final static int TEXT_REQUEST_ID = 1011001;
   private EditText text1;
    private EditText text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         text1 = findViewById(R.id.editTextTextPersonName);
         text2 = findViewById(R.id.editTextNumber);
        Button button = findViewById(R.id.button);
        Button button1 = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {NavigateToActivity2WithSimpleIntents();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigateToActivity2WithIntents();
            }
        });
    }
    public void NavigateToActivity2WithSimpleIntents(){
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(EXTRA_TEXT, text1.getText().toString());
        intent.putExtra(EXTRA_NUMBER, text2.getText().toString());
        startActivity(intent);
        Intent in = getIntent();
        text2.setText(in.getStringExtra(MainActivity2.EXTRA_RESULT));
    }
    public void NavigateToActivity2WithIntents() {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST_ID);
    }
}