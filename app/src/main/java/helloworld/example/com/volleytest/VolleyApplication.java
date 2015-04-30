package helloworld.example.com.volleytest;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by sutirthchakravarty on 4/27/15.
 */
public class VolleyApplication extends Application {

private static  VolleyApplication sInstance;
private com.android.volley.RequestQueue mRequestQueue;

    @Override
    public void onCreate(){
        super.onCreate();
        mRequestQueue = Volley.newRequestQueue(this);
        sInstance = this;
    }

    public synchronized static VolleyApplication getInstance(){
        return sInstance;
    }

    public RequestQueue getRequestQueue(){
        return  mRequestQueue;
    }
}
