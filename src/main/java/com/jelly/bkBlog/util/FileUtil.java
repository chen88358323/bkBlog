package com.jelly.bkBlog.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * Created by jelly on 2016-8-12.
 */
public class FileUtil {
    protected static final Logger log = LoggerFactory.getLogger(FileUtil.class);

    public static Properties loadPropertiesFromRootClassPath(String classPath){
        Properties properties = null;
        try{
            properties = new Properties();
            properties.load(Const.class.getResourceAsStream(classPath));
        }catch (Exception e){
            log.error("Const init error", e);
        }
        return properties;
    }
}
