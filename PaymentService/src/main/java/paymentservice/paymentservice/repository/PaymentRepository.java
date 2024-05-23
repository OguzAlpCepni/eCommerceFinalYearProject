package paymentservice.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import paymentservice.paymentservice.Entity.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity,String> {
}
