package jogayjoga.group;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "group_")
@EqualsAndHashCode(of = "id")
@Builder @Getter @Setter @Accessors(chain = true, fluent = true)
@NoArgsConstructor @AllArgsConstructor
public class GroupModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_group")
    private String id;

    @Column(name = "tx_name")
    private String name;

    @Column(name = "tx_description")
    private String description;

    @Column(name = "tx_qtd_members")
    private Integer qtd_members;

    public GroupModel(Group o) {
        this.id = o.id();
        this.name = o.name();
        this.description = o.description();
        this.qtd_members = o.qtdMembers();
    }
    
    public Group to() {
        return new Group()
            .id(id)
            .name(name)
            .description(description)
            .qtdMembers(qtd_members);
    }
    
}