package shop.xiaoyishi.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.xiaoyishi.constant.CollectType;
import shop.xiaoyishi.constant.MessageConstant;
import shop.xiaoyishi.result.Result;
import shop.xiaoyishi.service.CollectService;
<<<<<<< HEAD
import shop.xiaoyishi.vo.CollectCPVO;
import shop.xiaoyishi.vo.CollectVO;
=======
>>>>>>> af0e12bd043a253d8c6797b54bf608e6be2ff7ed
import shop.xiaoyishi.vo.CommodityVO;
import shop.xiaoyishi.vo.PostVO;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user/collect")
@Api(tags = "收藏管理")
public class CollectController {
    @Autowired
    private CollectService collectService;

    /**
     * 查询收藏数量
     * @return
     */
    @GetMapping("/count")
    @ApiOperation("收藏数量")
    public Result count(Long userId){
        log.info("查询收藏数量 {}",userId);

        Integer follow = collectService.countCollect(userId);
        return Result.success(follow);
    }

    /**
     * 收藏列表
     * @param userId
     * @return
     */
<<<<<<< HEAD
    @GetMapping("/cpList")
    @ApiOperation("收藏列表")
    public Result collectCPList(Long userId, Integer type){
        log.info("查询收藏列表 {}", userId);
        List<CommodityVO> commodities = collectService.commodities(userId);
        List<PostVO> posts = collectService.posts(userId);
        return switch (type) {
            case 0 -> Result.success(new CollectCPVO(commodities,posts));
            case 1 -> Result.success(new CollectCPVO(commodities,null));
            case 2 -> Result.success(new CollectCPVO(null,posts));
            default -> {
                log.warn("Unsupported type: {}", type);
                yield Result.error("Unsupported type");
            }
        };
    }

    /**
     * 收藏列表
     * @param userId
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("收藏列表")
    public Result collectList(Long userId, Integer type){
        log.info("查询收藏列表 {}", userId);
        log.info("收藏类型 {}", type);
        List<CollectVO> collectVOS = collectService.collectList(userId,type);
        log.info("收藏类型 {}", collectVOS);
        return Result.success(collectVOS);
=======
    @GetMapping("/list")
    @ApiOperation("收藏列表")
    public Result collectList(Long userId,String type){
        log.info("查询收藏列表 {}",userId);
        // 收藏帖子 收藏商品
        if(type.equals(CollectType.COMMODITY)){
            List<CommodityVO> commodityVOList = collectService.collectCommodity(userId);
            return Result.success(commodityVOList);
        } else if (type.equals(CollectType.POST)) {
            List<PostVO> postVOList = collectService.collectPost(userId);
            return Result.success(postVOList);
        }
        return Result.error(MessageConstant.TYPE_NOT_FOUND);
>>>>>>> af0e12bd043a253d8c6797b54bf608e6be2ff7ed
    }
}
