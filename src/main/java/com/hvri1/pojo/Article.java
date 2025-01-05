package com.hvri1.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class Article {

    //文章id
    private Integer articleId;

    //文章标题
    private String articleTitle;

    //文章内容
    private String articleContent;

    //文章浏览次数
    private Integer articleViewCount;

    //文章点赞次数
    private Integer articleGoodclickCount;

    //文章收藏次数
    private Integer articleCollectCount;

    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime articleCreatetime;

    //更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime articleUpdatetime;
}
