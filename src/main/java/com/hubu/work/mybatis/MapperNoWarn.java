
package com.hubu.work.mybatis;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import tk.mybatis.mapper.autoconfigure.MapperAutoConfiguration;
import tk.mybatis.mapper.autoconfigure.MybatisProperties;

@Configuration
class MapperNoWarn extends MapperAutoConfiguration {

  public MapperNoWarn(MybatisProperties properties,
                      ObjectProvider<org.apache.ibatis.plugin.Interceptor[]> interceptorsProvider, ResourceLoader resourceLoader,
                      ObjectProvider<org.apache.ibatis.mapping.DatabaseIdProvider> databaseIdProvider,
                      ObjectProvider<java.util.List<tk.mybatis.mapper.autoconfigure.ConfigurationCustomizer>> configurationCustomizersProvider) {
    super(properties, interceptorsProvider, resourceLoader, databaseIdProvider, configurationCustomizersProvider);
  }
}