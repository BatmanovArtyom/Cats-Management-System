package com.tech.labs.ServiceModule.Implementation;

import com.tech.labs.DaoModule.Entities.Owners;
import com.tech.labs.DaoModule.Entities.Role;
import com.tech.labs.DaoModule.Entities.User;
import com.tech.labs.DaoModule.Repository.OwnersRepository;
import com.tech.labs.DaoModule.Repository.RoleRepository;
import com.tech.labs.DaoModule.Repository.UserRepository;
import com.tech.labs.ServiceModule.Dto.OwnersDto;
import com.tech.labs.ServiceModule.Dto.RoleDTO;
import com.tech.labs.ServiceModule.Dto.UserDTO;
import com.tech.labs.ServiceModule.Mapping.RoleMapping;
import com.tech.labs.ServiceModule.Mapping.UserMapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private final OwnersRepository ownersRepository;
    private final UserMapping userMapping;
    private final RoleRepository roleRepository;
    private final RoleMapping roleMapping;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLoginWithRoles(login)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with login: " + login));
        return new UserDetailImpl(user);
    }

    public UserDTO add(UserDTO userDTO) {
        User user = userMapping.fromDto(userDTO);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        user.getRoles().clear();
        List<Role> rolesDTO = new ArrayList<>();

        if (user.getOwner() != null) {
            Owners owner = user.getOwner();
            ownersRepository.save(owner);  // Сохраняем владельца
        }

        for (Role roleDTO : userDTO.getRoles()){
            Optional<Role> cur = roleRepository.findById(roleDTO.getId());
            Role curRole = cur.get();
            user.getRoles().add(curRole);
            curRole.getUsers().add(user);
            rolesDTO.add(roleMapping.toDto(cur.get()));
        }

        userRepository.save(user);  // Теперь можно сохранить User
        userDTO = userMapping.toDto(user);
        userDTO.setRoles(rolesDTO);
        return userDTO;
    }

    public void delete(long id) throws ParseException {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty())
            return;
        User deletedUser = optionalUser.get();
        Owners owner = deletedUser.getOwner();
        ownersRepository.deleteById(owner.getOwnerID());
        userRepository.deleteById(id);
    }

    public List<UserDTO> getAll() {
        return userRepository.findAll().stream()
                .map(userMapping::toDto)
                .collect(Collectors.toList());
    }

    public User getCurrentUser() {
        UserDetailImpl userDetail = (UserDetailImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetail.getUser();
    }
}
