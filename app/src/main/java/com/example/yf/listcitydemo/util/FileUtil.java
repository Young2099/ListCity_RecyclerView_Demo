package com.example.yf.listcitydemo.util;

import android.content.Context;

import com.example.yf.listcitydemo.R;

import org.apache.http.util.EncodingUtils;

import java.io.InputStream;

/**
 * 文件的缓存与读取
 */
public class FileUtil {

    public static String getFromRaw(Context context) {
        String result = "";
        try {
            InputStream in = context.getResources().openRawResource(
                    R.raw.citylist);
            // 获取文件的字节数
            int lenght = in.available();
            // 创建byte数组
            byte[] buffer = new byte[lenght];
            // 将文件中的数据读到byte数组中
            in.read(buffer);
            result = EncodingUtils.getString(buffer, "utf-8");
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}