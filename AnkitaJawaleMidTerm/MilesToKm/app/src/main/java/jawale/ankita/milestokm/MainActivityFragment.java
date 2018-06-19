package jawale.ankita.milestokm;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private EditText miles;
    private TextView kms;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        miles = (EditText) rootView.findViewById(R.id.milesET);
        kms = (TextView) rootView.findViewById(R.id.kmTV);
        miles.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                calculateKms();
            }
        });

        return rootView;
    }

    private void calculateKms(){
        try {
            double milesValue = Double.parseDouble(miles.getText().toString().trim());
            double kmsValue = 1.609 * milesValue;
            kms.setText(String.format("%.2f", milesValue) +" miles are equivalent to "+String.format("%.2f", kmsValue) +" km");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
