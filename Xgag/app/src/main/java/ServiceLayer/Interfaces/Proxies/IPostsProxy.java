package ServiceLayer.Interfaces.Proxies;

import java.util.List;

import ServiceLayer.Classes.Models.PostModel;
import ServiceLayer.Interfaces.System.ICallback;

/**
 * Created by Svetoslav on 7/4/2017.
 */

public interface IPostsProxy {
    void getPosts(int page, ICallback<List<PostModel>> callback);
}
