package HomeDelivery.Ecommerce.Repository;

import HomeDelivery.Ecommerce.models.InstructorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface InstructorRepo extends JpaRepository<InstructorModel,Long> {
}
