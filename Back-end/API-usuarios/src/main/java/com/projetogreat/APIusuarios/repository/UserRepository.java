package com.projetogreat.APIusuarios.repository;

import com.projetogreat.APIusuarios.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {
}
