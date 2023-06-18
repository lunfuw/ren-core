package com.ren.core.utils;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.ren.core.exception.BizException;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
public class FileUtil {

    public static String fileType(String fileUrl) {
        int i1 = fileUrl.lastIndexOf(".");
        String suffixName = fileUrl.substring(i1);
        String fileTypes = suffixName.substring(1);
        String fileSuffix = fileTypes.toLowerCase();
        switch (fileSuffix) {
            case "jpg":
            case "png":
            case "jpeg":
            case "gif":
            case "bmp":
                return "image";
            case "mp4":
            case "3gp":
            case "mov":
            case "svg":
            case "m4v":
            case "avi":
            case "mkv":
            case "wmv":
            case "mpeg":
                return "video";
            case "doc":
            case "docx":
                return "docx";
            case "xlsx":
            case "xls":
                return "xlsx";
            case "pdf":
                return "pdf";
            default:
                log.debug("文件类型不正确");
                throw new BizException("文件类型不正确");
        }
    }

    /**
     * 获取文件后缀名
     *
     * @param fullName 文件全名
     * @return {String}
     */
    public static String getFileExtension(String fullName) {
        if (StrUtil.isBlank(fullName)) {
            return StringPool.EMPTY;
        }
        String fileName = new File(fullName).getName();
        int dotIndex = fileName.lastIndexOf(StringPool.DOT);
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

}