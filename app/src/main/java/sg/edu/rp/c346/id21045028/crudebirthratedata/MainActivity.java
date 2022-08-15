package sg.edu.rp.c346.id21045028.crudebirthratedata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ListView lvBirth;
    AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvBirth = findViewById(R.id.lvBirth);
        client =new AsyncHttpClient();

    }
    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Birth> BirthList = new ArrayList<Birth>();

        client.get("https://data.gov.sg/api/action/datastore_search?resource_id=55f8c651-6c18-4017-b1f4-f4c4b65785e2&limit=10", new JsonHttpResponseHandler() {

            String id;
            String level;
            String value;
            String year;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    Log.i("data", response.toString());
                    JSONObject jsonArrResult = response.getJSONObject("result");
                    JSONArray jsonArrRecords = jsonArrResult.getJSONArray("records");
                    for (int i = 0; i < jsonArrRecords.length(); i++) {
                        JSONObject jsonObjRecords = jsonArrRecords.getJSONObject(i);
                        Log.i("RecordOBJ", jsonObjRecords.toString());
                        id = jsonObjRecords.getString("_id");
                        Log.i("ID Records", id);
                        level = jsonObjRecords.getString("level_1");
                        value = jsonObjRecords.getString("value");
                        year = jsonObjRecords.getString("year");
                        Birth birthrate = new Birth(id,level,value,year);
                        BirthList.add(birthrate);
                    }



                } catch (JSONException e) {

                }

                //POINT X – Code to display List View
                ArrayAdapter aaBirth = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, BirthList);
                lvBirth.setAdapter(aaBirth);
            }//end onSuccess
        });
    }

}