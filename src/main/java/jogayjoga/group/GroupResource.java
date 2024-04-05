package jogayjoga.group;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class GroupResource implements GroupController {
    
    @Autowired
    private GroupService groupService;

    @Override
    public ResponseEntity<GroupOut> create(GroupIn in) {
        try{
            Group group = GroupParser.to(in);
            group = groupService.create(group);
            return ResponseEntity.created(
                ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(group.id())
                .toUri())
                .body(GroupParser.to(group));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }

    @Override
    public ResponseEntity<GroupOut> update(String id, GroupIn in) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    
    @Override
    public ResponseEntity<GroupOut> readall(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readall'");
    }


    @Override
    public ResponseEntity<GroupOut> read(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }


}   