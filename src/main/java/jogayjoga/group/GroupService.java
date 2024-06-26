package jogayjoga.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import jogayjoga.sport.SportController;
import jogayjoga.sport.SportOut;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.NonNull;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private SportController sportController;

    public Group create(Group in){
        return groupRepository.save(new GroupModel(in)).to();
    }

    public GroupSportOut getFullInfo(String id){
        Group group = groupRepository.findById(id).map(model -> model.to()).orElse(null);
        if (null == group) return null;
        String sport_name = null;
        ResponseEntity<SportOut> response = sportController.get(group.sportId());
        if (response != null && response.getBody() != null) {
            sport_name = response.getBody().name();
        }
        else{
            sport_name = "";
        }
        return GroupSportOut.builder()
            .name(group.name())
            .description(group.description())
            .qtdMembers(group.qtdMembers())
            .sportName(sport_name)
            .build();
            
    }

    @Cacheable(key = "#id", value = "group", unless = "#result == null")
    public GroupOut read(@NonNull String id) {
        System.out.println("Reading group id: " + id);
        return GroupParser.to(groupRepository.findById(id).map(model -> model.to()).orElse(null));
    }

    public List<GroupOut> readAll() {
        List<GroupModel> groupModels = new ArrayList<>();
        groupRepository.findAll().forEach(groupModels::add);

        List<Group> groups = groupModels.stream()
            .map(GroupModel::to)
            .collect(Collectors.toList());

        if (groups.isEmpty()) {
            return null;
        }

        // converte groups para List<GroupOut>
        List<GroupOut> groupOuts = new ArrayList<>();
        for (Group group : groups) {
            groupOuts.add(GroupParser.to(group));
        }

        return groupOuts;
    }

    public GroupOut update(String id, GroupIn in) {
        Group group = groupRepository.findById(id).map(GroupModel::to).orElse(null);
        if (group == null) {
            // Handle the case when the group is not found
            throw new RuntimeException("Group not found");
        }
        group.name(in.name()); // Fluent setter
        group.description(in.description());
        group.qtdMembers(in.qtdMembers());
        group.sportId(in.sportId());
        GroupModel updatedModel = groupRepository.save(new GroupModel(group));

        // Convert the updated Group object to a GroupOut object and return it
        return GroupParser.to(updatedModel.to());
    }

    public void delete(String id) {
        groupRepository.deleteById(id);
    }

    

}