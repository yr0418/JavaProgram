package com.hubu.work.utils;

import com.hubu.work.mybatis.mapper.UserDetailInfoMapper;
import com.hubu.work.mybatis.pojo.UserDetailInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Component
public class ImagesUtil {
  @Autowired
  UserDetailInfoMapper userDetailInfoMapper;

  private static final Logger logger = LoggerFactory.getLogger(ImagesUtil.class);
  //文件上传的根目录
  private static final String imagesPath=FileConstant.UPLOAD_PATH+FileConstant.IMG_FILE_NAME;

  public String saveImage(MultipartFile file, String username){
    //重写上传的图片的图片名，文件名改为用户名
    String saveName=username+"."+getFileSuffix(file.getOriginalFilename());
    try{
      File targetFile=new File(imagesPath);
      //如果该文件夹不存在，则新建
      if (!targetFile.exists()){
        targetFile.mkdirs();
      }else {
        /**
         * 删除用户历史头像
         */
        String userImgSuffix=getFileSuffix(userDetailInfoMapper.findUserImg(username));
        File file1=new File(imagesPath+"/"+username+"."+userImgSuffix);
        if (file1.exists()|| file1.isFile()){
          file1.delete();
        }
      }
      //保存图片
      file.transferTo(new File(imagesPath+"/"+saveName));
    } catch (IOException e) {
      e.printStackTrace();
      logger.debug("--- 图片保存异常：{} ---" + e.getMessage());
      return null;
    }
    //返回文件相对路径
    String filePath=FileConstant.VIRTUAL_IMG_PATH+"/"+saveName;
    return filePath;
  }

  /**
   * 返回截取的文件后缀
   * @param path
   * @return
   */
  private static String getFileSuffix(String path) {
    String suffix="jpg";
    if (path != null && path.indexOf(".") > 0) {
       suffix = path.substring(path.lastIndexOf(".") + 1);
    }
    return suffix;
  }

}
