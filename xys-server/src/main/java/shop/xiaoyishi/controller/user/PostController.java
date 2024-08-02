package shop.xiaoyishi.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.xiaoyishi.result.Result;
import shop.xiaoyishi.service.PostService;
import shop.xiaoyishi.vo.PostVO;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user/post")
@Api(tags = "帖子管理")
public class PostController {
    @Autowired
    private PostService postService;

    /**
     * 帖子列表
     * @return
     */
    @GetMapping("/postList")
    @ApiOperation("帖子列表")
    public Result postList(){
        log.info("查询帖子列表");
        List<PostVO> postVOS = postService.postList();
        return Result.success(postVOS);
    }
}
