package jogayjoga.group;
import org.springframework.data.repository.CrudRepository;


import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<GroupModel, String>{
    
}
