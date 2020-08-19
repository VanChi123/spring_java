package vn.fis.project.springbootfinaltest.entity;

import vn.fis.project.springbootfinaltest.domain.UserDto;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@NamedNativeQueries(
        @NamedNativeQuery(
                name="User.getAllUsers",
                query = "select u.id,u.user_name,u.password\n" +
                        "from users u ",
                resultSetMapping = "User.mapToDto"
        )
)
@SqlResultSetMappings(
        @SqlResultSetMapping(
                name = "User.mapToDto",
                classes = @ConstructorResult(
                        targetClass = UserDto.class,
                        columns = {
                                @ColumnResult(name = "id"
                                        , type = Integer.class),
                                @ColumnResult(name = "user_name"
                                        , type = String.class),
                                @ColumnResult(name = "password"
                                        , type = String.class)
                        }
                )
        )
)
public class User {

    private Integer id;
    private String userName;
    private String password;
    private String fullName;
    private Date createDate;
    private Date lastLogin;

    private Set<Role> roles;
    private List<Order> listOrder;

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name = "full_name")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    @Column(name="create_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    @Column(name = "last_login")
    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    //@ManyToMany(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public List<Order> getListOrder() {
        return listOrder;
    }

    public void setListOrder(List<Order> listOrder) {
        this.listOrder = listOrder;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", createDate=" + createDate +
                ", lastLogin=" + lastLogin +
                ", roles=" + roles +
                ", listOrder=" + listOrder +
                '}';
    }
}
