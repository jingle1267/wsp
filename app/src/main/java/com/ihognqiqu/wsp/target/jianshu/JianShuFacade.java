package com.ihognqiqu.wsp.target.jianshu;

import android.support.annotation.Nullable;
import android.util.Log;
import com.ihognqiqu.wsp.component.Comment;
import com.ihognqiqu.wsp.component.CommentFacade;
import com.ihognqiqu.wsp.target.jianshu.entity.JSArticleEntity;
import java.util.List;
import java.util.Random;

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

    /**
     * 自动评论
     *
     * @param keywowrd  关键字
     * @param pageTotal 总页数
     */
    public void autoCommment(String keywowrd, int pageTotal) {

        int totalCount = 0;
        int successCount = 0;
        for (int i = 1; i <= pageTotal; i++) {
            int page = i;
            String msg;
            List<JSArticleEntity> articleEntities = getArticles(keywowrd, page);
            if (articleEntities == null || articleEntities.size() == 0) {
                msg = "关于" + keywowrd + " 的第" + page + "页无数据";
                Log.d("JianShuFacade", msg);
                continue;
            }
            for (JSArticleEntity articleEntity : articleEntities) {
                totalCount++;
                boolean isSuccess = comment(articleEntity, new CommentFacade().getComment());
                if (isSuccess) {
                    successCount++;
                }
                try {
                    long sleepSecond = new Random().nextInt(8000);
                    Thread.sleep(2000 + sleepSecond);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            msg = "关于" + keywowrd + " 的第" + page + "页评论成功";
            Log.d("JianShuFacade", msg);
        }

        String msg = "successCount/totalCount : " + successCount + "/" + totalCount + "  " + (successCount * 100 / totalCount) + "%";
        Log.d("JianShuFacade", msg);

    }

}
