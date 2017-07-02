package ServiceLayer.Classes.Proxies;
import com.loopj.android.http.*;

/**
 * Created by Svetoslav on 7/1/2017.
 */

class HttpClient {
    private static final String BASE_URL = "http://xgag.org/api/";

    private static AsyncHttpClient m_Client = new AsyncHttpClient();

    static {
        //m_Client.addHeader("Content-Type", "application/json");
    }


    public static void Get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        m_Client.get(GetAbsoluteUrl(url), params, responseHandler);
    }

    public static void Post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        m_Client.post(GetAbsoluteUrl(url), params, responseHandler);
    }

    private static String GetAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
