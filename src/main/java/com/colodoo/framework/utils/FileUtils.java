package com.colodoo.framework.utils;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author colodoo
 * @date 2017/08/14 21:50
 * @description 文件上传下载和其他操作
 */
public class FileUtils {

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + "/" + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

}
