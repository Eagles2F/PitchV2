package magicbox.us.pitch.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.List;

import magicbox.us.pitch.PitchApp;

public class SharedPreferencesManager {

    private static final String FILE_NAME = "pitch_preference";

    private static SharedPreferences getSharedPreferences() {
        return PitchApp.getInstance().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }

    public static SharedPreferences.Editor getEditor() {
        return getSharedPreferences().edit();
    }

    public static void putObject(String key, Object object) {
        final Gson gson = new Gson();
        final String json = gson.toJson(object);
        getSharedPreferences().edit().putString(key, json).apply();
    }

    public static Object getObject(String key, final Class<?> cls) {
        final Gson gson = new Gson();
        final String json = getSharedPreferences().getString(key, "");
        if (TextUtils.isEmpty(json)) {
            return null;
        } else {
            return gson.fromJson(json, cls);
        }
    }

    public static void putList(String key, List<?> list, Type type) {
        final Gson gson = new Gson();
        final String json = gson.toJson(list, type);
        getSharedPreferences().edit().putString(key, json).apply();
    }

    public static List<?> getList(String key, Type type) {
        final Gson gson = new Gson();
        final String json = getSharedPreferences().getString(key, "");
        if (TextUtils.isEmpty(json)) {
            return null;
        } else {
            return gson.fromJson(json, type);
        }
    }

    public static void putBoolean(String key, boolean defValue) {
        getSharedPreferences().edit().putBoolean(key, defValue).apply();
    }

    public static boolean getBoolean(String key, boolean defValue) {
        return getSharedPreferences().getBoolean(key, defValue);
    }

    public static void putLong(String key, long defValue) {
        getSharedPreferences().edit().putLong(key, defValue).apply();
    }

    public static long getLong(String key, long defValue) {
        return getSharedPreferences().getLong(key, defValue);
    }

    public static void putString(String key, String defValue) {
        getSharedPreferences().edit().putString(key, defValue).apply();
    }

    public static String getString(String key, String defValue) {
        return getSharedPreferences().getString(key, defValue);
    }

    public static void putInt(String key, int value) {
        getSharedPreferences().edit().putInt(key, value).apply();
    }

    public static int getInt(String key, int defValue) {
        return getSharedPreferences().getInt(key, defValue);
    }

    public static void remove(String key) {
        getSharedPreferences().edit().remove(key).apply();
    }

    public static void clear() {
        getSharedPreferences().edit().clear().commit();
    }
}
