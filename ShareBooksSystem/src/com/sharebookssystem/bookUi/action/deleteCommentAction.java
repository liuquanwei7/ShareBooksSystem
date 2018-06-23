package com.sharebookssystem.bookUi.action;

import com.opensymphony.xwork2.ActionContext;
import com.sharebookssystem.bookUi.dao.CommentsDao;
import com.sharebookssystem.model.CommentItem;
import com.sharebookssystem.model.User;

import java.util.Map;

import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;

public class deleteCommentAction {
    CommentItem commentItem;
    CommentsDao commentsDao;
    int id;

    public CommentItem getCommentItem() {
        return commentItem;
    }

    public void setCommentItem(CommentItem commentItem) {
        this.commentItem = commentItem;
    }

    public CommentsDao getCommentsDao() {
        return commentsDao;
    }

    public void setCommentsDao(CommentsDao commentsDao) {
        this.commentsDao = commentsDao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String execute() throws Exception{
        if(commentsDao.deleteCommentsById(id)){
            return SUCCESS;
        }
        else {
            ActionContext ac=ActionContext.getContext();
            //	Map map=ActionContext.getContext().getSession();
            //得到Strust对HttpServletRequest对象进行了封装，封装为了一个Map
            //拿到表示request对象 的map
            Map<String, Object> request=ac.getContextMap();
            Map<String, Object> session=ac.getSession();
            session.put("succcessComment","删除失败");
            return INPUT;
        }

    }


}
