package ServiceLayer.Classes.Proxies;

import ServiceLayer.Interfaces.Proxies.ILoginProxy;

/**
 * Created by Svetoslav on 7/2/2017.
 */

public class ProxyFactory {
    public static ILoginProxy create(){
        return new LoginProxy();
    }
}
