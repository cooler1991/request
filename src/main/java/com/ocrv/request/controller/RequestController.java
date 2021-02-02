package com.ocrv.request.controller;

import com.ocrv.request.dto.CommentDto;
import com.ocrv.request.dto.RequestDto;
import com.ocrv.request.entity.Request;
import com.ocrv.request.exception.ValidationException;
import com.ocrv.request.repository.RequestRepository;
import com.ocrv.request.services.RequestService;
import com.ocrv.request.services.StatusRequest;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/request")
@AllArgsConstructor
@Log
@CrossOrigin
public class RequestController {
    private final RequestService requestService;
  /*  @PostMapping("/save")
    public RequestDto saveRequest(@RequestBody RequestDto requestDto)   {
        log.info("Handling save request: " + requestDto);
       return requestService.save(requestDto);
    }*/

    @GetMapping("/findAll")
    public List<RequestDto> getAllRequest() {
        log.info("Handling find all  request");
        return requestService.findAll();
    }
    @GetMapping("/getListStatus")
    public List<String> getAllList() {
        log.info("Handling listStatus");
        return StatusRequest.getListStatus();
    }

    @GetMapping("/findById/{id}")
    public RequestDto findByLogin(@PathVariable  Integer id) {
        log.info("Handling find by id  : " + id);
        return requestService.findById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public RequestDto createRequest(@RequestBody RequestDto requestDto ) throws ValidationException {
        return requestService.create(requestDto);
    }
   /*
    @PostMapping("/create1")
    @ResponseStatus(HttpStatus.CREATED)
    public Request createCountry(@RequestBody Request request) {
        return requestService.create1(request);
    }
*/

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRequest(@PathVariable("id") int id){
        requestService.delete(id);
    }

    @PutMapping("/update_status/{id}")
    public RequestDto updateStatus(@PathVariable("id") int id, @RequestBody RequestDto requestDto )
    {
     return requestService.update_status(id,requestDto);
    }



}
