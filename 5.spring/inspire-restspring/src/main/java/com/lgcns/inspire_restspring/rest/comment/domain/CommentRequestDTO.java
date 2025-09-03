package com.lgcns.inspire_restspring.rest.comment.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
@Getter
public class CommentRequestDTO {
    private int id;
    private String content;
    private int blog_id;
}
