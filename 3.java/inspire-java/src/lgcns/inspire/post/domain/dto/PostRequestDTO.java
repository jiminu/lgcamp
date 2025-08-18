package lgcns.inspire.post.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PostRequestDTO {
    private String title, content, writer;
    
    // 정적 팩토리 메서드 패턴
    public static PostResponseDTO toResponseDTO(PostRequestDTO request) {
        return PostResponseDTO.builder()
                              .title(request.getTitle())
                              .content(request.getTitle())
                              .writer(request.getWriter())
                              .build();
    }
}
