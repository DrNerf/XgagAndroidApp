package ServiceLayer.Classes.System;

/**
 * Created by Svetoslav on 7/2/2017.
 */

public class RuntimeInfo {
    static String SessionToken;
    static String UserName;
    static String AvatarUrl;

    public static String getSessionToken() {
        return SessionToken;
    }

    public static String getUserName() {
        return UserName;
    }

    public static String getAvatarUrl() {
        return AvatarUrl;
    }

    public static void setSessionToken(String sessionToken) {
        SessionToken = sessionToken;
    }

    public static void setUserName(String userName) {
        UserName = userName;
    }

    public static void setAvatarUrl(String avatarUrl) {
        AvatarUrl = avatarUrl;
    }
}
