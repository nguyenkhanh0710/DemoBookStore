package minhkhanh.DemoBookStore.repository;

import jakarta.transaction.Transactional;
import minhkhanh.DemoBookStore.enitity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IUserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u Where u.username = ?1")
    User findByUsername(String username);
    @Modifying
    @Transactional
    @Query(value = "Insert into user_role (user_id,role_id)"+"Value (?1,?2)",nativeQuery = true)
    void addRoleToUser(Long UserId,Long roleId);
    @Query("Select u.id from user where u.username =?1")
    Long getUserIdByUsername(String username);
    @Query(value = "Select r.name from role r inner join user_role ur"+"On r.id = ur.role_id where ur.user_id =?1",nativeQuery = true)
    String [] getRoles0User(Long userId);
}
