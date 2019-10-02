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

  public Date setTime(String time) throws ParseException {
    Date date = simpleDateFormat.parse(time);
    return date;
  }

  public Date getTime() throws ParseException {
    String time = simpleDateFormat.format(new Date());
    Date date = simpleDateFormat.parse(time);
    return date;
  }
}
