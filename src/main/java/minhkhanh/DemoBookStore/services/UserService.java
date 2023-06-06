package minhkhanh.DemoBookStore.services;

import minhkhanh.DemoBookStore.enitity.User;
import minhkhanh.DemoBookStore.repository.IRoleRepository;
import minhkhanh.DemoBookStore.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    private IRoleRepository roleRepository;
    public void Save(User user) {
        userRepository.save(user);
        Long userId = userRepository.getUserIdByUsername(user.getUsername());
        Long roleId = roleRepository.getRoleIdByName("USER");
        if (roleId != 0 && userId != 0) {
            userRepository.addRoleToUser(userId, roleId);
        }
    }
}
