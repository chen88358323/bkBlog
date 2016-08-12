package com.jelly.bkBlog.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * Created by jelly on 2016-8-12.
 */
public class Const {
    protected static final Logger log = LoggerFactory.getLogger(Const.class);

    public static final String LineSeparator = System.getProperty("line.separator", "\n");

    public static String csdnBlogIndex;
    public static String csdnBlogOutDir;

    static {
        Properties properties = FileUtil.loadPropertiesFromRootClassPath("/config.properties");
        csdnBlogIndex = properties.getProperty("csdn.blog.index");
        csdnBlogOutDir = properties.getProperty("csdn.blog.out.dir");

        if(!StringUtils.endsWith(csdnBlogOutDir, "/")){
            csdnBlogOutDir += "/";
        }

        if(log.isDebugEnabled()){
            log.debug("init const");
            log.debug("init const, csdnBlogIndex={}", csdnBlogIndex);
            log.debug("init const, csdnBlogOutDir={}", csdnBlogOutDir);
        }
    }
}
