package com.github.anglepengcoding.take_album_lib.listener;

import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.util.ArrayList;

/**
 * @author AngleCondingPeng
 * Created by on 2022/8/1 0001
 * @website https://github.com/AnglePengCoding
 */
public interface SingleCameraData {
    /**
     *
     * @param localMedia  localMedia data
     * @param requestCode onActivityResult requestCode
     *                    {@link android.app.Activity onActivityResult}
     */
    void getCameraData(ArrayList<LocalMedia> localMedia, int requestCode);
}
