package org.springframework.boot.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //généralement utilisée avec des classes pour générer automatiquement un constructeur avec des paramètres pour les champs marqués avec final. Cela facilite l'injection de dépendances dans ces champs, car vous n'avez pas besoin d'écrire manuellement un constructeur.
public class UserService {
    private final UserRepository repository;

    public User saveUser(User user){

        return repository.save(user);
    }
    public List<User> findAllUsers(){

        return repository.findAll();
    }

    public User getUserById(int userId) {
        return repository.findById(userId).orElse(null);
    }
   public User updateUser(int userId, User updatedUser) {
        User existingUser = repository.findById(userId).orElse(null);
        if (existingUser != null) {
            // Mettre à jour les champs de l'utilisateur existant avec les valeurs de updatedUser
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setFirstname(updatedUser.getFirstname());
            existingUser.setLastname(updatedUser.getLastname());
            existingUser.setEmail(updatedUser.getEmail());
            // Vous pouvez mettre à jour d'autres champs si nécessaire

            // Ensuite, sauvegardez l'utilisateur mis à jour
            return repository.save(existingUser);
        } else {
            // Gérer le cas où l'utilisateur n'a pas été trouvé (par exemple, retourner null ou générer une erreur)
            return null;
        }
    }




    public List<User> findUsersByName(String username) {
        return repository.findByUsername(username);
    }

   public void deleteUser(int userId) {
       repository.deleteById(userId);
   }



}
