package com.hubu.work.utils;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @moduleName DateUtil
 * @description 指定时间格式，实现date与String之间的转换
 *
 * @author 杨睿
 * @since 2019-10-02 13:36
 **/
@Component
public class DateUtil {
  private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

  /**
   * 将从数据库拿到的时间转换为标准形式
   * @param date 从数据库提取到的 date 数据
   * @return String，时间的标准表示形式
   */
  public String getTime(Date date){
    return simpleDateFormat.format(date);
  }
}
