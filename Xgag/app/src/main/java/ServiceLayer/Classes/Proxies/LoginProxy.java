package ServiceLayer.Classes.Proxies;

import android.util.Log;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import ServiceLayer.Classes.System.RuntimeInfo;
import ServiceLayer.Interfaces.Proxies.ILoginProxy;
import ServiceLayer.Interfaces.System.ICallback;
import cz.msebera.android.httpclient.Header;

/**
 * Created by Svetoslav on 7/1/2017.
 */

class LoginProxy implements ILoginProxy {
    @Override
    public void login(String username, String password, final ICallback<Boolean> callback) {
        HashMap<String, String> params = new HashMap<>();
        params.put("UserName", username);
        params.put("Password", password);
        params.put("RememberMe", "false");

        HttpClient.Post(
                "Auth/Login",
                new RequestParams(params),
                new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        String json = new String(responseBody, StandardCharsets.UTF_8);
                        try {
                            JSONObject jsonObject = new JSONObject(json);
                            RuntimeInfo.setSessionToken(jsonObject.getString("sessionToken"));
                            RuntimeInfo.setAvatarUrl(jsonObject.getString("avatar"));
                            RuntimeInfo.setUserName(jsonObject.getString("username"));
                            callback.execute(true);
                        } catch (Exception ex){
                            Log.d("ERROR", ex.getMessage(), ex);
                            callback.execute(false);
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        callback.execute(false);
                    }
                });
    }
}
