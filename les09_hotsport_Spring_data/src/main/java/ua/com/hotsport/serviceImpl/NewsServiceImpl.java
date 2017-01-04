package ua.com.hotsport.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.hotsport.dao.NewsDao;
import ua.com.hotsport.entity.News;
import ua.com.hotsport.service.NewsService;


@Service
public class NewsServiceImpl implements NewsService{
	@Autowired
	private NewsDao newsDao;

	public void add(News news) {
		newsDao.save(news);
		
	}

	public List<News> findAll() {
		// TODO Auto-generated method stub
		return newsDao.findAll();
	}

	public News findOne(int id) {
		// TODO Auto-generated method stub
		return newsDao.findOne(id);
	}

	public void delete(int id) {
		newsDao.delete(id);
		
	}

	public List<News> findNewsWithCategory() {
		
		return newsDao.findNewsWithCategory();
	}

	public void saveAndFlush(News news) {
		newsDao.saveAndFlush(news);
		
	}

	public List<News> findOneCategoryNews(int id) {
				return newsDao.findOneCategoryNews(id);
	}

	public List<News> findNewsWithDate() {
		LocalDate date = LocalDate.now();
		List<News> allNews = newsDao.findAllNewsWithCAtegories();
		List<News> resultedNews = new ArrayList<News>();
		
		for (News news : allNews) {
			if(news.getDateofPublic().isEqual(date) || news.getDateofPublic().isAfter(date)  ){
				resultedNews.add(news);
			}
		}
		
		return resultedNews;
	}

	public News findDetailedNews(int id) {
		
		return newsDao.findDetailedNews(id);
	}

	public List<News> findAllReturned() {
		List<News> allNews = newsDao.findAll();
	
		List<News> retList = new ArrayList<News>();
		int j = 0;
		for (int i = allNews.size()-1; i >= 0; i--) {
			retList.add(allNews.get(i));
			System.out.println(allNews.get(i));
		}
		
		
		return retList;
	}

	public List<News> sortNewsByDate() {
		List<News> news = findNewsWithDate();
		
		
		return null;
	}

	

	
	
}
