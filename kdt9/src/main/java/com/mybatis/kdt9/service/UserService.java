package com.mybatis.kdt9.service;

import com.mybatis.kdt9.domain.User;
import com.mybatis.kdt9.domain.UserEntity;
import com.mybatis.kdt9.dto.UserDTO;
import com.mybatis.kdt9.dto.UserDTOBuilder;
import com.mybatis.kdt9.mapper.UserMapper;
import com.mybatis.kdt9.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    // mapper를 실행하고 그에 대한 결과값을 dto에 담아서 controller로 return
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRepository userRepository;

    public String searchUser(String name) {
        // findBy컬럼명
        // findBy컬럼명And컬럼명
        List<UserEntity>  result = userRepository.findByName(name);
        for (UserEntity user : result) {
            System.out.println(user.getId() + user.getNickname());
        }
        return "";
    }

    public String searchId(int id) {
        Optional<UserEntity> result = userRepository.findById(id);
        if(result.isPresent()) {
            System.out.println(result.get().getName());
        } else {
            System.out.println("해당하는 친구 없음");
        }
        // Optional : null일 수도 있는 객체를 감싸는 Wrapper 객체
        // Optional<T>
        // isPresent() : 객체의 여부를 boolean 으로 반환
        // isEmpty() : 반대 (isPresent의 반대)
        // get() : Optional 내부의 객체를 반환
        return "";
    }

    public List<UserDTO> getUserList() {
        List<UserEntity> result = userRepository.findAll(); // 전체 검색 select * from user
        List<UserDTO> users = new ArrayList<>();
        for( UserEntity user : result) {
            UserDTO userDTO = UserDTO.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .nickname(user.getNickname())
                    .build();
            users.add(userDTO);
        }
        return users;

//        List<User> result = userMapper.retrieveAll();
//        List<UserDTO> users = new ArrayList<>();
////        for (User u: result) {
////            UserDTO user = new UserDTO();
////            user.setId(u.getId());
////            user.setName(u.getName());
////            user.setNickname(u.getNickname());
////            users.add(user);
////        }
//        for (int i = 0; i < result.size(); i++) {
//            User u = result.get(i);
//
//            UserDTO user = UserDTO.builder()
//                    .id(u.getId())
//                    .name(u.getName())
//                    .nickname(u.getNickname())
//                    .no(i + 1)
//                    .build();
//            users.add(user);
////            UserDTO user = new UserDTO();
////            user.setId(u.getId());
////            user.setName(u.getName());
////            user.setNickname(u.getNickname());
////            user.setNo(i + 1);
////            users.add(user);
//            // 검색된 u gkskTLrdml 데이터를 userDTO로 만들고
//            // 그걸 users에 담아서 return
//
////            UserDTOBuilder userDTOBuilder = UserDTOBuilder.builder()
////                    .id(u.getId())
////                    .name(u.getName())
////                    .build();
//        }
//
//        return users;
    }

    public UserDTO insertUser(String name, String nickname) {
        UserEntity userEntity = UserEntity.builder()
                .name(name)
                .nickname(nickname)
                .build();

        UserEntity result = userRepository.save(userEntity);
        // save를 했을 때 반환되는 객체는 Entity 객체
        UserDTO userDTO = UserDTO.builder()
                .id(result.getId())
                .name(result.getName())
                .nickname(result.getNickname())
                .build();

        return userDTO;
    }

    public List<UserDTO> searchName(String name) {
        List<UserEntity> result = userRepository.findByName(name);
        List<UserDTO> list = new ArrayList<>();
        for (UserEntity user : result) {
            UserDTO userDTO = UserDTO.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .nickname(user.getNickname())
                    .build();
            list.add(userDTO);
        }
        return list;
    }

    public List<UserDTO> searchNameOrNickname(String searchParam) {
        List<UserEntity> result = userRepository.findByNameOrNickname(searchParam,searchParam);
        List<UserDTO> list = new ArrayList<>();
        for (UserEntity user : result) {
            UserDTO userDTO = UserDTO.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .nickname(user.getNickname())
                    .build();
            list.add(userDTO);
        }
        return list;
    }

    public boolean checkNameExists(String name) {
        return userRepository.existsByName(name);
    }

//    public void insertUser(String name, String nickname) {
//        User user = new User();
//        user.setName(name);
//        user.setNickname(nickname);
//        userMapper.insertUser(user);
//    }


}
