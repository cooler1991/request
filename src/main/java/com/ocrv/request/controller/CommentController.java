package com.ocrv.request.controller;

import com.ocrv.request.dto.CommentDto;
import com.ocrv.request.dto.RequestDto;
import com.ocrv.request.entity.Comment;
import com.ocrv.request.services.CommentService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comment")
@AllArgsConstructor
@Log
@CrossOrigin
public class CommentController {
    private final CommentService commentService;

    /*@PutMapping("/add")
    //@ResponseStatus(HttpStatus.CREATED)
    public Comment add(@RequestParam("id") int id, @RequestBody Comment comment ) {
        return commentService.add(id, comment);
    }*/


    @GetMapping("/findAll")
    public List<CommentDto> getAllRequest() {
        log.info("Handling find all  comment");
        return commentService.find_All();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable("id") int id){
        log.info("Handling delete comment: " + id);
        commentService.delete(id);
    }

    @PostMapping("/add/{id}")
    //@ResponseStatus(HttpStatus.CREATED)
    public RequestDto add(@PathVariable("id") int id, @RequestBody CommentDto commentDto ) {
        log.info("Handling add comment: " + id);
        return commentService.add(id, commentDto);

    }

}

