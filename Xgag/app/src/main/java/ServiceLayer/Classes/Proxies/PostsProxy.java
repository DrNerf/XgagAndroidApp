package ServiceLayer.Classes.Proxies;

import android.util.Log;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.StringBufferInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import ServiceLayer.Classes.Models.PostModel;
import ServiceLayer.Interfaces.Proxies.IPostsProxy;
import ServiceLayer.Interfaces.System.ICallback;
import cz.msebera.android.httpclient.Header;

/**
 * Created by Svetoslav on 7/4/2017.
 */

class PostsProxy implements IPostsProxy {
    static final int PAGE_SIZE = 15;

    @Override
    public void getPosts(int page, final ICallback<List<PostModel>> callback) {
        HashMap<String, String> params = new HashMap<>();
        params.put("skip", String.valueOf(PAGE_SIZE * (page - 1)));
        params.put("take", String.valueOf(PAGE_SIZE));

        HttpClient.Get("Posts", new RequestParams(params), new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String json = new String(responseBody, StandardCharsets.UTF_8);
                try {
                    JSONArray response = new JSONArray(json);
                    ArrayList<PostModel> results = new ArrayList<>();
                    for (int i = 0; i < response.length(); i++){
                        JSONObject item = response.getJSONObject(i);
                        results.add(new PostModel(
                                item.getInt("id"),
                                item.getString("title"),
                                item.getString("imageUrl"),
                                item.getInt("score"),
                                item.getInt("commentsCount"),
                                item.getBoolean("anyNewComments"),
                                item.getString("youTubeLink")
                        ));
                    }

                    callback.execute(results);
                } catch (Exception ex){
                    Log.d("ERROR", ex.getMessage(), ex);
                    callback.execute(null);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                callback.execute(null);
            }
        });
    }
}
