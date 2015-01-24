package com.anikamcrae;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anikamcrae.mongo.domain.Customer;
import com.anikamcrae.mongo.repository.CustomerRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{

	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CustomerRepository repo;
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {
    	// 1. download mongodb zip and unzip it.
    	// 2. Download Mongo DB viewer MongoVue
    	// 3. Run MongoDB: c:\dev\tools\mongodb\bin\mongod.exe --dbpath c:\dev\tools\mongodb\data
    	// 4. Launch MongoVue.  ConnectionName:testdb  Server:localhost   Port:27017   Database:testdb
    	
    	log.info("Application run");
    	repo.deleteAll();
    	
    	Customer alice = new Customer("Alice", "Smith");
    	Customer bob = new Customer("Bob", "Smith");
    	
    	repo.save(alice);
    	repo.save(bob);
    }
}
