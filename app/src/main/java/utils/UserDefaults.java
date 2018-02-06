package utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Shankar.
 */
public class UserDefaults {
    /**
     * this is the preference class used to store the user default values
     */
    public static final String PREF_NAME = "theaterauditorium";
    private static UserDefaults instance;
    private SharedPreferences sh;
    private SharedPreferences.Editor edit;

    private UserDefaults(Context mContext) {
        sh = mContext.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);
        edit = sh.edit();
    }

    public static synchronized UserDefaults getInstance(Context mContext) {
        if (instance == null) {
            instance = new UserDefaults(mContext);
        }
        return instance;
    }

    public void clear() {
        edit.clear().commit();
    }


    public String getId() {
        return sh.getString("id", "");
    }

    public void setId(String id) {
        edit.putString("id", id).commit();
    }


}
