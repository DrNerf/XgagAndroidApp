package ServiceLayer.Classes.Proxies;

import android.support.annotation.Nullable;

import ServiceLayer.Interfaces.Proxies.ILoginProxy;
import ServiceLayer.Interfaces.Proxies.IPostsProxy;

/**
 * Created by Svetoslav on 7/2/2017.
 */

public class ProxyFactory {
    @Nullable
    public static <T> T create(Class<T> proxyType){
        if (proxyType.equals(ILoginProxy.class)){
            return (T) new LoginProxy();
        } else if (proxyType.equals(IPostsProxy.class)){
            return (T) new PostsProxy();
        }

        return null;
    }
}
