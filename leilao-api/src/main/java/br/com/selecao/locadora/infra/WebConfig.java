package br.com.selecao.locadora.infra;

import br.com.selecao.locadora.converter.CompradorIdConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Autowired
  private CustomInterceptor customInterceptor;

  @Autowired
  private CompradorIdConverter compradorIdConverter;

  @Override
  public void addFormatters(FormatterRegistry registry) {
    registry.addConverter(compradorIdConverter);
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(customInterceptor).addPathPatterns("/**");
  }
}
