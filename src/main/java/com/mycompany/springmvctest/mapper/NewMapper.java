package com.mycompany.springmvctest.mapper;

import com.mycompany.springmvctest.model.NewModel;
import java.sql.ResultSet;
import java.sql.SQLException;



public class NewMapper implements RowMapper<NewModel> {

	@Override
	public NewModel mapRow(ResultSet resultSet) { // lấy dữ liệu từ ResultSet và ánh xạ qua Model sau đó return Model
		try {
			NewModel news = new NewModel();
			news.setId(resultSet.getLong("id"));
			news.setTitle(resultSet.getString("title"));
			news.setContent(resultSet.getString("content"));
			news.setCategoryId(resultSet.getLong("categoryid"));
			news.setThumbnail(resultSet.getString("thumbnail"));
			news.setShortDescription(resultSet.getString("shortdescription"));
			news.setCreatedDate(resultSet.getDate("createddate"));
			news.setCreatedBy(resultSet.getString("createdby"));
			if (resultSet.getDate("modifielddate") != null) {
				news.setModifiedDate(resultSet.getDate("modifielddate"));
			}
			if (resultSet.getString("modifiedby") != null) {
				news.setModifiedBy(resultSet.getString("modifiedby"));
			}
			return news;
		} catch (SQLException e) {
			return null;
		}	
	}
}
