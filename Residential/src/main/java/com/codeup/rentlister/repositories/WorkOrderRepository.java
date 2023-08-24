package com.codeup.rentlister.repositories;
import com.codeup.rentlister.models.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkOrderRepository extends JpaRepository<WorkOrder, Integer> {
	WorkOrder findWorkOrderById(int id);
}