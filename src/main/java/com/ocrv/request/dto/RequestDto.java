package com.ocrv.request.dto;

import com.ocrv.request.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {
    private Integer id;
    private String  describe;
    private String  status;

    private List<CommentDto> comments;


}
