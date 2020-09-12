package com.ccnu.paper_service.utils;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

public class FileUtils {
    /**
     * 获取项目根路径
     *
     * @return
     */
    public static String getResourceBasePath() {
        // 获取跟目录
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            // nothing to do
        }
        if (path == null || !path.exists()) {
            path = new File("");
        }

        String pathStr = path.getAbsolutePath();
        // 如果是在eclipse中运行，则和target同级目录,如果是jar部署到服务器，则默认和jar包同级
        pathStr = pathStr.replace("\\target\\classes", "");

        return pathStr;
    }

    /**
     * 获取word存储路径
     */
    public static String getWordPath(){
       String path = getResourceBasePath()+File.separator+"words";
       File file = new File(path);
       if(!file.exists()){
           file.mkdirs();
       }
       return file.getAbsolutePath();
    }
}
