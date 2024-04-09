package jogayjoga.group;

public class GroupParser {
    public static Group to(GroupIn in ){
        return Group.builder()
            .name(in.name())
            .description(in.description())
            .qtdMembers(in.qtdMembers())
            .sportId(in.sportId())
            .build();
    }

    public static GroupOut to(Group in){
        return GroupOut.builder()
            .id(in.id())
            .name(in.name())
            .description(in.description())
            .qtdMembers(in.qtdMembers())
            .build();
    }
}
