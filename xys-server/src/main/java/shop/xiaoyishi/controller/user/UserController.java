package shop.xiaoyishi.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import shop.xiaoyishi.constant.JwtClaimsConstant;
import shop.xiaoyishi.constant.MessageConstant;
import shop.xiaoyishi.dto.UserRegisterDTO;
import shop.xiaoyishi.entity.User;
import shop.xiaoyishi.properties.JwtProperties;
import shop.xiaoyishi.result.Result;
import shop.xiaoyishi.service.*;
import shop.xiaoyishi.utils.JwtUtil;
import shop.xiaoyishi.vo.UserVO;
import shop.xiaoyishi.vo.UserLoginVO;
import shop.xiaoyishi.dto.UserLoginDTO;

import java.util.HashMap;

@RestController
@Slf4j
@RequestMapping("/user/user")
@Api(tags = "用户管理")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProperties jwtProperties;
    @Autowired
    private FollowService followService;
    @Autowired
    private CollectService collectService;
    @Autowired
    private HistoryService historyService;
    @Autowired
    private PostService postService;

    /**
     * 用户登录
     * @return
     */
    @PostMapping("/login")
    @ApiOperation("用户登录")
    public Result login(@RequestBody UserLoginDTO userLoginDTO){
        log.info("用户登录 {}",userLoginDTO);

        User user = userService.login(userLoginDTO);

        HashMap<String,Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID,user.getUserId());

        String secretKey = jwtProperties.getUserSecretKey();
        String token = JwtUtil.createJWT(secretKey,jwtProperties.getUserTtl(),claims);
        UserLoginVO userLoginVO = UserLoginVO.builder()
                .id(Long.valueOf(user.getUserId()))
                .token(token)
                .build();
        return Result.success(userLoginVO);
    }

    /**
     * 用户注册
     * @return
     */
    @PostMapping("/register")
    @ApiOperation("用户注册")
    public Result login(@RequestBody UserRegisterDTO userRegisterDTO){
        log.info("用户注册 {}",userRegisterDTO);

        userService.register(userRegisterDTO);

        return Result.success(MessageConstant.REGISTER_SUCCESS);
    }

    /**
     * 查询用户信息
     * @return
     */
    @GetMapping("/userinfo")
    @ApiOperation("查询用户信息")
    public Result userInfo(Long userId){
        // TODO 优化
        log.info("查询用户信息 {}",userId);

        UserVO userVO = new UserVO();

        User user = userService.userInfo(userId);
        BeanUtils.copyProperties(user,userVO);
        Integer bean = followService.countBean(userId);
        Integer follow = followService.countFollow(userId);
        Integer collect = collectService.countCollect(userId);
        Integer history = historyService.countHistory(userId);
        Integer post = postService.countPost(userId);
        userVO.setBeans(bean);
        userVO.setFollows(follow);
        userVO.setCollects(collect);
        userVO.setHistories(history);
        userVO.setPosts(post);
        return Result.success(userVO);
    }
}
