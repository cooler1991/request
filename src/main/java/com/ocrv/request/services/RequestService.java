package com.ocrv.request.services;

import com.ocrv.request.dto.CommentDto;
import com.ocrv.request.dto.RequestDto;
import com.ocrv.request.entity.Comment;
import com.ocrv.request.entity.Request;
import com.ocrv.request.exception.ValidationException;
import com.ocrv.request.repository.CommentRepository;
import com.ocrv.request.repository.RequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class RequestService {


    private final RequestRepository requestRepository;
    private final RequestConverter requestConverter;


  /*  public RequestDto save(RequestDto requestDto) {
        Request savedRequest = requestRepository.save( requestConverter.fromRequestDtoToRequest(requestDto));
        return requestConverter.fromRequestToRequestDto(savedRequest);

    }*/
    public RequestDto findById(int id) {
        Request request = requestRepository.findById(id);
        if (request!= null) {
            return requestConverter.fromRequestToRequestDto(request);
        }
            return null;
        }


    public List<RequestDto> findAll() {
        return requestRepository.findAll()
                .stream()
                .map(requestConverter::fromRequestToRequestDto)
                .collect(Collectors.toList());
    }

    public RequestDto create(RequestDto requestDto) throws  ValidationException{
        validateRequestDto(requestDto);
        //При создании всегда статус Новый
        requestDto.setStatus(StatusRequest.NEW.getDescribe());

 /*      if (requestDto.getComments() != null) {
           for (CommentDto comment : requestDto.getComments()) {
               comment.setRequest(requestConverter.fromRequestDtoToRequest(requestDto));
           }
       }*/
       Request saveRequest =  requestRepository.save(requestConverter.fromRequestDtoToRequest(requestDto)); ;
        return requestConverter.fromRequestToRequestDto(saveRequest);
    }

    public void delete(int id) {
        Request request = requestRepository.findById(id);

        if (request != null) {
            requestRepository.delete(request);
        }
    }


    private void validateRequestDto(RequestDto requestDto) throws ValidationException {
        if (isNull(requestDto)) {
            throw new ValidationException("Object request is null");
        }
        if (isNull(requestDto.getDescribe()) || requestDto.getDescribe().isEmpty()) {
            throw new ValidationException("Describe is empty");
        }
    }



//Обновить статус заявки
    public RequestDto update_status( int id, RequestDto requestDto ) {
        Request request = requestRepository.findById(id);

        if (request != null && request.getStatus() != StatusRequest.fromDesc(requestDto.getStatus())) {
            request.setStatus(StatusRequest.fromDesc(requestDto.getStatus()));
            Request savedRequest = requestRepository.save(request);
            return requestConverter.fromRequestToRequestDto(savedRequest);
        }
        return null;
    }


}
