package HomeDelivery.Ecommerce.Repository;

import HomeDelivery.Ecommerce.models.UserModel;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Integer> {
    List<UserModel> findByNameEndingWith(String suffix);
    Optional<UserModel> findByName(String name);
    UserModel save(UserModel userModel);
    @Query("select u from userModel where u.emailId = :email")
    UserModel findByEmail(String email);
}
