package lecture.spring_boot_Mybatis.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int id;
    private String name;
    private String nickname;
}