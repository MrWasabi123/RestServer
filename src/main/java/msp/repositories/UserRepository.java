package msp.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import msp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

