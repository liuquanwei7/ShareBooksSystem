package com.sharebookssystem.bookUi.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bookUi.dao.UserDao;
import com.sharebookssystem.bookUi.utils.MailUitls;
import com.sharebookssystem.model.User;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

public class userRegisterAction extends ActionSupport {
    User user;
    UserDao ud;
    List<User> users;
    public String userAge;
    public String checkPass;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDao getUd() {
        return ud;
    }

    public void setUd(UserDao ud) {
        this.ud = ud;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getCheckPass() {
        return checkPass;
    }

    public void setCheckPass(String checkPass) {
        this.checkPass = checkPass;
    }

    public  boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    //生成随机数字和字母,
//    public String getStringRandom(int length) {
//
//        String val = "";
//        Random random = new Random();
//
//        //参数length，表示生成几位随机数
//        for(int i = 0; i < length; i++) {
//
//            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
//            //输出字母还是数字
//            if( "char".equalsIgnoreCase(charOrNum) ) {
//                //输出是大写字母还是小写字母
//                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
//                val += (char)(random.nextInt(26) + temp);
//            } else if( "num".equalsIgnoreCase(charOrNum) ) {
//                val += String.valueOf(random.nextInt(10));
//            }
//        }
//        return val;
//    }


    public String execute() throws Exception{
        ActionContext ac=ActionContext.getContext();
        //	Map map=ActionContext.getContext().getSession();
        //得到Strust对HttpServletRequest对象进行了封装，封装为了一个Map
        //拿到表示request对象 的map
        Map<String, Object>  request=ac.getContextMap();
        Map<String, Object> session=ac.getSession();
        session.remove("userNameError");
        session.remove("userAccountError");
        session.remove("userPasswordError");
        session.remove("userIdentityError");
        session.remove("userGenderError");
        session.remove("userAgeError");
        session.remove("userEmailError");





        if(user.getUserName().length()>20){
//            this.addFieldError("user.userName","账号不能大于20位");
            session.put("userNameError","长度大于20位");
            return INPUT;
        }
        if(user.getUserName()==null||user.getUserName().equals("")){
            session.put("userNameError","必填项");
            return INPUT;
        }
        if(user.getUserAccount().equals("")||user.getUserAccount()==null){
            session.put("userAccountError","必填项");
            return INPUT;
        }
        if(user.getUserAccount().length()>10||user.getUserAccount().length()<6){
            session.put("userAccountError","长度非法");
            return INPUT;
        }
        if(user.getUserPassword().equals("")||user.getUserPassword()==null){
            session.put("userPasswordError","必填项");
            return INPUT;
        }
         if(user.getUserPassword().length()>10||user.getUserPassword().length()<6){
            session.put("userPasswordError","长度非法");
            return INPUT;
        }
         if(user.getUserIdentity().equals("")||user.getUserIdentity()==null){
            session.put("userIdentityError","必填项");
            return INPUT;
        }
         if(user.getUserIdentity().length()>20){
            session.put("userIdentityError","长度非法");
            return INPUT;
        }
        if(user.getUserEmail().equals("")||user.getUserEmail()==null){
            session.put("userEmailError","必填项");
            return INPUT;
        }
        if(user.getUserEmail().length()>20){
            session.put("userEmailError","长度非法");
            return INPUT;
        }
        if (user.getUserEmail().indexOf(".")==-1||user.getUserEmail().indexOf("@")==-1){
            session.put("userEmailError","邮箱不存在");
            return INPUT;
        }
         if(user.getUserGender().equals("")||user.getUserGender()==null||user.getUserGender().equals("hidden")){
            session.put("userGenderError","必填项");
            return INPUT;
        }


        System.out.println(userAge);
        System.out.println("22222222222222222222");
        if(isInteger(userAge)!=true){
            session.put("userAgeError","年龄非法");
            return INPUT;
        }
        int temp=Integer.parseInt(userAge);
        System.out.println(temp);
        if(temp<=0||temp>200){
            session.put("userAgeError","年龄非法");
            return INPUT;
        }
        String s=user.getUserGender().replace(",","");
        s=s.replace(" ","");

//        String s=user.getUserGender().substring(0,user.getUserGender().length()-1);

        user.setUserAge(temp);
        user.setUserPermission(2);
        user.setUserGender(s);
        System.out.println(user.getUserGender());
        if(ud.checkRegisterEmail(user)){
           System.out.println(user.getUserGender());

            return SUCCESS;
        }

//        session.put("code",code);
//        session.put("user",user);
//        // 发送激活邮件;
//        System.out.println("尝试发送");
//        MailUitls.sendMail(user.getUserEmail(),code);
        return INPUT;


    }
    //方法一：用JAVA自带的函数




    public void validate(){
//        session.remove("userNameError");

        System.out.println(userAge);
        System.out.println("22222222222222222222");
    }
}
