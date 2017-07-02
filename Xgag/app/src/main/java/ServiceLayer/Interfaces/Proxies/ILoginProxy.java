package ServiceLayer.Interfaces.Proxies;

import com.loopj.android.http.AsyncHttpResponseHandler;

import ServiceLayer.Interfaces.System.ICallback;

/**
 * Created by Svetoslav on 7/1/2017.
 */

public interface ILoginProxy {
    void login(String username, String password, ICallback<Boolean> callback);
}
