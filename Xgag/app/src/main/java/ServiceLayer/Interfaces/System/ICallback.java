package ServiceLayer.Interfaces.System;

/**
 * Created by Svetoslav on 7/2/2017.
 */

public interface ICallback<T> {
    void execute(T param);
}
