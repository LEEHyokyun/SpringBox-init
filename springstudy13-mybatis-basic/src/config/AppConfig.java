package config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;


@Configuration
@ComponentScan("org.kosta.myproject")
public class AppConfig {
	@Bean //return 객체를 bean으로 등록
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
		dataSource.setUsername("scott");
		dataSource.setPassword("tiger");
		
		return dataSource;
	}
	
	//MyBatis 설정
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		//getResource, SQL 일괄 로딩
		Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:/mappers/*Mapper.xml");
		sessionFactory.setMapperLocations(res);
		//class 명으로만 클래스를 확보할 수 있도록 설정
		sessionFactory.setTypeAliasesPackage("org.kosta.myproject.model");
		
		return sessionFactory.getObject();
	}
	
	//Spring, MyBatis 연동
	//SqlSessionTemplate : AOP 기반 Transaction 지원
	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
