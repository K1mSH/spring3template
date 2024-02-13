package boot.mytemp.redis;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash("user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id; // userId: 입력안하면 임의의 값 생성됨.

    private String name;
    private String major; // 전공: back, front
    private int age;
}
