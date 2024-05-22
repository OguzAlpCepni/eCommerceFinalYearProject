package paymentservice.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import paymentservice.paymentservice.Entity.UserCard;

public interface UserCardRepository extends JpaRepository<UserCard,Long> {
}
