package stockservice.stockservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stockservice.stockservice.model.StockEntity;

public interface StockRepository extends JpaRepository<StockEntity,Long> {
}
