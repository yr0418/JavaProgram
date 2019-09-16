package com.hubu.work.utils;

import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.List;

public class PageBean<T> implements Serializable {
  private static final long serialVersionUID = -9202109574544652243L;

  private long total;        // 总行数
  private List<T> list;      // 存放需要显示的实体类数据
  private int pageNum;       // 当前页码数（默认给1）
  private int pageSize;      // 每页显示的行数
  private int pages;         // 总页数
  private int size;          // 当前页的数量 <= pageSize，该属性来自ArrayList的size属性

  public PageBean(List<T> list){
    if (list instanceof Page) {
      Page<T> page = (Page<T>) list;
      this.pageNum = page.getPageNum();
      this.pageSize = page.getPageSize();
      this.total = page.getTotal();
      this.pages = page.getPages();
      this.list = page;
      this.size = page.size();
    }
  }

  public long getTotal() {
    return total;
  }

  public void setTotal(long total) {
    this.total = total;
  }

  public List<T> getList() {
    return list;
  }

  public void setList(List<T> list) {
    this.list = list;
  }

  public int getPageNum() {
    return pageNum;
  }

  public void setPageNum(int pageNum) {
    this.pageNum = pageNum;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public int getPages() {
    return pages;
  }

  public void setPages(int pages) {
    this.pages = pages;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }
}
