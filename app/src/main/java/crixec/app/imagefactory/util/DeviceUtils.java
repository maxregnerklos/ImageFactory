package crixec.app.imagefactory.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import crixec.app.imagefactory.R;
import crixec.app.imagefactory.core.ExceptionHandler;
import crixec.app.imagefactory.core.ImageFactory;
import crixec.app.imagefactory.ui.Toast;

public class DeviceUtils {
    private static String TAG = "DeviceUtils";

    public static String getSystemModel() {
        return android.os.Build.MODEL;
    }

    public static String getSystemManufacture() {
        return android.os.Build.MANUFACTURER;
    }

    public static int getSystemSDKVersion() {
        return android.os.Build.VERSION.SDK_INT;
    }

//
//    public static String getArchitecture() {
//        String arch = "Unsupported CPU Architecture!";
//        boolean x64 = false;
//        if (Build.VERSION.SDK_INT >= 21) {
//            arch = Build.SUPPORTED_ABIS[0];
//        } else {
//            arch = Build.CPU_ABI;
//        }
//        x64 = arch.indexOf("64") != -1;
//        if (arch.indexOf("arm") != -1) {
//            if (!x64) arch = "armeabi-v7a";
//            arch = "arm64-v8a";
//        } else if (arch.indexOf("86") != -1) {
//            if (!x64) arch = "x86";
//            arch = "x86_64";
//        }
//        Log.i(TAG, "The base cpu architecture : " + arch);
//        return arch;
//    }

    public static void openFolder(Context context, File file) {
        if (null == file || !file.exists()) {
            return;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.fromFile(file);
        intent.setDataAndType(uri, "resource/folder");
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            Toast.makeShortText(context.getString(R.string.operation_failed));
        }
    }

    public static void openFile(Context context, File file) {
        openFolder(context, file.getParentFile());
    }
//
//    public static void openAppInMarket(Context context, String pkgName) {
//        Intent viewIntent = new Intent("android.intent.action.VIEW",
//                Uri.parse("market://details?id=" + pkgName));
//        context.startActivity(viewIntent);
//    }
//
//    public static int getScrenWidth() {
//        return ImageFactory.getApp().getResources().getDisplayMetrics().widthPixels;
//    }
//
//    public static int getScreenHeight() {
//        return ImageFactory.getApp().getResources().getDisplayMetrics().heightPixels;
//    }

    public static String getSystemTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
    }
}
