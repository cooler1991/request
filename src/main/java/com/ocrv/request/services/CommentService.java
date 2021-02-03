package com.ocrv.request.services;


import com.ocrv.request.dto.CommentDto;
import com.ocrv.request.dto.RequestDto;
import com.ocrv.request.entity.Comment;
import com.ocrv.request.entity.Request;
import com.ocrv.request.repository.CommentRepository;
import com.ocrv.request.repository.RequestRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log
@Service
public class CommentService {


    @Autowired
    private final CommentRepository commentRepository;
    private final CommentConverter commentConverter;
    private final RequestConverter requestConverter;
    private final RequestRepository requestRepository;

    public CommentService(CommentRepository commentRepository, CommentConverter commentConverter, RequestConverter requestConverter, RequestRepository requestRepository) {
        this.commentRepository = commentRepository;
        this.commentConverter = commentConverter;
        this.requestConverter = requestConverter;
        this.requestRepository = requestRepository;
    }

 /*   public CommentDto save(CommentDto commentDto) {
        Comment savedComment = commentRepository.save( commentConverter.fromCommentDtoToComment(commentDto));
        return commentConverter.fromCommentToCommentDto(savedComment);
    }*/

    public List<CommentDto> find_All()
        {
            return commentRepository.findAll()
                    .stream()
                    .map(commentConverter::fromCommentToCommentDto)
                    .collect(Collectors.toList());
        }

    //Обновление комментария для заявка
    public RequestDto add(int id, CommentDto commentDto) {
        Request request = requestRepository.findById(id); //comment.getRequest();
        if (request != null) {
            Comment com = commentConverter.fromCommentDtoToComment(commentDto);
            com.setRequest(request);
            Comment savedComment = commentRepository.save(com);
            return  requestConverter.fromRequestToRequestDto(request);// commentConverter.fromCommentToCommentDto(savedComment);
        }
        return null;
    }

    public void delete(int id) {
        Comment comment  = commentRepository.findById(id);
        if (comment != null) {
            commentRepository.delete(comment);
        }
    }


}