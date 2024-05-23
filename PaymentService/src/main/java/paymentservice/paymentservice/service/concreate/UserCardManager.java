package paymentservice.paymentservice.service.concreate;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import paymentservice.paymentservice.Entity.UserCard;
import paymentservice.paymentservice.repository.UserCardRepository;
import paymentservice.paymentservice.service.abstracts.UserCardService;
@Service
@AllArgsConstructor
public class UserCardManager implements UserCardService {
    private UserCardRepository userCardRepository;
    @Override
    public void add(UserCard userCard) {
        userCardRepository.save(userCard);
    }

    @Override
    public void delete(Long id) {
        userCardRepository.deleteById(id);
    }
}
