package jogayjoga.group;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NonNull;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public Group create(Group in){
        return groupRepository.save(new GroupModel(in)).to();
    }

    public GroupOut read(@NonNull String id) {
        return GroupParser.to(groupRepository.findById(id).map(model -> model.to()).orElse(null));
    }
    

}