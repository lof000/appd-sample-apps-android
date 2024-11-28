package com.example.android.networkconnect;

import android.util.Log;

import com.appdynamics.eumagent.runtime.HttpRequestTracker;

import java.net.MalformedURLException;
import java.net.URL;

public class TestNetworkRequestCallback implements com.appdynamics.eumagent.runtime.NetworkRequestCallback  {
    @Override
    public boolean onNetworkRequest(HttpRequestTracker httpRequestTracker) {
        String urlString = httpRequestTracker.getURL().toString();
        Log.d("appdynamics","---------- changeurl");
        try {
            URL url = new URL("http://caronte.teste.com/");
            if (urlString.contains("testeapi")) {
                // Change the URL for calls to Facebook
                httpRequestTracker.withURL(url);
                return true;
            }
        } catch (MalformedURLException e) {
            return false;
        }
        return true;
    }


}