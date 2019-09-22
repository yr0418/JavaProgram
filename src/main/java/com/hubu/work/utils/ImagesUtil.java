package com.hubu.work.utils;

import com.hubu.work.mybatis.mapper.UserInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
/**
 * 应用模块名称: ImagesUtil
 * 代码描述:图片保存到本地具体方法
 * @author：杨睿
 */
@Component
public class ImagesUtil {
  @Autowired
  UserInfoMapper userInfoMapper;

  private static final Logger logger = LoggerFactory.getLogger(ImagesUtil.class);
  /**
   * 文件上传的根目录
   */
  private static final String IMAGES_PATH = FileConstant.UPLOAD_PATH + FileConstant.IMG_FILE_NAME;

  /**
   * 保存图片到本地
   * @param file：要保存的图片
   * @param username：用户名，用以重写文件名
   * @return String，返回保存文件的相对路径：filePath
   */
  public String saveImage(MultipartFile file, String username) {
    //重写上传的图片的图片名，文件名改为用户名
    String saveName = username + "." + getFileSuffix(file.getOriginalFilename());
    try {
      File targetFile = new File(IMAGES_PATH);
      //如果该文件夹不存在，则新建
      if (!targetFile.exists()) {
        targetFile.mkdirs();
      } else {
        /**
         * 删除用户历史头像
         */
        String userImgSuffix = getFileSuffix(userInfoMapper.findUserImg(username));
        File file1 = new File(IMAGES_PATH + "/" + username + "." + userImgSuffix);
        if (file1.exists() || file1.isFile()) {
          file1.delete();
        }
      }
      //保存图片
      file.transferTo(new File(IMAGES_PATH + "/" + saveName));
    } catch (IOException e) {
      e.printStackTrace();
      logger.debug("--- 图片保存异常：{} ---" + e.getMessage());
      return null;
    }
    //返回文件相对路径
    String filePath = FileConstant.VIRTUAL_IMG_PATH + "/" + saveName;
    return filePath;
  }

  /**
   * 返回截取的文件后缀
   * @param path
   * @return
   */
  private static String getFileSuffix(String path) {
    String index=".";
    String suffix = "jpg";
    if (path != null && path.indexOf(index) > 0) {
      suffix = path.substring(path.lastIndexOf(".") + 1);
    }
    return suffix;
  }

}
