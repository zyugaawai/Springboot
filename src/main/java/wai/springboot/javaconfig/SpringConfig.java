package wai.springboot.javaconfig;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
@ComponentScan(basePackages = "wai.springboot.javaconfig")
@PropertySource(value = {"classpath:jdbc.properties"}, ignoreResourceNotFound = true)
public class SpringConfig {
	
	@Bean
	public UserDao getUserDao() {
		return new UserDao();
	}
	
	@Value("${jdbc.url}")
	private String jdbcUrl;
	
	@Value("${jdbc.driver}")
	private String jdbcDriver;
	
	@Value("${jdbc.username}")
	private String jdbcUsername;
	
	@Value("${jdbc.password")
	private String jdbcPassword;
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		BoneCPDataSource dataSource = new BoneCPDataSource();
		dataSource.setJdbcUrl(jdbcUrl);
		dataSource.setDriverClass(jdbcDriver);
		dataSource.setUsername(jdbcUsername);
		dataSource.setPassword(jdbcPassword);
		dataSource.setIdleConnectionTestPeriodInMinutes(60);
		dataSource.setIdleMaxAgeInMinutes(30);
		dataSource.setMaxConnectionsPerPartition(100);
		dataSource.setMinConnectionsPerPartition(5);
		
		return dataSource();
	}
}
