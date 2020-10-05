package rcylv.fatdevs.intents;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    public final  static String EXTRA_RESULT = "rcylv.fatdevs.intents.RESULT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView txt1;
        TextView txt2;
        Button button;
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);
             txt1 = findViewById(R.id.textView);
             txt2 = findViewById(R.id.textView2);
            button = findViewById(R.id.button2);
            Intent intent = getIntent();
           String text1 =  intent.getStringExtra(MainActivity.EXTRA_TEXT);
           final String text2 = intent.getStringExtra(MainActivity.EXTRA_NUMBER);
           txt1.setText(text1);
           txt2.setText(text2);
           button.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   int i = Integer.parseInt(text2);
                   Intent in = new Intent(MainActivity2.this, MainActivity.class);
                   in.putExtra(EXTRA_RESULT, i+100);
               }
           });
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("ID_KEY", 10019);
        outState.putInt("REFACTOR_POLL", 89);
     }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int prevData = savedInstanceState.getInt("ID_KEY");
    }
}