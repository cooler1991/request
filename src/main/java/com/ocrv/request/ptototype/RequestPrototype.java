package com.ocrv.request.ptototype;

import com.ocrv.request.dto.CommentDto;
import com.ocrv.request.dto.RequestDto;
import com.ocrv.request.entity.Comment;
import com.ocrv.request.entity.Request;

import java.util.ArrayList;
import java.util.List;

public class RequestPrototype {

    public static Request aRequest(){
        Request r = new Request();
        r.setId(1);
        r.setDescribe("test_desc");
        Comment c = new Comment();
        c.setText("test_comment");
        List<Comment> list =  new ArrayList();
        list.add(c);
        r.setComments(list);
        return r;
    }

    public static RequestDto aRequestDto(){
        RequestDto r = new RequestDto();
        r.setId(1);
        r.setDescribe("test_desc");
        CommentDto c = new CommentDto();
        c.setText("test_comment");
        List<CommentDto> list =  new ArrayList();
        list.add(c);
        r.setComments(list);
        return r;

    }


}
