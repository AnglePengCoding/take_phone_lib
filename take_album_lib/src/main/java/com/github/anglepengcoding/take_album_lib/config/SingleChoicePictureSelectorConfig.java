package com.github.anglepengcoding.take_album_lib.config;

/**
 * @author AngleCondingPeng
 * Created by on 2022/8/1 0001
 * @website https://github.com/AnglePengCoding
 */
public class SingleChoicePictureSelectorConfig {
    public String type;

    private static SingleChoicePictureSelectorConfig mInstance;

    public static SingleChoicePictureSelectorConfig getCleanInstance() {
        SingleChoicePictureSelectorConfig selectionSpec = getInstance();
        return selectionSpec;
    }


    public static SingleChoicePictureSelectorConfig getInstance() {
        if (mInstance == null) {
            synchronized (SingleChoicePictureSelectorConfig.class) {
                if (mInstance == null) {
                    mInstance = new SingleChoicePictureSelectorConfig();
                }
            }
        }
        return mInstance;
    }
}
