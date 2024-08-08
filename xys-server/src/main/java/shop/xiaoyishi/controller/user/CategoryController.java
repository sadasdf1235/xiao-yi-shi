package shop.xiaoyishi.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.xiaoyishi.result.Result;
import shop.xiaoyishi.service.CategoryService;
import shop.xiaoyishi.vo.CategoryVO;

import java.util.List;

@RestController
@Slf4j
@Api(tags = "分类管理")
@RequestMapping("/user/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @ApiOperation("首页分类数据")
    @GetMapping("/firstCategory")
    public Result<List<CategoryVO>> homeCategory(){
        log.info("获取一级分类");
        List<CategoryVO> firstCategory = categoryService.firstCategory();
        return Result.success(firstCategory);
    }

    @ApiOperation("二级分类数据")
    @GetMapping("/secondCategory")
    public Result<List<CategoryVO>> secondCategory(Long id){
        log.info("获取二级分类：{}",id);
        List<CategoryVO> secondCategory = categoryService.secondCategory(id);
        return Result.success(secondCategory);
    }
}
