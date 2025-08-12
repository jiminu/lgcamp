import lgcns.inspire.post.domain.dto.PostResponseDTO;

public class AryApp {
    public static void main(String[] args) {
        
        // int[] ary = new int[10];
        int[] ary = {1,2,3,4,5};
        
        for (int i = 0; i < ary.length; ++i) {
            System.out.println(ary[i]);
        }
        
        System.out.println("----------------------");
        
        for (int data : ary) {
            System.out.println(data);
        }
        
        System.out.println("----------------------");

        PostResponseDTO[] postAry = new PostResponseDTO[10];
        
        PostResponseDTO data = PostResponseDTO.builder()
        .title("holy")
        .build();
        
        postAry[0] = data;
        
        
        
        for (PostResponseDTO dto : postAry) {
            if (dto == null) continue;
            System.out.println(dto.getTitle());
            
        }
    }
    
}
