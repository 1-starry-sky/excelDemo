package com.example.common.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Result<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int returnCode = 0;
	private String description = "OK";
	private T result;
	
	public Result(){}
	public Result(int returnCode, String description) {
		this.returnCode = returnCode;
		this.description = description;
	}
	
	public Result(int returnCode, String description, T result) {
		this.returnCode = returnCode;
		this.description = description;
		this.result = result;
	}
	
	public int getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullStringAsEmpty);
	}

    /**
     * 分页
     *
     * @version 1.0 2010-12-07
     * @author wuyy
     */
    public static final class Page implements Serializable {
        public long totalRecord = 0;           //总记录数
        public long pageSize = 10;             //每页显示主题数
        public long pageCount = 0;             //总页数
        public long currentPage = 1;           //当前页
        public List<Map<String,Object>> result = null; //结果

        public Page(long totalRecord, long pageSize, long pageCount, long currentPage, List<Map<String, Object>> result) {
            this.totalRecord = totalRecord;
            this.pageSize = pageSize;
            this.pageCount = pageCount;
            this.currentPage = currentPage;
            this.result = result;
        }



        @Override
        public String toString() {
            return "Page [totalRecord=" + totalRecord + ", pageSize=" + pageSize + ", pageCount=" + pageCount
                    + ", currentPage=" + currentPage+ ", result=" + result + "]";
        }

    }
}
