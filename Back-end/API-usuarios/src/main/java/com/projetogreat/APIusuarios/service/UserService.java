package com.projetogreat.APIusuarios.service;

import com.projetogreat.APIusuarios.model.User;
import com.projetogreat.APIusuarios.model.User;
import com.projetogreat.APIusuarios.repository.UserRepository;
import com.projetogreat.APIusuarios.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class UserService {

    private UserRepository userRepository;

    public User createUser (User user){
        return userRepository.save(user);
    }

    public List<User> listAllUsers(){
        return userRepository.findAll();
    }

    public ResponseEntity<User> findUserById(Long id){
        return  userRepository.findById(id)
                .map(task -> ResponseEntity.ok().body(task))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<User> updateUserById(User user, Long id){
        return userRepository.findById(id)
                .map(userToUpdate -> {
                    userToUpdate.setName(user.getName());
                    userToUpdate.setCpf(user.getCpf());
                    userToUpdate.setRg(user.getRg());
                    userToUpdate.setBirthDate(user.getBirthDate());
                    userToUpdate.setMotherName(user.getMotherName());
                    userToUpdate.setRegistrationDate(user.getRegistrationDate());
                    User updated = userRepository.save(userToUpdate);
                    return  ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteById (Long id) {
        return userRepository.findById(id)
                .map(taskToDelete -> {
                    userRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
        }
    }


