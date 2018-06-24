package com.sharebookssystem.bookUi.action;

import com.opensymphony.xwork2.ActionContext;
import com.sharebookssystem.bookUi.dao.CommentsDao;
import com.sharebookssystem.bookUi.dao.UserDao;
import com.sharebookssystem.model.CommentItem;
import com.sharebookssystem.model.User;

import javax.xml.stream.events.Comment;
import java.util.List;
import java.util.Map;

import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;

public class showCommentsAction {
    CommentItem commentItem;
    List<CommentItem> commentItems;
    CommentsDao cd;
    User user;
    UserDao ud;
    List<User> users;
    int userid;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public CommentItem getCommentItem() {
        return commentItem;
    }

    public void setCommentItem(CommentItem commentItem) {
        this.commentItem = commentItem;
    }

    public List<CommentItem> getCommentItems() {
        return commentItems;
    }

    public void setCommentItems(List<CommentItem> commentItems) {
        this.commentItems = commentItems;
    }

    public CommentsDao getCd() {
        return cd;
    }

    public void setCd(CommentsDao cd) {
        this.cd = cd;
    }

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

    public String execute() throws Exception{
        ActionContext ac=ActionContext.getContext();
        //	Map map=ActionContext.getContext().getSession();
        //得到Strust对HttpServletRequest对象进行了封装，封装为了一个Map
        //拿到表示request对象 的map
        Map<String, Object> request=ac.getContextMap();
        Map<String, Object> session=ac.getSession();
        commentItems=cd.queryComments(commentItem);
        if(commentItems==null){
            session.put("succcessComment","没有评论");
            return INPUT;
        }
        commentItems=(List<CommentItem>)session.get("allComments");
//        System.out.println("UserName:"+commentItems.get(0).getReview());

        if(ud.queryUsersById(user)==null){
            session.put("succcessComment","没有评论");
            return INPUT;
        }
        users=(List<User>)session.get("CommentUsername");
        user=(User) session.get("user");
        userid=user.getUserId();
        session.put("userid",userid);

        return SUCCESS;

    }
}
