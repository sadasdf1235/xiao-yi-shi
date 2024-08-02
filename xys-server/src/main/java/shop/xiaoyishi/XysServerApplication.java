package shop.xiaoyishi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement //开启注解方式的事务管理
@EnableConfigurationProperties
@ConfigurationPropertiesScan
@Slf4j
@EnableCaching  // 开启spring cache 缓存注解功能
@EnableScheduling // 开启spring Task
public class XysServerApplication {

	public static void main(String[] args) {

		SpringApplication.run(XysServerApplication.class, args);
		log.info("server started");
	}

}
