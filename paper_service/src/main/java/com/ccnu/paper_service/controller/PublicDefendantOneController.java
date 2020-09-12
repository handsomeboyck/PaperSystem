package com.ccnu.paper_service.controller;

import com.ccnu.paper_service.model.entity.DefendantOne;
import com.ccnu.paper_service.model.request.DefendantOneList;
import com.ccnu.paper_service.model.response.DefendantOneResponse;
import com.ccnu.paper_service.service.DefendantOneService;
import com.ccnu.paper_service.utils.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Author: ck
 * @Description:
 * @Date: Create in 11:08 2020/8/3
 */
@RestController
@RequestMapping("/api/v1/pub/defendant_one")
public class PublicDefendantOneController {
    @Autowired
    private DefendantOneService defendantOneService;

    @RequestMapping("selectByPage")
    public JsonData selectByPage(@Param("page") Integer page)
    {
        DefendantOneResponse defendantOneResponse = new DefendantOneResponse();
        int countPage = defendantOneService.Count();
        defendantOneResponse.setCount(countPage);
        int start = defendantOneService.Count()-page*20>0?defendantOneService.Count()-page*20:0;
        int end = defendantOneService.Count()-(page-1)*20>0?defendantOneService.Count()-(page-1)*20:defendantOneService.Count();
        List<DefendantOne> defendantOneList = defendantOneService.selectByPage(start,end);
        Collections.reverse(defendantOneList);
        defendantOneResponse.setDefendantOneList(defendantOneList);

        return JsonData.buildSuccess(defendantOneResponse);
    }


    @RequestMapping("saveOneDefendant")
    public JsonData saveOneDefendant(@RequestBody DefendantOne defendantOne)
    {
        return JsonData.buildSuccess(defendantOneService.saveDefendant(defendantOne));


    }

    @RequestMapping("updateDefendant")
    public JsonData updateDefendant(@RequestBody DefendantOne defendantOne)
    {
        return JsonData.buildSuccess(defendantOneService.update(defendantOne));
    }

    @RequestMapping("deleteById")
    public JsonData deleteDefendentOne(@Param("id")Integer id)
    {
        return JsonData.buildSuccess(defendantOneService.deleteById(id));
    }

    @RequestMapping("findByName")
    public JsonData findByName(@Param("name") String name)
    {
        return JsonData.buildSuccess(defendantOneService.findByName(name));
    }
    @RequestMapping("postList")
    public JsonData testPost(@RequestBody DefendantOneList defendantOneList)
    {


        for(DefendantOne defendantOne:defendantOneList.getDefendantOneList())
        {
            System.out.println(defendantOne.getName());
        }
        return JsonData.buildSuccess();
    }




    @RequestMapping("download")
    public void download(@RequestBody DefendantOneList defendantOneList,HttpServletResponse response) throws IOException {

        for(DefendantOne defendantOne:defendantOneList.getDefendantOneList())
        {
            System.out.println(defendantOne.getName());
        }
        Map data = new HashMap<>();
        System.out.println("调用方法");

        data.put("defendantOneList",defendantOneList.getDefendantOneList());
        response.setHeader("content-Type", "application/msword");
        // 创建一个FreeMarker实例, 负责管理FreeMarker模板的Configuration实例
        Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        // 指定FreeMarker模板文件的位置
        cfg.setClassForTemplateLoading(getClass(), "/templates");
        Template template = null;


        try {
            template = cfg.getTemplate("defendantOne.ftl","UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }



        OutputStream outputStream = response.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);



        try {
            DownLoadFileUtil.setResponseHeader(response,"诉讼/单人.doc");
            template.process(data,outputStreamWriter);
//            System.out.println(outputStreamWriter);







        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @RequestMapping("zip")
    public void downloadZip(@RequestBody DefendantOneList defendantOneList,HttpServletResponse response)
    {
        List<File> files =new ArrayList<>();

        for(DefendantOne defendantOne:defendantOneList.getDefendantOneList())
        {
            Map data = new HashMap<>();
            DefendantOneList defendantOneList1 = new DefendantOneList();
            List<DefendantOne> defendantOnes  = new ArrayList<>();
            defendantOnes.add(defendantOne);
            defendantOneList1.setDefendantOneList(defendantOnes);
            data.put("defendantOneList",defendantOneList1.getDefendantOneList());
            String filePath = FileUtils.getWordPath();
            //文件唯一名称
            String fileOnlyName = System.currentTimeMillis()+".doc";
            /** 生成word  数据包装，模板名，文件生成路径，生成的文件名*/

            WordUtil.createWord(data, "defendantOne.ftl", filePath, fileOnlyName);
            File f = new File(filePath+File.separator+fileOnlyName);

            files.add(f);

        }


        //调用压缩
        String time = System.currentTimeMillis()+"";
        String zipFilePath = FileUtils.getWordPath()+File.separator+time+".zip";
        try {
            ZipUtil.create(zipFilePath,files);
            //下载文件
            File f = new File(zipFilePath);
            if(f.exists()){
               ZipUtil.downloadZip(f,response);
//                DownLoadFileUtil.setResponseHeader(response,zipFilePath);
            }else{
                System.out.println("文件不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(File file: files)
        {
            file.delete();
        }





    }

    @RequestMapping("/importExcel")
    public void importExcel(@RequestParam("file") MultipartFile file) throws Exception {
        //解析excel
        List<DefendantOne> defendantOnes = ExcelUtils.importExcel(file,0,1, DefendantOne.class);
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        System.out.println("导入数据一共【"+defendantOnes.size()+"】行");

        //TODO 保存数据库
        for (DefendantOne defendantOne:defendantOnes)
        {
            defendantOne.setLawyerId(1);
            defendantOneService.saveDefendant(defendantOne);
        }
    }
}
