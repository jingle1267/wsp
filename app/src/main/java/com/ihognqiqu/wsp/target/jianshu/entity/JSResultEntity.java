package com.ihognqiqu.wsp.target.jianshu.entity;

import com.ihognqiqu.wsp.target.jianshu.entity.JSArticleEntity;
import java.util.List;
import lombok.Data;

/**
 * Created by zhenguo on 12/16/17.
 */
@Data
public class JSResultEntity {


    /**
     * q : android 123
     * page : 1
     * type : note
     * total_count : 31074
     * per_page : 10
     * total_pages : 100
     * order_by : default
     * entries : [{"id":14415426,"title":"<em class='search-result-highlight'>Android<\/em> - 收藏集 - 掘金","slug":"5ad013eb5364","content":"\u2026\u2026值用数值<em class='search-result-highlight'>123<\/em>等代替）可以实现在无损压缩的情况下图片文件大小缩小到原来的30%... <em class='search-result-highlight'>Android<\/em> application 和 activity 标签详解 - 掘金Application 标签\u2026\u2026用两张图告诉你，为什么你的 App 会卡顿? - <em class='search-result-highlight'>Android<\/em> - 掘金Cover 有什么料？ 从这篇文章中你能获得这些料： 知道setContentView()之后发生了什么\u2026\u2026？ ... <em class='search-result-highlight'>Android<\/em> 获取 View 宽高的常用正确方式，避免为零 - 掘金相信有很多朋友都有过在 Activity 中通过 getWidth() 之类的方法获取 View 的宽高值，可能在 onCreate\u2026\u2026","user":{"id":120495,"nickname":"掘金官方","slug":"5fc9b6410f4f","avatar_url":"http://upload.jianshu.io/users/upload_avatars/120495/6220dd63-bf1a-40a8-8ccc-e364a5c90f13.png"},"notebook":{"id":12023435,"name":"精选文集推荐"},"commentable":true,"public_comments_count":6,"likes_count":442,"views_count":20668,"total_rewards_count":0,"first_shared_at":"2017-07-10T08:42:22.000Z"},{"id":18138619,"title":"<em class='search-result-highlight'>Android<\/em> - 收藏集  ","slug":"dad51f6c9c4d","content":"\u2026\u2026png文件的24位真彩色压缩为8位的索引演示，是一 种矢量压缩方法，把颜色值用数值<em class='search-result-highlight'>123<\/em>等代替）可以实现在无损压缩的情况下图片文件大小缩小到原来的30%... <em class='search-result-highlight'>Android<\/em> application\u2026\u2026用两张图告诉你，为什么你的 App 会卡顿? - <em class='search-result-highlight'>Android<\/em> - 掘金 Cover 有什么料？ 从这篇文章中你能获得这些料： 知道setContentView()之后发生了什么\u2026\u2026？ ... <em class='search-result-highlight'>Android<\/em> 获取 View 宽高的常用正确方式，避免为零 - 掘金 相信有很多朋友都有过在 Activity 中通过 getWidth() 之类的方法获取 View 的宽高值，可能在 onCreate\u2026\u2026","user":{"id":2169529,"nickname":"passiontim","slug":"e946d18f163c","avatar_url":"http://cdn2.jianshu.io/assets/default_avatar/4-3397163ecdb3855a0a4139c34a695885.jpg"},"notebook":{"id":7716297,"name":"java源码分析"},"commentable":true,"public_comments_count":0,"likes_count":85,"views_count":4961,"total_rewards_count":0,"first_shared_at":"2017-10-10T08:13:06.000Z"},{"id":2352681,"title":"<em class='search-result-highlight'>123<\/em> -- MeDraw #<em class='search-result-highlight'>Android<\/em>","slug":"179e9c360063","content":"\u2026\u2026，你把线条画在他们的身上他们也会做出反应，但是故意乱画看他们生气的样子才更有趣呀～点击顶部的水桶会清空画布，如果你实在画不出他们想要的，点击箭头可以换一个主题。 <em class='search-result-highlight'>Android<\/em> | 22M | 免费\u2026\u2026","user":{"id":402153,"nickname":"最美应用","slug":"df7f20ea7618","avatar_url":"http://upload.jianshu.io/users/upload_avatars/402153/45cdce40ff02"},"notebook":{"id":817075,"name":"最美应用"},"commentable":true,"public_comments_count":0,"likes_count":0,"views_count":82,"total_rewards_count":0,"first_shared_at":"2015-11-04T03:29:44.000Z"}]
     * more_related_users : true
     * related_collections : []
     * more_related_collections : false
     */

    private String q;
    private int page;
    private String type;
    private int total_count;
    private int per_page;
    private int total_pages;
    private String order_by;
    private boolean more_related_users;
    private boolean more_related_collections;
    private List<JSArticleEntity> entries;
    private List<?> related_collections;

}
