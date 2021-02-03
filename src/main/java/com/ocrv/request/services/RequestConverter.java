package com.ocrv.request.services;

import com.ocrv.request.dto.CommentDto;
import com.ocrv.request.dto.RequestDto;
import com.ocrv.request.entity.Comment;
import com.ocrv.request.entity.Request;
import com.ocrv.request.exception.ValidationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RequestConverter {


    public Request fromRequestDtoToRequest(RequestDto requestDto) {
        CommentConverter conv = new CommentConverter();
        List<Comment> list = new ArrayList();
        Request request = new Request();

        request.setId(requestDto.getId());
        request.setDescribe(requestDto.getDescribe());
        request.setStatus( StatusRequest.fromDesc( requestDto.getStatus()));

      if (requestDto.getComments()   != null ) {
            request.setComments(requestDto.getComments()
                .stream()
                .map(conv::fromCommentDtoToComment)
                .collect(Collectors.toList())); }

   /*if (requestDto.getComments()   != null ) {
            for (CommentDto comment : requestDto.getComments()) {
                list.add(conv.fromCommentDtoToComment(comment));
            }
            request.setComments(list);
        }*/
    return request;
}

    public RequestDto fromRequestToRequestDto(Request request) {
        CommentConverter conv = new CommentConverter();
        List<CommentDto> list = new ArrayList();
        RequestDto requestDto = new RequestDto();

        requestDto.setId(request.getId());
        requestDto.setDescribe(request.getDescribe());
        requestDto.setStatus(StatusRequest.fromName(request.getStatus()) );
        if (request.getComments() != null){
            requestDto.setComments(request.getComments()
                .stream()
                .map(conv::fromCommentToCommentDto)
                .collect(Collectors.toList()));
        }
      /*  if (request.getComments() != null) {
            for (Comment comment : request.getComments()) {
                list.add(conv.fromCommentToCommentDto(comment));
            }
            requestDto.setComments(list);
        }*/
        return requestDto;
    }


}
