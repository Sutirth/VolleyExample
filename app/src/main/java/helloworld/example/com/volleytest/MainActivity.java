package helloworld.example.com.volleytest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;


public class MainActivity extends ActionBarActivity implements Response.Listener, Response.ErrorListener {

    TextView mTextView;
    public static final  String REQUEST_TAG = "MainActivity";
    public RequestQueue mQueue;
    Button mbtn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


   mTextView = (TextView) findViewById(R.id.text1);
        mbtn1 = (Button) findViewById(R.id.button);




    }


    @Override
    protected  void onStart(){
        super.onStart();
      mQueue  = CustomVolleyRequestQueue.getInstance(this.getApplicationContext()).getRequestQueue();
        String url = "http://api.tastykhana.in/3.0/frontend/menu.json?restaurant_id=63" ;
        final CustomJsonObjectRequest jsonRequest = new CustomJsonObjectRequest(Request.Method.GET, url, new JSONObject(), this, this);
        jsonRequest.setTag(REQUEST_TAG);

        mbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQueue.add(jsonRequest);
            }
        });
    }


    @Override
    protected void onStop(){
        super.onStop();
        if(mQueue!=null){
            mQueue.cancelAll(REQUEST_TAG);
        }
    }

    @Override
    public void onErrorResponse(VolleyError error){
        mTextView.setText(error.getMessage());
    }

   @Override
   public void onResponse(Object response){
        mTextView.setText("Response is " +response);
        try{
          //  mTextView.setText(mTextView.getText() + ((JSONObject) response).getString());
            Log.d("Reponse" , response.toString());

        }catch (Exception e){
            e.printStackTrace();
        }
   }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
