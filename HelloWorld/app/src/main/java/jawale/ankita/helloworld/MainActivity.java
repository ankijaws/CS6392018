package jawale.ankita.helloworld;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.graphics.Typeface.ITALIC;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView introTV = (TextView) findViewById(R.id.intro);
        introTV.setText(R.string.intro);
        introTV.setTypeface(Typeface.defaultFromStyle(ITALIC));
    }
}
