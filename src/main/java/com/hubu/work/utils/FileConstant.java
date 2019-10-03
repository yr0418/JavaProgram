package com.hubu.work.utils;

import org.springframework.stereotype.Component;

/**
 * @moduleName FileConstant
 * @description 文件保存的目录
 *
 * @author 杨睿
 */
@Component
public final class FileConstant {
  /**
   * 文件上传  根目录
   */
  public static final String UPLOAD_PATH = "D:/JavaProgram/File/";

  /**
   * 用户头像保存的目录
   */
  public static final String IMG_FILE_NAME = "usersImages";

  /**
   * 图片相对路径
   */
  public static final String VIRTUAL_IMG_PATH = "img/virtual";
}
