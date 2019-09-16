package com.hubu.work.utils;

import org.springframework.stereotype.Component;

//保存文件目录
@Component
public class FileConstant {
  /** 文件上传/图片   根目录 */
  public static final String UPLOAD_PATH = "D:/JavaProgram/File/";

  /** 图片目录 */
  public static final String IMG_FILE_NAME = "usersImages";

  /** 图片相对路径 */
  public static final String VIRTUAL_IMG_PATH = "img/virtual";
}
