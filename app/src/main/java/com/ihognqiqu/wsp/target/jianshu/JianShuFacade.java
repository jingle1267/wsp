package com.ihognqiqu.wsp.target.jianshu;

import android.support.annotation.Nullable;
import android.util.Log;
import com.ihognqiqu.wsp.BuildConfig;
import com.ihognqiqu.wsp.component.Comment;
import com.ihognqiqu.wsp.component.CommentFacade;
import com.ihognqiqu.wsp.target.jianshu.entity.JSArticleEntity;
import java.util.List;

/**
 * Created by zhenguo on 12/16/17.
 */
public class JianShuFacade {

    @Nullable
    public List<JSArticleEntity> getArticles(String keywowrd, int page) {
        return new JSSearch().getArticles(keywowrd, page);
    }

    public boolean comment(JSArticleEntity jsArticleEntity, Comment comment) {
        return new JSComment().comment(jsArticleEntity, comment);
    }

    public void autoCommment(String keywowrd, int page) {
        List<JSArticleEntity> articleEntities = getArticles(keywowrd, page);
        if (articleEntities == null || articleEntities.size() == 0) {
            if (BuildConfig.DEBUG) Log.w("JianShuFacade", "未搜索到匹配文章！");
        }
        for (JSArticleEntity articleEntity : articleEntities) {
            comment(articleEntity, new CommentFacade().getComment());
            break;
        }
    }

}
