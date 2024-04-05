package jogayjoga.group;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<GroupModel, String>{
    Optional<GroupModel> findByEmailAndHash(String email, String hash);
}
