package com.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefenceManager {
    public static SharedPreferences getDefaultPref(Context mContext) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences("my_pref", mContext.MODE_PRIVATE);
        return sharedPreferences;
    }
}
