package com.ihognqiqu.wsp.target.jianshu;

/**
 * Created by zhenguo on 12/16/17.
 */
public interface JSConstants {

    @Deprecated
    String JSCookies = "";

    /**
     * 搜索
     */
    String JSSearchURL = "http://www.jianshu.com/search/do?q=%s&type=note&page=%d&order_by=default";
    String JSSearchH5URL = "http://www.jianshu.com/search?q=%s&page=%d&type=note";

    /**
     * 评论
     */
    String JSCommentURL = "http://www.jianshu.com/notes/%d/comments";

    /**
     * 文章详情页面
     */
    String JSArticleURL = "http://www.jianshu.com/p/%s";

    /**
     * 登陆页面
     */
    String JSLoginURL = "https://www.jianshu.com/sign_in";

    /**
     * 测试评论地址
     */
    String JSDemoURL = "http://www.jianshu.com/p/18ebaa602c48";

}
