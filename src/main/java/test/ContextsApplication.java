package test;

import com.gemstone.gemfire.cache.Cache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.LocalRegionFactoryBean;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;
import org.springframework.data.gemfire.support.GemfireCacheManager;

@EnableCaching
@EnableGemfireRepositories
@SpringBootApplication
public class ContextsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContextsApplication.class, args);
    }

    @Bean
    String foo() {
        return "foo";
    }

    @Bean
    CacheFactoryBean cacheFactoryBean() {
        return new CacheFactoryBean();
    }

    @Bean
    LocalRegionFactoryBean<String, String> defaultRegionFactoryBean(
            final Cache cache) {
        return new LocalRegionFactoryBean<String, String>() {
            {
                setCache(cache);
                setName("default");
            }
        };
    }

    @Bean
    GemfireCacheManager cacheManager(final Cache gemfireCache) {
        return new GemfireCacheManager() {
            {
                setCache(gemfireCache);
            }
        };
    }

}
