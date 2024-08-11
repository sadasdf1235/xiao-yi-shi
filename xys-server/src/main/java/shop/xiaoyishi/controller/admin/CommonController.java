package shop.xiaoyishi.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import shop.xiaoyishi.constant.MessageConstant;
import shop.xiaoyishi.result.Result;
import shop.xiaoyishi.utils.AliOssUtil;

import java.io.IOException;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/common")
@Api(tags = "公共接口")
public class CommonController {
    @Autowired
    private AliOssUtil aliOssUtil;

    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @ApiOperation("文件上传")
    public Result<String> upload(MultipartFile file){
        log.info("文件上传 {}",file);
        try {
            // 获取原始文件名
            String originalFilename = file.getOriginalFilename();
            // 获取文件扩展名
            String ex = originalFilename.substring(originalFilename.lastIndexOf("."));
            // 生成文件名
            String fileName = UUID.randomUUID() + ex;
            String filePath = aliOssUtil.upload(file.getBytes(),fileName);
            return Result.success(filePath);
        } catch (IOException e) {
            log.info("文件上传失败 {}",e);
        }
        return  Result.error(MessageConstant.UPLOAD_FAILED);
    }
}

