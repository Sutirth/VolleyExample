package helloworld.example.com.volleytest;

import com.android.volley.AuthFailureError;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.JsonObjectRequest;
import  com.android.volley.Response;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sutirthchakravarty on 4/30/15.
 */
public class CustomJsonObjectRequest extends JsonObjectRequest {

    public CustomJsonObjectRequest(int method,String url,JSONObject jsonRequest,Response.Listener<JSONObject> listener,
                                    Response.ErrorListener errorListener){
        super(method, url, jsonRequest, listener, errorListener);
    }

    @Override
    public Map<String,String> getHeaders() throws AuthFailureError{
        HashMap<String,String> headers = new HashMap<String,String>();
        headers.put("TK-API-KEY","2a32078fc4be36a1f7caeb211c2a6f023f93fa26");
        return  headers;
    }

    @Override
    public RetryPolicy getRetryPolicy(){
        return super.getRetryPolicy();
    }

}
