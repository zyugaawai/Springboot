package wai.springboot.demo;

import java.nio.charset.Charset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
@Configuration
public class HelloApplication {
	
	@RequestMapping("hello")
	@ResponseBody
	public String sayHello() {
		return "hello world你好";
	}
	
	//消息转换器，默认utf-8
//	@Bean
//	public StringHttpMessageConverter stringHttpMessageConverter() {
//		StringHttpMessageConverter converter = 
//				new StringHttpMessageConverter(Charset.forName("ISO-8859-1"));
//		return converter;
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(HelloApplication.class, args);
	}

}
