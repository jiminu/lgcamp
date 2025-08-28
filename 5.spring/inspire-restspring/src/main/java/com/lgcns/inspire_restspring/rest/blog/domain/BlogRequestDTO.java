package com.lgcns.inspire_restspring.rest.blog.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
public class BlogRequestDTO {
    @Schema(description = "블로그 제목", example = "스프링부트데쓰")
    private String title;
    @Schema(description = "블로그 내용", example = "입니다쓰")
    private String content;
}
