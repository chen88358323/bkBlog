package com.jelly.bkBlog.service;

import com.jelly.bkBlog.util.Const;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;

/**
 * Created by jelly on 2016-8-12.
 */
public class ExtractService {
    protected static final Logger log = LoggerFactory.getLogger(ExtractService.class);

    public static void initOutDir(){
        try {
            File dir = new File(Const.csdnBlogOutDir);
            if (dir.exists()) {
                FileUtils.deleteDirectory(dir);
            }

            FileUtils.forceMkdir(dir);
            FileUtils.forceMkdir(new File(Const.csdnBlogOutDir + "js"));
            FileUtils.forceMkdir(new File(Const.csdnBlogOutDir + "css"));
            FileUtils.forceMkdir(new File(Const.csdnBlogOutDir + "images"));
            FileUtils.forceMkdir(new File(Const.csdnBlogOutDir + "category"));
        }catch (Exception e){
            log.error("ExtractService error", e);
        }
    }

    public static void createCategoryDir(List<String> categoryNameList){
        try {
            for(String categoryName : categoryNameList){
                FileUtils.forceMkdir(new File(Const.csdnBlogOutDir + "category/" + categoryName));
            }
        }catch (Exception e){
            log.error("ExtractService error", e);
        }
    }
}
