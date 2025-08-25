import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lgcns.inspire.post.domain.dto.PostResponseDTO;

public class IOStreamApp {

    public static void main(String[] args) {

        System.out.println(">>> Stream을 이용한 데이터 입력 : ");

        // try {
        // int input = System.in.read();
        // System.out.println(">>> result : " + (char)input);
        // }
        // catch(Exception e) {
        // e.printStackTrace();
        // }

        System.out.println(">>> 파일에 문제 저장");


        // java 7 -> AutoClosable
        // try (     *     ) {} catch () {} 하면 알아서 close 함
        // String data = "test";
        // try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("./test.txt")))){
        //     bw.write(data);
        // }
        // catch(Exception e) {
        //     e.printStackTrace();
        // }
        
        List<PostResponseDTO> posts = new ArrayList<>(Arrays.asList(
                PostResponseDTO.builder()
                        .id(1)
                        .title("mvc")
                        .content("first content")
                        .writer("jslim")
                        .build(),
                PostResponseDTO.builder()
                        .id(2)
                        .title("wow")
                        .content("second content")
                        .writer("jslim")
                        .build(),
                PostResponseDTO.builder()
                        .id(3)
                        .title("ggyak")
                        .content("third content")
                        .writer("holy")
                        .build(),
                PostResponseDTO.builder()
                        .id(4)
                        .title("springboot")
                        .content("pattern combination")
                        .writer("inspire~")
                        .build()
        ));
        
        System.out.println(">>> Serializable object");
        // ObjectOutputStream -> FileOutputStream -> "./text.txt"
        
        // try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./test.txt"))) {
        //     oos.writeObject(posts);
        //     System.out.println(">>> 저장 완료");
        // }
        // catch(Exception e) {
        //     System.out.println(">>> 저장 실패");
        //     e.printStackTrace();
        // }
        
        List<PostResponseDTO> response;
        
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./test.txt"))) {
            response = (List<PostResponseDTO>)ois.readObject();
            System.out.println(">>> 불러오기 완료");
            
            response.stream()
                    .forEach(System.out::println);
        }
        catch(Exception e) {
            System.out.println(">>> 불러오기 실패");
            e.printStackTrace();
        }
        
        System.out.println("done");
    }
}