/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvctest.config;

import com.mycompany.springmvctest.utils.PropertiseUtil;
import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author MinhTo
 */
@Configuration
@EnableJpaRepositories(basePackages ={"com.mycompany.springmvctest.repository"}) // hoặc dể @Repository trên class trong gói repository
@EnableTransactionManagement
public class JPAConfig {

    private static PropertiseUtil propertiesUtil = new PropertiseUtil();

    private static String url = propertiesUtil.getValue("url", "jdbc:sqlserver://DESKTOP-QK1KP4V\\SQLMINHTO:1433;databaseName=TinTucSpring");
    private static String driver = propertiesUtil.getValue("driver", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
    private static String username = propertiesUtil.getValue("username", "minhto");
    private static String password = propertiesUtil.getValue("password", "minhto123");
    private final String PROPERTY_SHOW_SQL = propertiesUtil.getValue("PROPERTY_SHOW_SQL", "hibernate.show_sql");
    private final String PROPERTY_DIALECT = propertiesUtil.getValue("PROPERTY_DIALECT", "hibernate.dialect");

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl(url);
        ds.setDriverClassName(driver);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean lfb = new LocalContainerEntityManagerFactoryBean();
        lfb.setDataSource(dataSource());
        //set Persistence 
        lfb.setPersistenceUnitName("persistence-data");
        // lfb.setPersistenceProviderClass(HibernatePersistence.class);
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        lfb.setJpaVendorAdapter(vendorAdapter);
        lfb.setPackagesToScan("com.mycompany.springmvctest");
        lfb.setJpaProperties(additionalJpaProperties());
            return lfb;

    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    private Properties additionalJpaProperties() {
        Properties properties = new Properties();
    // properties.setProperty("hibernate.hbm2ddl.auto", "create");
     properties.setProperty("hibernate.dialect","org.hibernate.dialect.SQLServer2012Dialect");
       properties.setProperty("hibernate.show_sql", "true");
       properties.setProperty("hibernate.hbm2ddl.auto", "none");
       properties.setProperty("hibernate.format_sql", "true");
         properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
        return properties;
    }
    /*Properties hibernateProps() {
		Properties properties = new Properties();
		properties.setProperty(PROPERTY_DIALECT, environment.getProperty(PROPERTY_DIALECT));
		properties.setProperty(PROPERTY_SHOW_SQL, environment.getProperty(PROPERTY_SHOW_SQL));
		return properties;
	}*/

 /*
@Bean
public PlatformTransactionManager txManager() {
    return new DataSourceTransactionManager(dataSource()); // (2)
}*/
    //----------------Proxy
    //But it is not the proxy itself handling all this transactional state (open, commit, close), 
    //the proxy delegates that work to a transaction manager.
    //Spring offers you a PlatformTransactionManager / TransactionManager interface,    
    //by default, comes with a couple of handy implementations. 
    //One of them is the datasource "Transaction manager".
    //----------------@Transactional
    //1.Nếu Spring phát hiện chú thích @Transactional trên bean, nó sẽ tạo ra một proxy động của bean đó.
    //2.Proxy có quyền truy cập vào một trình quản lý giao dịch(Transaction Manager)
    //và sẽ yêu cầu nó mở và đóng các giao dịch / kết nối
    ///3.Bản thân trình quản lý giao dịch sẽ đơn giản làm những gì bạn đã làm trong phần Java thuần túy: 
    //Quản lý kết nối JDBC cũ, tốt.
}
