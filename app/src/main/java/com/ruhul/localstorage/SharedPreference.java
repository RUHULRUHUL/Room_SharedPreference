package com.ruhul.localstorage;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreference {

    private final SharedPreferences sharedPreferences;

    public SharedPreference(Context context) {
        sharedPreferences = context.getSharedPreferences("user_reg_log_status", Context.MODE_PRIVATE);
    }

    public boolean isUserloging() {
        boolean status = sharedPreferences.getBoolean("pref_is_user_loging", false);
        return status;
    }

    public void updateUserLogIngStatus(boolean status) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("pref_is_user_loging", status);
        editor.apply();
    }

    public void user_profile_data_clear() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }


    public void profile_save_data(int id, String name, String email, String phonenumber) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("user_id", id);
        editor.putString("user_name", name);
        editor.putString("user_email", email);
        editor.putString("user_phonenumber", phonenumber);
        editor.commit();
        editor.apply();
    }

    public void userAuthTokenNumberSave(String token) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("UserAuthTokenNumber", token);
        editor.apply();
    }

    public void OrderDeliveryAddress(String deliveryAddress) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("DeliveryAddress", deliveryAddress);
        editor.apply();
    }

    public String getDeliveryAddress() {
        return sharedPreferences.getString("DeliveryAddress", "");
    }

    public String getUserAuthTokenNumber() {
        return sharedPreferences.getString("UserAuthTokenNumber", "");
    }


    public void profile_get_data(String name, String email, String phonenumber, String password) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user_name", name);
        editor.putString("user_email", email);
        editor.putString("user_phonenumber", phonenumber);
        //editor.putString("user_password",name);
    }

    public String getusername() {
        return sharedPreferences.getString("user_name", "");
    }

    public String getuseremail() {
        return sharedPreferences.getString("user_email", "");
    }

    public String getuserphonenumber() {
        return sharedPreferences.getString("user_phonenumber", "");
    }

    public int getuserprofile_id() {
        return sharedPreferences.getInt("user_id", 0);
    }

}
