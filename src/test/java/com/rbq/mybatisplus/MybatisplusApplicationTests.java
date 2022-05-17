package com.rbq.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rbq.mybatisplus.entity.User;
import com.rbq.mybatisplus.enums.SexEnum;
import com.rbq.mybatisplus.mapper.UserMapper;
import com.rbq.mybatisplus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
@Slf4j
class MybatisplusApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    /*
     *mybatisPlus查询功能测试
     * @author RenBoQing
     * @date 2022/5/10 0010 10:06
     */
    @Test
    void MybatisPlusTest() {
        User user = userMapper.selectById(1);
        System.out.println(user);
        //通过条件构造器查询一个List集合，若没有条件，则可以设置null为参数
        List<User> users = userMapper.selectList(null);
    }

    /*
     *mybatisPlus添加操作
     * @author RenBoQing
     * @date 2022/5/10 0010 10:30
     */
    @Test
    void insertTest() {
        User user = new User();
        user.setAge(20);
        user.setEmail("zhansan@qq.com");
        user.setName("张三56");
        int insert = userMapper.insert(user);
        System.out.println(insert);
        //获取自动生成的id
    }

    /*
     *mybatisPlus刪除操作
     * @author RenBoQing
     * @date 2022/5/10 0010 10:37
     */
    @Test
    void deleteByIdTest() {
        int deleteById = userMapper.deleteById(1523853079798104066L);
        System.out.println(deleteById);
        // 批量删除信息 做成一个集合
        List<Long> longs = Arrays.asList(1L, 2L, 3L);
        userMapper.deleteBatchIds(longs);
        //// 通过deleteByMap来实现  通过键值的参数来实现删除  同时
        //Map<String, Object> map = new HashMap<>();
        //map.put("name", "张三");
        //map.put("age", 45);
        ////同时满足条件才能删除
        //userMapper.deleteByMap(map);
        // 通过deleteBatchIds来删除对对应的数据
    }

    /*
     *mybatisPlus修改操作
     * @author RenBoQing测试
     * @date 2022/5/10 0010 11:09
     */
    @Test
    void updateTest() {
        User user = new User();
        user.setUid(4L);
        user.setName("王五");
        user.setAge(45);
        userMapper.updateById(user);
    }

    /*
     *mybatisPlus查询测试
     * @author RenBoQing
     * @date 2022/5/10 0010 11:17
     */
    @Test
    void selectTest() {
        //1.通过selectById查询用户数据 返回一个对象
        User user = userMapper.selectById(1L);
        //通过id批量查询
        List<Long> longList = Arrays.asList(1L, 2L, 3L);
        List<User> users = userMapper.selectBatchIds(longList);
        for (User user1 : users) {
            System.out.println(user1);
        }
        //通过selectByMap 实现多条件的查询
        Map<String, Object> map = new HashMap<>();
        map.put("name", "jack");
        map.put("age", 20);
        List<User> userList = userMapper.selectByMap(map);
        for (User user1 : userList) {
            System.out.println(user1);
        }
        //通过selectList来查询数据 条件没有的时候为空
        List<User> selectList = userMapper.selectList(null);
        for (User user1 : selectList) {
            System.out.println(user1);
        }
    }

    /*
     *自定义方法测试
     * @author RenBoQing
     * @date 2022/5/10 0010 14:07
     */
    @Test
    void owenerMethod() {
        List<User> users = userMapper.queryUserByPage((long) 1);
        for (User user : users) {
            System.out.println(user);
        }
    }

    /*
     *IService测试
     * @author RenBoQing
     * @date 2022/5/10 0010 14:44
     */
    @Test
    void servicesTest() {
        List<User> list = userService.list();
        for (User user : list) {
            System.out.println(user);
        }
        //获取总的条数
        long count = userService.count();
        log.info(String.valueOf(count));
    }

    /*
     *  批量添加模式
     *  @author RenBoQing
     *  @date 2022/5/10 0010 17:29
     */
    @Test
    void IserviceTest() {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("大数据" + i);
            user.setAge(20 + i);
            userList.add(user);
        }
        boolean demo = userService.saveBatch(userList);
        System.out.println(demo);
    }

    /*
     *通用QueryMapper测试  多条件查询测试
     * @author RenBoQing
     * @date 2022/5/11 0011 14:01
     */
    @Test
    void QueryMapperTest() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        //    查询用户名包含a，年龄在20到30之间，邮箱不为null的用户信息
        //可以使用多条件查询 链式查询
        userQueryWrapper.like("name", "z").between("age", 20, 30).isNotNull("email");
        //第一个是数据库的列名  第二个是具体的值
        List<User> userList = userMapper.selectList(userQueryWrapper);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    /*
     *通用QueryMapper测试排序查询
     * @author RenBoQing
     * @date 2022/5/11 0011 14:21
     */
    @Test
    void QueryMapperOrderTest() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.orderByDesc("age").orderByAsc("uid");
        List<User> userList = userMapper.selectList(userQueryWrapper);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    /*
     *通用QueryMapper删除测试  逻辑测试
     * @author RenBoQing
     * @date 2022/5/11 0011 14:28
     */
    @Test
    void QueryMapperDeleteTest() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.isNull("email");
        int delete = userMapper.delete(userQueryWrapper);
        System.out.println(delete);
    }

    /*
     *通用QueryMapper更新测试
     * @author RenBoQing
     * @date 2022/5/11 0011 14:45
     */
    @Test
    void QueryMapperUpdateTest() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.gt("age", 20).like("name", "a").or().isNull("email");
        User user = new User();
        user.setName("小明");
        user.setEmail("test@qq.com");
        //前面第一个是参数,后面是查询的条件
        int update = userMapper.update(user, userQueryWrapper);
        System.out.println(update);
    }

    /*
     *优先级策略问题
     * @author RenBoQing
     * @date 2022/5/11 0011 15:16
     */
    @Test
    void QueryMapperOrTest() {
        //  条件优先级策略问题
        //将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
        // Lambda中的条件优先执行
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        //如果使用优先条件查询使用and（i>为具体的条件）
        userQueryWrapper.like("name", "a").and(i -> i.gt("age", 20).isNull("email"));
        User user = new User();
        user.setName("小明");
        user.setEmail("test@qq.com");
        //前面第一个是参数,后面是查询的条件
        int update = userMapper.update(user, userQueryWrapper);
        System.out.println(update);
    }

    /*
     *自定查询字段
     * @author RenBoQing
     * @date 2022/5/11 0011 15:29
     */
    @Test
    void QueryTest() {
        //查询的条件
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        //查询需要的列
        userQueryWrapper.select("name", "age", "email");
        //返回对应的集合
        List<Map<String, Object>> maps = userMapper.selectMaps(userQueryWrapper);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }

    /*
     *QueryWrapper 嵌套子查询
     * @author RenBoQing
     * @date 2022/5/11 0011 16:08
     */
    @Test
    void QueryTest_with() {
        //  查询id小于等于100的用户信息
        QueryWrapper userQueryWrapper = new QueryWrapper();
        //相当于使用内部的sql查询
        userQueryWrapper.inSql("id", "select id  from user where id<=100");
        List<User> list = userMapper.selectList(userQueryWrapper);
        for (User o : list) {
            System.out.println(o);
        }
    }

    /*
     *使用UpdateWarMapper修改数据
     * @author RenBoQing
     * @date 2022/5/11 0011 16:36
     */
    @Test
    void UpdateWarMapper() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper();
        //选择查询的条件
        updateWrapper.like("name", "a").and(i -> i.gt("age", 20).isNotNull("email"));
        //修改需要更新的数据
        updateWrapper.set("name", "小黑").set("email", "abc@qq.com");
        //设置执行条件
        userMapper.update(null, updateWrapper);
    }

    /*
     *测试前端业务多数据查询
     * @author RenBoQing
     * @date 2022/5/11 0011 16:57
     */
    @Test
    void QueryDemoTest() {
        String name = "";
        Integer ageBegins = 30;
        Integer ageEnds = 45;
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        if (StringUtils.isNotBlank(name)) {
            //isNotBlank表示判断当前定位输入是否为空或者
            queryWrapper.like("name", name);
        }
        if (ageBegins != null) {
            queryWrapper.gt("age", ageBegins);
        } else if (ageEnds != null) {
            queryWrapper.le("age", ageBegins);
        }
        List<User> userList = userMapper.selectList(queryWrapper);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    /*
     *使用条件组装查询
     * @author RenBoQing
     * @date 2022/5/12 0012 9:39
     */
    @Test
    void ConditionTest() {
        String name = "";
        Integer ageBegins = 30;
        Integer ageEnds = 45;
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.like(StringUtils.isNotBlank(name), "name", name).
                ge(ageBegins != null, "age", ageBegins).le(ageEnds != null, "age", ageEnds);
        List<User> userList = userMapper.selectList(queryWrapper);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    /*
     *LambdaQueryWrapper查询测试
     * @author RenBoQing
     * @date 2022/5/12 0012 9:50
     */
    @Test
    void LambdaQueryWrapperTest() {
        String name = "";
        Integer ageBegins = 30;
        Integer ageEnds = 45;
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();

        lambdaQueryWrapper.like(StringUtils.isNotBlank(name), User::getName, name).gt(ageBegins != null, User::getAge, ageBegins).le(ageEnds != null, User::getAge, ageEnds);
        List<User> userList = userMapper.selectList(lambdaQueryWrapper);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    /*
     *LambdaUpdateWrapper更新测试
     * @author RenBoQing
     * @date 2022/5/12 0012 10:00
     */
    @Test
    void LambdaUpdateWrapperTest() {
        LambdaUpdateWrapper<User> lambdaQueryWrapper = new LambdaUpdateWrapper<>();
        //选择查询的条件
        lambdaQueryWrapper.like(User::getName, "a").and(i -> i.gt(User::getAge, 20).isNotNull(User::getEmail));
        //修改需要更新的数据
        lambdaQueryWrapper.set(User::getName, "小黑").set(User::getEmail, "wwww@qq.com");
        //设置执行条件
        userMapper.update(null, lambdaQueryWrapper);
    }

    /*
     *分页查询
     * @author RenBoQing
     * @date 2022/5/12 0012 10:25
     */
    @Test
    void PageTest() {
        //里面的泛型 是需要分页的数据 后面的参数是当前页码以及每页展示的条数
        Page<User> userPage = new Page<>(1, 3);
        //前面设置分页的参数  后面传递查询的条件
        Page<User> page = userMapper.selectPage(userPage, null);
        //获取当前页数据
        System.out.println(page.getRecords());
        //获取总
        System.out.println(page.getPages());
        //获取总的记录数
        System.out.println(page.getTotal());
        //获取是否有下一行
        System.out.println(page.hasNext());
        //
        System.out.println(page.hasPrevious());
    }

    /*
     *
     * @author RenBoQing
     * @date 2022/5/12 0012 14:04
     */
    @Test
    void PageVoTest() {
        Page<User> userPage = new Page<>(1, 3);
        Page<User> page = userMapper.selectPageVo(userPage, 20);
        //获取记录
        System.out.println(page.getRecords());
    }

    /*
     *MybatisPlus的通用枚举添加
     * @author RenBoQing
     * @date 2022/5/12 0012 15:30
     */
    @Test
    void InsertTest() {
        User user=new User();
        user.setName("小黑");
        user.setEmail("测试@qq.com");
        user.setSex(SexEnum.MALE);
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }
}