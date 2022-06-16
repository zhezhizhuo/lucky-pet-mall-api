package com.lucky.pet.web.controller.common;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.lucky.pet.common.utils.file.MimeTypeUtils;
import com.lucky.pet.web.core.config.AsyncConfig;
import com.lucky.pet.web.core.upload.AlibabaOssUploadUtils;
import io.swagger.annotations.*;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.lucky.pet.common.config.LuckyPetConfig;
import com.lucky.pet.common.constant.Constants;
import com.lucky.pet.common.core.domain.AjaxResult;
import com.lucky.pet.common.utils.StringUtils;
import com.lucky.pet.common.utils.file.FileUploadUtils;
import com.lucky.pet.common.utils.file.FileUtils;
import com.lucky.pet.framework.config.ServerConfig;

/**
 * 通用请求处理
 *
 * @author qgj
 */
@RestController
@Api(tags = "通用请求处理 ")
@RequestMapping("/common")
public class CommonController {
    private static final Logger log = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private ServerConfig serverConfig;
    @Autowired
    AsyncConfig asyncConfig;


    private static final  String BaseUrl="https://luck-pet.oss-cn-guangzhou.aliyuncs.com/";


    private static final String FILE_DELIMETER = ",";

    /**
     * 通用下载请求
     *
     * @param fileName 文件名称
     * @param delete   是否删除
     */
    @GetMapping("/download")
    public void fileDownload(String fileName, Boolean delete, HttpServletResponse response, HttpServletRequest request) {
        try {
            if (!FileUtils.checkAllowDownload(fileName)) {
                throw new Exception(StringUtils.format("文件名称({})非法，不允许下载。 ", fileName));
            }
            String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("_") + 1);
            String filePath = LuckyPetConfig.getDownloadPath() + fileName;

            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            FileUtils.setAttachmentResponseHeader(response, realFileName);
            FileUtils.writeBytes(filePath, response.getOutputStream());
            if (delete) {
                FileUtils.deleteFile(filePath);
            }
        } catch (Exception e) {
            log.error("下载文件失败", e);
        }
    }

    /**
     *dada
     * 通用上传请求（单个）
     */
    @PostMapping("/upload")
    @ApiOperation(value = "文件上传 ")
   @ApiResponses({
           @ApiResponse(code = 200,message = "操作成功",response = AjaxResult.class)
   })
    public AjaxResult uploadFile(@ApiParam(name = "file",required=true) MultipartFile file) throws Exception {
        try {
            // 上传并返回新文件名称
            FileUploadUtils.assertAllowed(file, MimeTypeUtils.DEFAULT_ALLOWED_EXTENSION);
            String fileNewName = FileUploadUtils.extractFilename(file);

            //async loadUp File  Not Wait  up 100%  return
            asyncConfig.asyncLoadUpFile(fileNewName,file.getInputStream());
            // 上传文件

            AjaxResult ajax = AjaxResult.success();

            ajax.put("url", BaseUrl + fileNewName);
            ajax.put("fileName", fileNewName);
            ajax.put("newFileName", FileUtils.getName(fileNewName));
            ajax.put("originalFilename", file.getOriginalFilename());
            return ajax;
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());

        }
    }

    /**
     * 通用上传请求（多个）
     */
    @PostMapping("/uploads")
    public AjaxResult uploadFiles(List<MultipartFile> files) throws Exception {
        try {
            // 上传文件路径
            List<String> urls = new ArrayList<String>();
            List<String> fileNames = new ArrayList<String>();
            List<String> newFileNames = new ArrayList<String>();
            List<String> originalFilenames = new ArrayList<String>();
            for (MultipartFile file : files) {
                // 上传并返回新文件名称
                // 上传并返回新文件名称
                String fileNewName = FileUploadUtils.extractFilename(file);

                asyncConfig.asyncLoadUpFile(fileNewName,file.getInputStream());
                urls.add(BaseUrl+fileNewName);
                fileNames.add(fileNewName);
                newFileNames.add(FileUtils.getName(fileNewName));
                originalFilenames.add(file.getOriginalFilename());
            }
            AjaxResult ajax = AjaxResult.success();
            ajax.put("urls", StringUtils.join(urls, FILE_DELIMETER));
            ajax.put("fileNames", StringUtils.join(fileNames, FILE_DELIMETER));
            ajax.put("newFileNames", StringUtils.join(newFileNames, FILE_DELIMETER));
            ajax.put("originalFilenames", StringUtils.join(originalFilenames, FILE_DELIMETER));
            return ajax;
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 本地资源通用下载
     */
    @GetMapping("/download/resource")
    public void resourceDownload(String resource, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            if (!FileUtils.checkAllowDownload(resource)) {
                throw new Exception(StringUtils.format("资源文件({})非法，不允许下载。 ", resource));
            }
            // 本地资源路径
            String localPath = LuckyPetConfig.getProfile();
            // 数据库资源地址
            String downloadPath = localPath + StringUtils.substringAfter(resource, Constants.RESOURCE_PREFIX);
            // 下载名称
            String downloadName = StringUtils.substringAfterLast(downloadPath, "/");
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            FileUtils.setAttachmentResponseHeader(response, downloadName);
            FileUtils.writeBytes(downloadPath, response.getOutputStream());
        } catch (Exception e) {
            log.error("下载文件失败", e);
        }
    }
}
