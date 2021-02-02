package com.ocrv.request.controller;

import com.ocrv.request.dto.CommentDto;
import com.ocrv.request.entity.Comment;
import com.ocrv.request.services.CommentService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/comment")
@AllArgsConstructor
@Log
@CrossOrigin
public class CommentController {
    private final CommentService commentService;
    /*
    @PostMapping("/save")
    public CommentDto save(@RequestBody CommentDto commentDto)  {
        log.info("Handling save comment: " + commentDto);
       return  commentService.save(commentDto);
    }
    @PutMapping("/add")
    //@ResponseStatus(HttpStatus.CREATED)
    public Comment add(@RequestParam("id") int id, @RequestBody Comment comment ) {
        return commentService.add(id, comment);

    }*/
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRequest(@PathVariable("id") int id){
        commentService.delete(id);
    }

    @PostMapping("/add/{id}")
    //@ResponseStatus(HttpStatus.CREATED)
    public CommentDto add(@PathVariable("id") int id, @RequestBody CommentDto commentDto ) {
        return commentService.add(id, commentDto);

    }

}

