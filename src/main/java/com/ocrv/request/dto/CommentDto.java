package com.ocrv.request.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ocrv.request.entity.Request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private Integer id;
    private String text;
    private RequestDto request;
    @JsonIgnore
    public RequestDto getRequest() {
        return request;
    }
}

