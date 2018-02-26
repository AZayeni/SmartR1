package WS;

import android.os.AsyncTask;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;


/**
 * Created by AZayeni on 21/02/2018.
 */

public class BaseWSTask extends AsyncTask<String,Void,String> {
    private static String url;
    @Override
    protected String doInBackground(String... strings) {
        String response =BaseWS.getHttpConnection("http://nr.extechdev.co.uk/Client/GetClients", null,null);
        try {
            //Log.v("response",""+response);
            if (response!=null){
                org.json.JSONArray jsonArray = new org.json.JSONArray(response);

                for (int i=0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    /// TO DO

                }}
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return "";
    }

    @Override
    protected void onPostExecute(String s) {
        /// To DO
        int i=0;
        i++;
    }
}
