package jawale.ankita.asynctaskproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView);
        String url = "https://raw.githubusercontent.com/ankijaws/CS6392018/master/Dombivli.png";
                //"https://github.com/ankijaws/CS6392018/blob/master/Dombivli.jpg";
        ImageAsyncTask imageAsyncTask = new ImageAsyncTask(imageView);
        imageAsyncTask.execute(url);
        return rootView;
    }


    private class ImageAsyncTask extends AsyncTask<String, String, Bitmap>{

        ImageView imageView;


        public ImageAsyncTask(ImageView imageView) {
            this.imageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(String... urls) {
            Bitmap bitmap = null;
            try {
                URL url = new URL(urls[0]);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                if(con.getResponseCode() != 200){
                    throw new Exception("Failed to connect");
                }
                InputStream in = con.getInputStream();
                //in.close();
                bitmap = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error in doInBackground", e.getMessage());
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imageView.setImageBitmap(bitmap);
        }
    }
}
