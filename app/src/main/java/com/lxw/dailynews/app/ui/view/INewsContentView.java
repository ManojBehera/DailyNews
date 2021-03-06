package com.lxw.dailynews.app.ui.view;

import com.lxw.dailynews.app.bean.NewsContentBean;
import com.lxw.dailynews.app.bean.NewsStoryExtraBean;
import com.lxw.dailynews.framework.base.BaseMvpView;

/**
 * Created by Zion on 2016/11/12.
 */

public interface INewsContentView extends BaseMvpView {
    void setNewContent(NewsContentBean newsContentBean);
    void setNewsStoryExtraBean(NewsStoryExtraBean newsStoryExtraBean);
    void getNewsContent(String newsId);
    void getNewsStoryExtra(String newsId);

}
