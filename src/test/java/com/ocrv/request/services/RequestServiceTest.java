package com.ocrv.request.services;


import com.ocrv.request.dto.RequestDto;
import com.ocrv.request.entity.Request;
import com.ocrv.request.exception.ValidationException;
import com.ocrv.request.repository.RequestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static com.ocrv.request.ptototype.RequestPrototype.aRequest;
import static com.ocrv.request.ptototype.RequestPrototype.aRequestDto;
class RequestServiceTest {

    private RequestService requestService;
    private  RequestRepository requestRepository;
    private  RequestConverter requestConverter;
    private  Request request;

    @BeforeEach
    void setUp(){
        requestRepository = mock(RequestRepository.class);
        requestConverter = new RequestConverter();
        request = Request.builder().describe("test_d").id(1).build();
        when(requestRepository.save(any())).thenReturn(request);
        requestService = new RequestService( requestRepository, requestConverter );


    }
    @Test
    void createRequest() throws ValidationException {
        RequestDto requestDto = RequestDto.builder().describe("test_d").build();
        RequestDto savedRequestDto = requestService.create(requestDto);
        assertThat(savedRequestDto).isNotNull();
        assertThat(savedRequestDto.getDescribe()).isEqualTo("test_d");
        System.out.println(savedRequestDto.getStatus());


    }
    @Test
    void saveRequestThrowsValidationExceptionWhenDescribeIsNull() {
        RequestDto requestDto = RequestDto.builder().build();
        requestDto.setDescribe("");
        assertThrows(ValidationException.class,
                () -> requestService.create(requestDto),
                "Describe is empty");
    }


 /* @Test
    void createRequest() throws ValidationException {
        when(requestRepository.save(any())).thenReturn((aRequest()));
        RequestDto createdRequest = requestService.create(aRequestDto());
        assertThat(createdRequest).isNotNull();
        assertThat(createdRequest.getDescribe()).isEqualTo(aRequestDto().getDescribe());
    }*/

}