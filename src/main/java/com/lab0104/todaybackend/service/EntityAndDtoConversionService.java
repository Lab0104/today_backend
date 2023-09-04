package com.lab0104.todaybackend.service;

import com.lab0104.todaybackend.data.domain.*;
import com.lab0104.todaybackend.data.dto.*;
import com.lab0104.todaybackend.data.repository.BannerRepository;
import com.lab0104.todaybackend.data.repository.CategoryRepository;
import com.lab0104.todaybackend.data.repository.MeetRepository;
import com.lab0104.todaybackend.data.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

@Component
@Transactional
public class EntityAndDtoConversionService {

    final private MeetRepository meetRepository;
    final private UserRepository userRepository;
    final private CategoryRepository categoryRepository;
    final private BannerRepository bannerRepository;

    public EntityAndDtoConversionService(MeetRepository meetRepository, UserRepository userRepository, CategoryRepository categoryRepository,
                                         BannerRepository bannerRepository) {
        this.meetRepository = meetRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.bannerRepository = bannerRepository;
    }


    //User Conversion
    public UserDTO.Info userEntityToDTO(User user){
        return UserDTO.Info.builder()
                .id(user.getId())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .address(user.getAddress())
                .score(user.getScore())
                .loginMethod(user.getLoginMethod())
                .passwordKey(user.getPasswordKey())
                .createdAt(user.getCreatedAt())
                .updateAt(user.getUpdatedAt())
                .build();
    }
    public User userDtoToEntity(UserDTO.Request userDTO){

        User user = User.builder()
                .email(userDTO.getEmail())
                .nickname(userDTO.getNickname())
                .address(userDTO.getAddress())
                .score(0)
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
                .topCategory(meet.getSubCategory().getCategoryGroup().getName())
                .subCategory(meet.getSubCategory().getName())
                .user(meet.getUser().getNickname())
                .createdAt(meet.getCreatedAt())
                .updateAt(meet.getUpdatedAt())
                .build();

        return meetDTO;
    }

    public Meet meetDtoToEntity(MeetDTO.Request meetDTO){
        Meet meet = Meet.builder()
                .title(meetDTO.getTitle())
                .subTitle(meetDTO.getSubTitle())
                .content(meetDTO.getContent())
                .date(meetDTO.getDate())
                .deadline(meetDTO.getDeadline())
                .maximum(meetDTO.getMaximum())
                .address(meetDTO.getAddress())
                .subCategory(categoryRepository.getById(meetDTO.getSubCategoryId()))
                .user(userRepository.getById(meetDTO.getUserId()))
                .build();

        return meet;
    }

    public MeetDTO.MainCard meetMainCardEntityToDTO(Meet meet){
        Period diff = Period.between(LocalDateTime.now().toLocalDate(), meet.getDate().toLocalDate());
        String limit;

        if(diff.getDays() == 0){
            limit = "D-DAY 마감임박";
        } else if (diff.getDays() >= 1){
            limit = "D - "+diff.getDays()+"모집중";
        } else {
            limit = "모집 마감";
        }

        return MeetDTO.MainCard.builder()
                .limit(limit)
                .topCategory(categoryRepository.getById(meet.getSubCategory().getId()).getCategoryGroup().getName())
                .subCategory(categoryRepository.getById(meet.getSubCategory().getId()).getName())
                .title(meet.getTitle())
                .address(meet.getAddress())
                .date(meet.getDate())
                .build();
    }

    public MeetDTO.MapCard meetMapCardEntityToDTO(Meet meet){
        Period setStatus = Period.between(LocalDateTime.now().toLocalDate(), meet.getDate().toLocalDate());
        Duration setUploadAt = Duration.between(meet.getCreatedAt(), LocalDateTime.now());
        String status;
        String uploadAt;

        //setStatus
        if(setStatus.getDays() >= 0){
            status = "모집중";
        } else {
            status = "모집 마감";
        }

        //setUploadAt
        if(setUploadAt.toHours() >= 1){
            //TODO: 하루 전이면 몇 일전으로 변경해야 함.
            uploadAt = setUploadAt.toHours()+" 시간 전";
        }else{
            uploadAt = setUploadAt.toMinutes()+" 분 전";
        }

        return MeetDTO.MapCard.builder()
                .title(meet.getTitle())
                .topCategory(categoryRepository.getById(meet.getSubCategory().getId()).getCategoryGroup().getName())
                .subCategory(categoryRepository.getById(meet.getSubCategory().getId()).toString())
                .status(status)
                .deadline(meet.getDeadline())
                .address(meet.getAddress())
                .date(meet.getDate())
                .uploadAt(uploadAt)
                .build();
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
                .categoryGroup(category.getCategoryGroup() == null?
                        null : category.getCategoryGroup().getId())
                .createdAt(category.getCreatedAt())
                .updateAt(category.getUpdatedAt())
                .build();
        return categoryDTO;
    }

    public Category categoryDtoToEntity(CategoryDTO.Request categoryDTO){
        Category categoryGroup = categoryRepository.getById(categoryDTO.getCategoryGroup());

        Category category = Category.builder()
                .name(categoryDTO.getName())
                .imageUrl(categoryDTO.getImageUrl())
                .categoryGroup(categoryGroup)
                .build();

        return category;
    }

    // Banner Conversion
    public BannerDTO.Info bannerEntityToDTO(Banner banner) {
        BannerDTO.Info bannerDTO = BannerDTO.Info.builder()
                .id(banner.getId())
                .display_period(banner.getDisplay_period())
                .title(banner.getTitle())
                .contents(banner.getContents())
                .image_url(banner.getImage_url())
                .userName(banner.getUser().getNickname())
                .meetName(banner.getMeet().getTitle())
                .build();
        return bannerDTO;
    }

    public Banner bannerDTOtoEntity(BannerDTO.Request bannerDTO) {
        Meet meet = meetRepository.getById(bannerDTO.getMeet()); // DTO에서 Meet을 가져와서 id 조회한 값을 넘긴다.
        User user = userRepository.getById(bannerDTO.getUser());

        Banner banner = Banner.builder()
                .display_period(bannerDTO.getDisplay_period())
                .title(bannerDTO.getTitle())
                .contents(bannerDTO.getContents())
                .image_url(bannerDTO.getImage_url())
                .user(user)
                .meet(meet)
                .build();
        return banner;
    }
}
