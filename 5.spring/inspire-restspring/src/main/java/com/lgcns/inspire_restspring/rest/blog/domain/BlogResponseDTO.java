package com.lgcns.inspire_restspring.rest.blog.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class BlogResponseDTO {
    private String title;
    private String content;
    private int id;
}
