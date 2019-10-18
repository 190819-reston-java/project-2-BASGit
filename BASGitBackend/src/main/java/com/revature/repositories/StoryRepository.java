package com.revature.repositories;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
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
import com.revature.models.Story;
import com.revature.models.User;

@Repository
public class StoryRepository {

	@Autowired
	private SessionFactory sf;

	@Transactional
	public Story findOne(int id) {
		Session s = sf.getCurrentSession();
		return (Story) s.get(Story.class, id);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Story> findAll() {
		Session s = sf.getCurrentSession();

		return s.createCriteria(Story.class).addOrder(Order.asc("id")).list();

	}

	@Transactional
	public Story save(Story story) {
		Session s = sf.getCurrentSession();

		s.saveOrUpdate(story);

		return story;
	}

	@Transactional
	public Story createNew(Story story, File file) {
		Session s = sf.getCurrentSession();

		User u = (User) s.get(User.class, story.getAuthor().getId());
		story.setAuthor(u);

		if (file != null) {
			story.setPictureURL(uploadImage(file, story));
		}
		
		s.saveOrUpdate(story);

		return story;

	}

	private String uploadImage(File file, Story s) {

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

		String fileLocationForBucket = "/story" + s.getId();

		createFolder("allen-gworek-llc-image-storage", fileLocationForBucket, s3client);

		fileLocationForBucket += "/image.png";
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
	public Story highlight(Story story) {
		Session s = sf.getCurrentSession();
		
		story.setFeatured(true);
		
		return story;
	}

	@Transactional
	public void delete(Story story) {
		Session s = sf.getCurrentSession();
		
		s.delete(story);
		
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Story> findAllByAuthor(int id) {
		Session s = sf.getCurrentSession();
		
		return (List<Story>) s.createCriteria(Story.class)
				.add(Restrictions.eq("author.id", id)).addOrder(Order.asc("id"))
				.list();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Story> findAllFeatured() {
		Session s = sf.getCurrentSession();
		
		return (List<Story>) s.createCriteria(Story.class)
				.add(Restrictions.eq("isFeatured", true))
				.addOrder(Order.asc("id")).list();
	}

	@Transactional
	public List<Story> findAllOrderByUserID() {
		Session s = sf.getCurrentSession();
		
		return (List<Story>) s.createCriteria(Story.class)
				.addOrder(Order.asc("author")).list();
	}
}
