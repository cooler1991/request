package com.ocrv.request.services;

import com.ocrv.request.dto.CommentDto;
import com.ocrv.request.dto.RequestDto;
import com.ocrv.request.entity.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter {

    public Comment fromCommentDtoToComment(CommentDto commentDto)  {
        RequestConverter conv = new RequestConverter();

        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setText(commentDto.getText() );
        comment.setRequest(conv.fromRequestDtoToRequest(commentDto.getRequest()));
        return comment;
    }

    public CommentDto fromCommentToCommentDto(Comment comment) {
       RequestConverter  conv = new RequestConverter();
        return CommentDto.builder()
                .id(comment.getId())
                .text(comment.getText())
                .request(conv.fromRequestToRequestDto(comment.getRequest()))
                .build();

    }


}