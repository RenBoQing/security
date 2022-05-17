package com.rbq.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbq.mybatisplus.entity.User;
import com.rbq.mybatisplus.mapper.UserMapper;
import com.rbq.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author RenBoQing
 * @date 2022年05月10日 14:20
 * @Description
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
