package crud.models;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

//@Data
@Entity
@Table(name = "t_user")
public class User implements UserDetails {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column
   private String username;
   @Column
   private String password;
   @Transient
   private String passwordConfirm;
   @ManyToMany(fetch = FetchType.EAGER)
   private Set<Role> roles;

   public User() {
   }

   @Override
   public String getUsername() {
      return username;
   }

   @Override
   public boolean isAccountNonExpired() {
      return true;
   }

   @Override
   public boolean isAccountNonLocked() {
      return true;
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return true;
   }

   @Override
   public boolean isEnabled() {
      return true;
   }

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return getRoles();
   }

   @Override
   public String getPassword() {
      return password;
   }

   public Long getId() {
      return id;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getPasswordConfirm() {
      return passwordConfirm;
   }

   public void setPasswordConfirm(String passwordConfirm) {
      this.passwordConfirm = passwordConfirm;
   }

   public Set<Role> getRoles() {
      return roles;
   }

   public void setRoles(Set<Role> roles) {
      this.roles = roles;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      User user = (User) o;

      if (username != null ? !username.equals(user.username) : user.username != null) return false;
      if (password != null ? !password.equals(user.password) : user.password != null) return false;
      return roles != null ? roles.equals(user.roles) : user.roles == null;
   }

   @Override
   public int hashCode() {
      int result = username != null ? username.hashCode() : 0;
      result = 31 * result + (password != null ? password.hashCode() : 0);
      result = 31 * result + (roles != null ? roles.hashCode() : 0);
      return result;
   }

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", username='" + username + '\'' +
              ", password='" + password + '\'' +
              ", roles=" + roles +
              '}';
   }
}
