package com.jelly.bkBlog;

import com.jelly.bkBlog.service.ExtractService;
import com.jelly.bkBlog.util.Const;
import com.jelly.bkBlog.util.HttpUtil;

/**
 * Created by jelly on 2016-8-12.
 */
public class CliMain {
    public static void main(String[] args) {
        ExtractService.initOutDir();

        String indexContent = HttpUtil.getContent(Const.csdnBlogIndex, HttpUtil.GET, 6000);
        System.out.println(indexContent);
    }
}
