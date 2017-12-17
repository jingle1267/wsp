package com.ihognqiqu.wsp.target.jianshu.entity;

import lombok.Data;

/**
 * Created by zhenguo on 12/16/17.
 */
@Data
public class JSArticleEntity {


    /**
     * id : 4365624
     * title : adb shell 命令
     * slug : 7af2699d6462
     * content : ……adb shell dir 就是列举目录，在Linux中根目录为/而不是Windows上的C盘、D盘。 2.安装apk程序到模拟器则执行adb install <em class='search-result-highlight'>android123</em>.apk，这样……名为<em class='search-result-highlight'>android123</em>的安装包就会安装到Android模拟器中，前提是<em class='search-result-highlight'>android123</em>.apk文件需要放到SDK/Tools目录下。 3.向emulator传送文件， 使用adb…… push <em class='search-result-highlight'>android123</em>.txt /tmp/<em class='search-result-highlight'>android123</em>.txt命令可以把SDK/Tools下的<em class='search-result-highlight'>android123</em>.txt文件传输到模拟器的/tmp/文件夹中，需要注意的是/tmp/文件夹中……
     * user : {"id":1351616,"nickname":"proud2008","slug":"13c1a60fb023","avatar_url":"http://upload.jianshu.io/users/upload_avatars/1351616/4e788db48522.jpg"}
     * notebook : {"id":2830699,"name":"Android"}
     * commentable : true
     * public_comments_count : 0
     * likes_count : 0
     * views_count : 70
     * total_rewards_count : 0
     * first_shared_at : 2016-06-14T07:09:46.000Z
     */

    private int id;
    private String title;
    private String slug;
    private String content;
    private UserEntity user;
    private NotebookEntity notebook;
    private boolean commentable;
    private int public_comments_count;
    private int likes_count;
    private int views_count;
    private int total_rewards_count;
    private String first_shared_at;

    @Data
    public class UserEntity {
        /**
         * id : 1351616
         * nickname : proud2008
         * slug : 13c1a60fb023
         * avatar_url : http://upload.jianshu.io/users/upload_avatars/1351616/4e788db48522.jpg
         */

        private int id;
        private String nickname;
        private String slug;
        private String avatar_url;

    }

    @Data
    public class NotebookEntity {
        /**
         * id : 2830699
         * name : Android
         */

        private int id;
        private String name;

    }
}
