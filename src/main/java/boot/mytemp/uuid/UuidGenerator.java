package boot.mytemp.uuid;

import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class UuidGenerator {
    public UUID getUuid(){
        UUID uuid = UUID.randomUUID();
        return uuid;
    }
}
