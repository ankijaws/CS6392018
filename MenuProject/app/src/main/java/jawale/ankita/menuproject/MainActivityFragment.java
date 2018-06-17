package jawale.ankita.menuproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;

import java.util.Locale;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {

    private Button sms, phone, web, map, share, newActivity;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        sms = (Button) rootView.findViewById(R.id.sms);
        phone = (Button) rootView.findViewById(R.id.phone);
        web = (Button) rootView.findViewById(R.id.web);
        map = (Button) rootView.findViewById(R.id.map);
        share = (Button) rootView.findViewById(R.id.share);
        newActivity = (Button) rootView.findViewById(R.id.newActivity);

        sms.setOnClickListener(this);
        phone.setOnClickListener(this);
        web.setOnClickListener(this);
        map.setOnClickListener(this);
        share.setOnClickListener(this);
        newActivity.setOnClickListener(this);


        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sms:
                try {
                    //SmsManager smsManager = SmsManager.getDefault();
                    //smsManager.sendTextMessage("9172888031", null, "Ankita Jawale", null, null);
                    Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( "sms:" + "9172888031"));
                    intent.putExtra( "sms_body", "Ankita Jawale" );
                    startActivity(intent);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
            case R.id.phone:
                try {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:" + "9172888031"));
                    startActivity(callIntent);
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case R.id.web:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/guide/"));
                startActivity(browserIntent);
                break;
            case R.id.map:
                String url = "https://www.google.com/maps/place/Dombivli+West,+Dombivli,+Maharashtra,+India/@19.2203022,73.0614498,14z/data=!3m1!4b1!4m5!3m4!1s0x3be7be1fd3379f6b:0xfa7a296caeeaf5c5!8m2!3d19.2157613!4d73.0729934";
                Intent mapIntent = new Intent(Intent.ACTION_VIEW,Uri.parse(url));
                startActivity(mapIntent);
                break;
            case R.id.share:
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT,"CS639");
                intent.putExtra(Intent.EXTRA_TEXT,"Join CS 639");
                startActivity(Intent.createChooser(intent,"Share the love"));
                break;
        }

    }
}
