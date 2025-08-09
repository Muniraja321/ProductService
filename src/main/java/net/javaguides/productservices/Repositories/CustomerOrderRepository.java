package net.javaguides.productservices.Repositories;

import jakarta.persistence.criteria.Order;
import net.javaguides.productservices.models.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, UUID> {
}
