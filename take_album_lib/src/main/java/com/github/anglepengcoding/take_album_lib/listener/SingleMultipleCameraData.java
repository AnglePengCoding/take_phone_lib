package com.github.anglepengcoding.take_album_lib.listener;

import com.luck.picture.lib.entity.LocalMedia;

import java.util.ArrayList;

/**
 * @author AngleCondingPeng
 * Created by on 2022/8/1 0001
 * @website https://github.com/AnglePengCoding
 */
public interface SingleMultipleCameraData {
    /**
     * @param type
     * @param localMedia
     * @param requestCode
     *  {@link android.app.Activity onActivityResult}
     */
    void getMultipleCameraData(String type, ArrayList<LocalMedia> localMedia, int requestCode);
}
