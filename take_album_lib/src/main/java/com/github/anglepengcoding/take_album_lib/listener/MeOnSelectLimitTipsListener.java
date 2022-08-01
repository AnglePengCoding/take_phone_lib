package com.github.anglepengcoding.take_album_lib.listener;

import android.content.Context;

import com.github.anglepengcoding.take_album_lib.R;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.config.SelectLimitType;
import com.luck.picture.lib.interfaces.OnSelectLimitTipsListener;
import com.luck.picture.lib.utils.ToastUtils;

/**
 * Created by 刘红鹏 on 2022/3/1.
 * <p>https://github.com/AnglePengCoding</p>
 * <p>https://blog.csdn.net/LIU_HONGPENG</p>
 */
public class MeOnSelectLimitTipsListener implements OnSelectLimitTipsListener {

    @Override
    public boolean onSelectLimitTips(Context context, PictureSelectionConfig config, int limitType) {
        if (limitType == SelectLimitType.SELECT_MAX_VIDEO_SELECT_LIMIT) {
            ToastUtils.showToast(context, "你最多只能选择%1$s个视频" + config.maxVideoSelectNum);
            return true;
        }
        return false;
    }
}
