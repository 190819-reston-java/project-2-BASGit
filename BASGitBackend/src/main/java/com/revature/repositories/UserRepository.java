package com.revature.repositories;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.revature.models.User;

@Repository
public class UserRepository  {
	
	@Autowired
	private SessionFactory sf;
	

	
	@Transactional
	public User findOne(int id) {
		Session s = sf.getCurrentSession();
		return (User) s.get(User.class, id);
	}

	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> findAll(){
		Session s = sf.getCurrentSession();
		
		return s.createCriteria(User.class).list();
		
	}

	
	@Transactional
	public User save(User user) {
		Session s = sf.getCurrentSession();
		
		s.saveOrUpdate(user);
		
		return user;
	}


	@Transactional
	public User findByUserName(String username) {
		Session s = sf.getCurrentSession();
		
		return (User) s.createCriteria(User.class)
				.add(Restrictions.eq("username", username))
				.list().get(0);
	}
	

	public String uploadImage(File file, User u) {
		
		if (file == null) {
			return "";
		}

		Properties props = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try {
			props.load(loader.getResourceAsStream("credentials.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}

		String AWSKey = props.getProperty("AWSAccessKeyId");
		String AWSKeySecret = props.getProperty("AWSSecretKey");
		BasicAWSCredentials credentials = new BasicAWSCredentials(AWSKey, AWSKeySecret);

		AmazonS3 s3client = new AmazonS3Client(credentials);

		String fileLocationForBucket = "/user" + u.getId();

		createFolder("allen-gworek-llc-image-storage", fileLocationForBucket, s3client);

		fileLocationForBucket += "/avatar.png";
		s3client.putObject(new PutObjectRequest("allen-gworek-llc-image-storage", fileLocationForBucket, file)
				.withCannedAcl(CannedAccessControlList.PublicRead));

		return "https://allen-gworek-llc-image-storage.s3.amazonaws.com" + fileLocationForBucket;
	}

	public static void createFolder(String bucketName, String folderName, AmazonS3 client) {
		// create meta-data for your folder and set content-length to 0
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(0);
		// create empty content
		InputStream emptyContent = new ByteArrayInputStream(new byte[0]);
		// create a PutObjectRequest passing the folder name suffixed by /
		PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, folderName + "/", emptyContent, metadata);
		// send request to S3 to create folder
		client.putObject(putObjectRequest);
	}


	@Transactional
	public User findByUserNameAndPassword(String username, String password) {
		Session s = sf.getCurrentSession();
		
		return (User) s.createCriteria(User.class)
				.add(Restrictions.eq("username", username))
				.add(Restrictions.eq("password", password)).list().get(0);
	}

}
