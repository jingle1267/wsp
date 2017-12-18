package com.ihognqiqu.wsp.component;

/**
 * Created by zhenguo on 12/16/17.
 */
public class CommentFacade {

    public Comment getComment() {
        Comment comment = new Comment();
        comment.setCommentContent("爱红旗渠不知道是否是沙发");
        return comment;
    }

    private Comment getLaughComment() {
        Comment comment = new Comment();
        comment.setCommentContent("爱红旗渠想收藏，可是手机内存不足， (⊙﹏⊙)b");
        return comment;
    }

}
