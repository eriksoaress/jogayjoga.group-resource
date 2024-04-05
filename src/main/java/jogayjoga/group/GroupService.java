package jogayjoga.group;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

    public Group read(@NonNull String id) {
        return groupRepository.findById(id).map(model -> model.to()).orElse(null);
    }

    public Group readall(@NonNull String idUser, @NonNull String roleUser) {
        return groupRepository.findAll().map(model -> model.to()).orElse(null);
    }
    
    public Group update(@NonNull String id, Group in){
        GroupModel model = groupRepository.findById(id).orElse(null);
        if (model == null){
            return null;
        }
        model.update(in);
        return groupRepository.save(model).to();
    }

    public Group delete(@NonNull String id, @NonNull String idUser, @NonNull String roleUser){
        GroupModel model = groupRepository.findById(id).orElse(null);
        if (model == null){
            return null;
        }
        groupRepository.delete(model);
        return model.to();
    }
}