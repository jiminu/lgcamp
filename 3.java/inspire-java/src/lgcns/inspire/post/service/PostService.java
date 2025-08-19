package lgcns.inspire.post.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import lgcns.inspire.post.domain.dto.PostRequestDTO;
import lgcns.inspire.post.domain.dto.PostResponseDTO;

public interface PostService {
    
    public List<PostResponseDTO> selectService();
    public Optional<PostResponseDTO> selectService(int id);
    
    public int postService(PostResponseDTO data);
    
    public List<PostResponseDTO> searchService(String writer);
    public int deleteService(Map<String, Integer> map);
    public int updateService(PostResponseDTO request);

    public int fileSave(String path);
    public List<PostResponseDTO> fileLoad();
}
