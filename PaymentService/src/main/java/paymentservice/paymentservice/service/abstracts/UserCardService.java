package paymentservice.paymentservice.service.abstracts;

import paymentservice.paymentservice.Entity.UserCard;

public interface UserCardService {

    public void add(UserCard userCard);

    public void delete(Long id);


}
