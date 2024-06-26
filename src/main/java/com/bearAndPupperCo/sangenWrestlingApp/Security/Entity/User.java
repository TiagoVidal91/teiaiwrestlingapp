package com.bearAndPupperCo.sangenWrestlingApp.Security.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name = "platform_user",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "user_id")
        private Long id;

        private String username;

        private String email;

        private String password;

        private LocalDate creatingDate;

        @ManyToMany
        @JoinTable(name = "user_roles",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
        private Set<Role> roles = new HashSet<>();

        public User(String username, String email, String password, LocalDate creatingDate) {
                this.username = username;
                this.email = email;
                this.password = password;
                this.creatingDate = creatingDate;
        }

        public User(String username, String email, String password, LocalDate creatingDate, Set<Role> roles) {
                this.username = username;
                this.email = email;
                this.password = password;
                this.creatingDate = creatingDate;
                this.roles = roles;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public LocalDate getCreatingDate() {
                return creatingDate;
        }

        public void setCreatingDate(LocalDate creatingDate) {
                this.creatingDate = creatingDate;
        }

        public Set<Role> getRoles() {
                return roles;
        }

        public void setRoles(Set<Role> roles) {
                this.roles = roles;
        }
}
