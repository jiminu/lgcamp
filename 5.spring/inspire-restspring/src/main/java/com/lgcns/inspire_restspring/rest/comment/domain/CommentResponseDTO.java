package com.lgcns.inspire_restspring.rest.comment.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class CommentResponseDTO {
    private int id;
    private String content;
    private int blog_id;
}
