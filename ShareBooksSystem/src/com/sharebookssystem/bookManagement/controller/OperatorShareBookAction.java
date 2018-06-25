package com.sharebookssystem.bookManagement.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bookManagement.service.impl.BookManagementServiceImpl;
import com.sharebookssystem.model.PersonalBook;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 分享图书
 * 2018/6/24
 */


public class OperatorShareBookAction extends ActionSupport {
    private int shareCode;
    private BookManagementServiceImpl service;
    private List<PersonalBook> personalBookList = new ArrayList<>();
    private Date uploadDate;

    public OperatorShareBookAction(){

    }

    public int getShareCode() {
        return shareCode;
    }

    public void setShareCode(int shareCode) {
        this.shareCode = shareCode;
    }

    public BookManagementServiceImpl getService() {
        return service;
    }

    public void setService(BookManagementServiceImpl service) {
        this.service = service;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String operatorShareBook(){
        personalBookList = service.queryPersonalBookByShareCode(shareCode);
        Map m = ActionContext.getContext().getSession();
        if(personalBookList==null||personalBookList.size()==0){ //数据不存在
            m.put("operatorShareBookError","分享码不存在,请确认后再重新输入");
            return INPUT;
        }else if(personalBookList.get(0).getBookStatus().trim().equals("申请分享")){
            try{
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                String nowDate = df.format(new Date());
                uploadDate = df.parse(nowDate); //上传日期
                personalBookList.get(0).setUploadDate(uploadDate);
                personalBookList.get(0).setBookStatus("在库");
                if(service.updatePersonalBook(personalBookList.get(0))){
                    return SUCCESS;
                }else {
                    m.put("operatorShareBookError","分享失败");
                    return INPUT;
                }
            }catch (Exception e){
                e.printStackTrace();
                m.put("operatorShareBookError","分享失败");
                return INPUT;
            }

        }else{  //书籍状态错误
            m.put("operatorShareBookError","分享失败,该分享码已过期");
            return INPUT;
        }
    }

    public void validateOperatorShareBook(){
        Map m = ActionContext.getContext().getSession();
        if(shareCode<1){
            m.put("operatorShareBookError","分享码不能为空");
            this.addFieldError("managerError","addErrorMessage");
        }
    }

}
