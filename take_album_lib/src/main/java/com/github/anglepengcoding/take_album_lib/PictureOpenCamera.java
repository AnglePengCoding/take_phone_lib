package com.github.anglepengcoding.take_album_lib;

import android.content.Intent;
import android.text.TextUtils;

import com.github.anglepengcoding.take_album_lib.config.SingleChoicePictureSelectorConfig;
import com.github.anglepengcoding.take_album_lib.engine.ImageCompressEngine;
import com.github.anglepengcoding.take_album_lib.engine.ImageLoadEngine;
import com.github.anglepengcoding.take_album_lib.exception.NotException;
import com.github.anglepengcoding.take_album_lib.listener.MeOnSelectLimitTipsListener;
import com.github.anglepengcoding.take_album_lib.listener.SingleCameraData;
import com.github.anglepengcoding.take_album_lib.listener.SingleMultipleCameraData;
import com.luck.picture.lib.basic.PictureSelector;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.luck.picture.lib.language.LanguageConfig;
import com.luck.picture.lib.style.PictureSelectorStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static android.app.Activity.RESULT_OK;
import static com.luck.picture.lib.basic.PictureSelector.obtainSelectorList;
import static com.luck.picture.lib.config.PictureConfig.CHOOSE_REQUEST;


/**
 * @author AngleCondingPeng
 * Created by on 2022/8/1 0001
 * @website https://github.com/AnglePengCoding
 */
public final class PictureOpenCamera {

    private final SingleChoicePictureSelector selector;
    private int REQUEST_CODE = CHOOSE_REQUEST;
    private final SingleChoicePictureSelectorConfig selectionConfig;


    public PictureOpenCamera(SingleChoicePictureSelector selector) {
        this.selector = selector;
        selectionConfig = SingleChoicePictureSelectorConfig.getCleanInstance();
    }


    /**
     * single choice photo
     */
    public PictureOpenCamera openSingleCamera() {
        PictureSelector.create(selector.getActivity())
                .openCamera(SelectMimeType.ofImage())
                .forResultActivity(CHOOSE_REQUEST);
        return this;
    }

    /**
     * single choice photo- upload pictures of specified type
     * example: TypeSelectionActivity
     */
    public void openSingleCamera(String type) {
        SingleChoicePictureSelectorConfig.getInstance().type = type;
        PictureSelector.create(selector.getActivity())
                .openCamera(SelectMimeType.ofImage())
                .forResultActivity(CHOOSE_REQUEST);
    }

    /**
     * single choice photo- custom requestCode
     * example: TypeSelectionActivity
     */
    public PictureOpenCamera openSingleCamera(int requestCode) {
        this.REQUEST_CODE = requestCode;
        PictureSelector.create(selector.getActivity())
                .openCamera(SelectMimeType.ofImage())
                .forResultActivity(requestCode);
        return this;
    }

    /**
     * multiple choice photo
     */
    public void openMultipleActivityCamera(List<LocalMedia> selectedList, OnResultCallbackListener<LocalMedia> call) {
        PictureSelector.create(selector.getActivity())
                .openGallery(SelectMimeType.ofImage())
                .setSelectorUIStyle(new PictureSelectorStyle())
                .setImageEngine(new ImageLoadEngine())
                .setCompressEngine(new ImageCompressEngine())
                .setSelectLimitTipsListener(new MeOnSelectLimitTipsListener())
                .setLanguage(LanguageConfig.CHINESE)
                .isDisplayCamera(false)
                .isOpenClickSound(false)
                .isFastSlidingSelect(false)
                .isWithSelectVideoImage(true)
                .isPreviewFullScreenMode(true)
                .isPreviewZoomEffect(true)
                .isPreviewImage(true)
                .isPreviewVideo(true)
                .isPreviewAudio(true)
                .isMaxSelectEnabledMask(true)
                .isDirectReturnSingle(false)
                .setMaxSelectNum(3)
                .isGif(false)
                .setSelectedData(selectedList)
                .forResult(call);
    }


    /**
     * multiple choice photo
     *
     * @param selectedList
     * @param call
     */
    public void openMultipleFragmentCamera(List<LocalMedia> selectedList, OnResultCallbackListener<LocalMedia> call) {
        PictureSelector.create(Objects.requireNonNull(selector.getFragment()))
                .openGallery(SelectMimeType.ofImage())
                .setSelectorUIStyle(new PictureSelectorStyle())
                .setImageEngine(new ImageLoadEngine())
                .setCompressEngine(new ImageCompressEngine())
                .setSelectLimitTipsListener(new MeOnSelectLimitTipsListener())
                .setLanguage(LanguageConfig.CHINESE)
                .isDisplayCamera(false)
                .isOpenClickSound(false)
                .isFastSlidingSelect(false)
                .isWithSelectVideoImage(true)
                .isPreviewFullScreenMode(true)
                .isPreviewZoomEffect(true)
                .isPreviewImage(true)
                .isPreviewVideo(true)
                .isPreviewAudio(true)
                .isMaxSelectEnabledMask(true)
                .isDirectReturnSingle(false)
                .setMaxSelectNum(3)
                .isGif(false)
                .setSelectedData(selectedList)
                .forResult(call);
    }

    /**
     * Example usage: SingleCameraActivity
     * selector.openCamera().openSingleCamera();
     * selector.openCamera().openSingleCamera(requestCode);
     * <p>
     * protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
     * selector.openCamera().getIntentResult(resultCode, requestCode, data, this);
     * super.onActivityResult(requestCode, resultCode, data);
     * }
     *
     * @param resultCode
     * @param requestCode
     * @param data
     * @param single
     */
    public void getIntentResult(int resultCode, int requestCode, Intent data,
                                SingleCameraData single) {
        if (!TextUtils.isEmpty(SingleChoicePictureSelectorConfig.getInstance().type)) {
            throw new NotException("Please use getIntentMultipleResult interface");
        }
        ArrayList<LocalMedia> media = new ArrayList<>();
        if (selector.getActivity() == null) {
            throw new NullPointerException("Activity cannot be null");
        }
        if (resultCode == RESULT_OK) {
            media = obtainSelectorList(data);
        }
        if (single != null) {
            single.getCameraData(media, requestCode);
        }
    }

    /**
     * Example usage: SingleCameraActivity
     * selector.openCamera().openSingleCamera("身份证");
     * selector.openCamera().openSingleCamera("反面证");
     * <p>
     * protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
     * selector.openCamera().getIntentMultipleResult(resultCode, requestCode, data, this);
     * super.onActivityResult(requestCode, resultCode, data);
     * }
     *
     * @param resultCode
     * @param requestCode
     * @param data
     */
    public void getIntentMultipleResult(int resultCode, int requestCode, Intent data,
                                        SingleMultipleCameraData multiple) {

        if (TextUtils.isEmpty(SingleChoicePictureSelectorConfig.getInstance().type)) {
            throw new NotException("Please use getIntentResult interface");
        }

        ArrayList<LocalMedia> media = new ArrayList<>();
        if (selector.getActivity() == null) {
            throw new NullPointerException("Activity cannot be null");
        }
        if (resultCode == RESULT_OK) {
            media = obtainSelectorList(data);
        }
        if (multiple != null) {
            multiple.getMultipleCameraData(SingleChoicePictureSelectorConfig.getInstance().type, media, requestCode);
        }
    }


}
