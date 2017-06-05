package pl.cyfronet.indigo.bean;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author bwilk
 *
 */
@Entity
@Data
@ToString(exclude = {"affiliations", "teams", "roles"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String country;

    private String organisationName;
    
    @Column(unique=true)
    private String email;
    private String researchGate;
    private String linkedln;
    private boolean isPolicyAccepted;
    private Boolean confirmedRegistration;
    private String unityPersistentIdentity;
    private boolean hasActiveSla;
    
    @JsonIgnore
    @ManyToMany(mappedBy="members")
    private List<Team> teams;

    @JsonIgnore
    @OneToMany(mappedBy="user")
    @OrderBy("weight")
    private List<DocumentWeight> documents;
    
    @JsonIgnore
    @ManyToMany
    private List<Role> roles;

    public boolean hasRole(String role) {
        for(Role _role : getRoles()) {
            if (_role.getName().equals(role)){
                return true;
            }
        }
        return false;
    }
}
