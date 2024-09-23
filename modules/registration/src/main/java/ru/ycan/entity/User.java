package ru.ycan.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = -5449326074498337967L;
    public User(String username, String email, String password) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_generator")
    @SequenceGenerator(name = "users_id_generator", sequenceName = "sq_users_id", allocationSize = 1)
    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    private String email;
    private boolean active;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_role",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
}
