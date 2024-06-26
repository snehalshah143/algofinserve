package tech.algofinserve.security;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Set;

//@Entity
@Document(collection = "role")
public class RolePersistable {
        private Long id;
        private String name;
        private Set<UserPersistable> users;

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

  /*    @ManyToMany(mappedBy = "roles")
  public Set <User> getUsers() {
      return users;
  }

  public void setUsers(Set <User> users) {
      this.users = users;
  }*/
}