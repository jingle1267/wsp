package com.ihognqiqu.wsp.target.jianshu.entity;

import java.util.List;
import lombok.Data;

/**
 * Created by zhenguo on 12/16/17.
 */
@Data
public class JSCommentResultEntity {


    /**
     * id : 18576546
     * compiled_content : 2L
     * floor : 3
     * note_id : 4365624
     * user_id : 670317
     * created_at : 2017-12-16T14:28:51.000+08:00
     * user : {"id":670317,"slug":"f86a5836bb07","nickname":"爱红旗渠","avatar":"http://upload.jianshu.io/users/upload_avatars/670317/f7a4d4d8290d.jpg","is_author":false,"badge":null}
     * liked : false
     * likes_count : 0
     * children_count : 0
     * children : []
     */

    private int id;
    private String compiled_content;
    private int floor;
    private int note_id;
    private int user_id;
    private String created_at;
    private UserEntity user;
    private boolean liked;
    private int likes_count;
    private int children_count;
    private List<?> children;

    @Data
    public class UserEntity {
        /**
         * id : 670317
         * slug : f86a5836bb07
         * nickname : 爱红旗渠
         * avatar : http://upload.jianshu.io/users/upload_avatars/670317/f7a4d4d8290d.jpg
         * is_author : false
         * badge : null
         */

        private int id;
        private String slug;
        private String nickname;
        private String avatar;
        private boolean is_author;
        private Object badge;

    }
}
