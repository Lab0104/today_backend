package com.lab0104.todaybackend.service;

import com.lab0104.todaybackend.data.domain.Category;
import com.lab0104.todaybackend.data.domain.Meet;
import com.lab0104.todaybackend.data.domain.Member;
import com.lab0104.todaybackend.data.domain.User;
import com.lab0104.todaybackend.data.dto.CategoryDTO;
import com.lab0104.todaybackend.data.dto.MeetDTO;
import com.lab0104.todaybackend.data.dto.MemberDTO;
import com.lab0104.todaybackend.data.dto.UserDTO;
import com.lab0104.todaybackend.data.repository.CategoryRepository;
import com.lab0104.todaybackend.data.repository.MeetRepository;
import com.lab0104.todaybackend.data.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class EntityAndDtoConversionService {

    final private MeetRepository meetRepository;

    final private UserRepository userRepository;
    final private CategoryRepository categoryRepository;

    public EntityAndDtoConversionService(MeetRepository meetRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.meetRepository = meetRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }


    //User Conversion
    public UserDTO.Info userEntityToDTO(User user){

        return UserDTO.Info.builder()
                .id(user.getId())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .address(user.getAddress())
                .addressLatitude(user.getAddressLatitude())
                .addressLongitude(user.getAddressLatitude())
                .score(user.getScore())
                .loginMethod(user.getLoginMethod())
                .passwordKey(user.getPasswordKey())
                .createdAt(user.getCreatedAt())
                .updateAT(user.getUpdatedAt())
                .build();
    }
    public User userDtoToEntity(UserDTO.Request userDTO){

        User user = User.builder()
                .email(userDTO.getEmail())
                .nickname(userDTO.getNickname())
                .address(userDTO.getAddress())
                .addressLatitude(userDTO.getAddressLatitude())
                .addressLongitude(userDTO.getAddressLatitude())
                .score(userDTO.getScore())
                .loginMethod(userDTO.getLoginMethod())
                .passwordKey(userDTO.getPasswordKey())
                .build();

        return user;
    }

    //Meet Conversion
    public MeetDTO.Info meetEntityToDTO(Meet meet){
        MeetDTO.Info meetDTO = MeetDTO.Info.builder()
                .id(meet.getId())
                .title(meet.getTitle())
                .subTitle(meet.getSubTitle())
                .content(meet.getContent())
                .date(meet.getDate())
                .deadline(meet.getDeadline())
                .maximum(meet.getMaximum())
                .addressLatitude(meet.getAddressLatitude())
                .addressLongitude(meet.getAddressLongitude())
                .category(meet.getCategory().getId())
                .user(meet.getUser().getId())
                .build();

        return meetDTO;
    }
    public Meet meetDtoToEntity(MeetDTO.Request meetDTO){
        Category category = categoryRepository.getById(meetDTO.getCategory());
        User user = userRepository.getById(meetDTO.getUser());

        Meet meet = Meet.builder()
                .title(meetDTO.getTitle())
                .subTitle(meetDTO.getSubTitle())
                .content(meetDTO.getContent())
                .date(meetDTO.getDate())
                .deadline(meetDTO.getDeadline())
                .maximum(meetDTO.getMaximum())
                .address(meetDTO.getAddress())
                .addressLatitude(meetDTO.getAddressLatitude())
                .category(category)
                .user(user)
                .build();

        return meet;
    }

    //Member Conversion
    public MemberDTO.Info memberEntityToDTO(Member member){
        MemberDTO.Info memberDTO = MemberDTO.Info.builder()
                .id(member.getId())
                .meetName(member.getMeet().getTitle())
                .userName(member.getUser().getNickname())
                .status(member.getStatus())
                .build();

        return memberDTO;
    }
    public Member memberDtoToEntity(MemberDTO.Request memberDTO){
        Meet meet = meetRepository.getById(memberDTO.getMeet());
        User user = userRepository.getById(memberDTO.getUser());

        Member member = Member.builder()
                .meet(meet)
                .user(user)
                .build();

        return member;
    }

    //Category Conversion
    public CategoryDTO.Info categoryEntityToDTO(Category category){
        CategoryDTO.Info categoryDTO = CategoryDTO.Info.builder()
                .id(category.getId())
                .name(category.getName())
                .depth(category.getDepth())
                .imageUrl(category.getImageUrl())
                .categoryGroup(category.getCategoryGroup().getId())
                .createdAt(category.getCreatedAt())
                .updateAT(category.getUpdatedAt())
                .build();
        return categoryDTO;
    }

    public Category categoryDtoToEntity(CategoryDTO.Request categoryDTO){
        Category categoryGroup = categoryRepository.getById(categoryDTO.getCategoryGroup()); // 부모를 호출

        Category category = Category.builder()
                .name(categoryDTO.getName())
                .imageUrl(categoryDTO.getImageUrl())
                .categoryGroup(categoryGroup) // 자식에서 부모 Category를 저장
                .build();

        return category;
    }
}
