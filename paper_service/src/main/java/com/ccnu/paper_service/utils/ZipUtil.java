package com.ccnu.paper_service.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * zip工具类
 */
public class ZipUtil {

    public static void create(String path,List<File> files) throws Exception{
        ZipOutputStream zipOut=new ZipOutputStream(new FileOutputStream(new File(path)));
        byte [] buffer=new byte[1024];
        int len=-1;
        for(int i=0;i<files.size();i++){
            FileInputStream in=new FileInputStream(files.get(i));
            zipOut.putNextEntry(new ZipEntry(files.get(i).getName()));
            while((len=in.read(buffer))!=-1){
                zipOut.write(buffer, 0, len);
            }
            zipOut.closeEntry();
            in.close();
        }
        zipOut.close();
        System.out.println("文件已经压缩成zip了"+path);
    }

    /**
     * 下载打包的文件
     *
     * @param file
     * @param response
     */
    public static void downloadZip(File file, HttpServletResponse response) {
        try {
            // 以流的形式下载文件。
            BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file.getPath()));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type");
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(file.getName().getBytes("UTF-8"),"ISO-8859-1"));
            toClient.write(buffer);
            toClient.flush();
            toClient.close();


                file.delete();        //是否将生成的服务器端文件删除

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    }


