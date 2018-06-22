package com.sharebookssystem.bookUi.action;

import com.opensymphony.xwork2.ActionContext;
import com.sharebookssystem.bookUi.dao.CommentsDao;
import com.sharebookssystem.model.CommentItem;
import com.sharebookssystem.model.User;

import java.util.Map;

import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;

public class CommentPostAction {
    CommentItem commentItem;
    CommentsDao commentsDao;

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
    public String execute() throws Exception{
        ActionContext ac=ActionContext.getContext();
        //	Map map=ActionContext.getContext().getSession();
        //得到Strust对HttpServletRequest对象进行了封装，封装为了一个Map
        //拿到表示request对象 的map
        Map<String, Object> request=ac.getContextMap();
        Map<String, Object> session=ac.getSession();
        if(commentsDao.insertComments(commentItem)>0){
            session.put("succcessComment","成功评论");

            return SUCCESS;
        }
        else{
            session.put("succcessComment","评论失败");
            return INPUT;
        }

    }

}
