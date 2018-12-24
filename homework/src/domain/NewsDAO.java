package domain;

import java.util.List;

import model.NewsBean;

public interface NewsDAO {

	List<NewsBean> select(String stock_id);

	NewsBean insert(NewsBean bean);
	
	Boolean matchWebsite(String news_website);

}