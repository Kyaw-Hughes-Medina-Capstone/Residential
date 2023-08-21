package com.codeup.rentlister.repositories;
import com.codeup.rentlister.models.Property;
import com.codeup.rentlister.models.User;
import com.codeup.rentlister.models.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkOrderRepository extends JpaRepository<WorkOrder, Integer> {

	WorkOrder findWorkOrderByID(int id);
	WorkOrder findWorkOrderByProperty(Property property);
	WorkOrder findPropertyByTenant(User tenant);
}