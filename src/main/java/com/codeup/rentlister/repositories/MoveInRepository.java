package com.codeup.rentlister.repositories;

import com.codeup.rentlister.models.MoveInForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoveInRepository extends JpaRepository <MoveInForm, Long> {

    MoveInForm findMoveInFormById(long id);
}
