package com.mycompany.springmvctest.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.mycompany.springmvctest.dao.GenericDAO;
import com.mycompany.springmvctest.mapper.RowMapper;
import com.mycompany.springmvctest.model.NewModel;
import java.util.Date;

public class AbstractDAO<T> implements GenericDAO<T> {

	public Connection getConnection() 
        {
            
            Connection con=null;
            String url="jdbc:sqlserver://DESKTOP-QK1KP4V\\SQLMINHTO:1433;databaseName=SHOP";
        try {
                
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con=DriverManager.getConnection(url,"minhto","123");
                
            } catch (ClassNotFoundException ex) {
                System.out.println("Class not found "+ex.getMessage());
            } catch (SQLException ex) {
                System.out.println("SQL error");
            }
       
        return con;
	}

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> results = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				results.add(rowMapper.mapRow(resultSet)); // lây ra từng row sau đó ánh xạ từng dòng thành Mảng T Model
			}
			return results;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
	}

	private void setParameter(PreparedStatement statement, Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
                                
				if (parameter instanceof Long) {
					statement.setLong(index, (Long) parameter);
				} else if (parameter instanceof String) {
					statement.setString(index, (String) parameter);
				} else if (parameter instanceof Integer) {
					statement.setInt(index, (Integer) parameter);
				} else if (parameter instanceof Timestamp) {
					statement.setTimestamp(index, (Timestamp) parameter);
				}
                                else if (parameter instanceof java.sql.Date ) {
					statement.setDate(index, (java.sql.Date) parameter);
				}
                                // đừng để dữ liệu null ==>xử lí đầu vào trước khi truy vấn                           
			}
		} catch(SQLException e) {
			e.printStackTrace();         
		}
	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			if (connection != null) {
				try {   
                                        System.out.println(e.getMessage());
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			Long id = null;
			connection = getConnection();
			connection.setAutoCommit(false);
                        String []arrAuto={"id"};
			statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			setParameter(statement, parameters);//gan tham so truy van
                       
			int affectRow=statement.executeUpdate();
                        System.out.println("effectedRow: "+affectRow);
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getLong(1);
			}
			connection.commit();
			return id;
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}
        public Long insertNew(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			Long id = null;
			connection = getConnection();
			connection.setAutoCommit(false);
                        String []arrAuto={"id"};
			statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			//setParameter(statement, parameters);
                        statement.setString(1, (String)parameters[0]);
                        System.out.println((String)parameters[0]);
                        
                        statement.setString(2,(String) parameters[1]);
                         System.out.println((String)parameters[1]);
                         
                        statement.setString(3,(String) parameters[2]);                     
                         System.out.println((String)parameters[2]);
                         
                        statement.setString(4, (String)parameters[3]);             
                         System.out.println((String)parameters[3]);
          
                        statement.setLong(5, (Long)((Object) parameters[4]));
                        System.out.println((Long)((Object) parameters[4]));
                        
                        statement.setDate(6, (java.sql.Date)parameters[5]);
                         System.out.println("(java.sql.Date)parameters[5]"+(java.sql.Date)parameters[5]);
                         
                          statement.setString(7, (String)parameters[6]);
                         System.out.println("(String)parameters[6] :"+(String)parameters[6]);
                         
                          statement.setDate(8, (java.sql.Date) parameters[7]);
                         System.out.println("(java.sql.Date)parameters[7] :"+(java.sql.Date)parameters[7]);
			int affectRow=statement.executeUpdate();
                        System.out.println("effectedRow: "+affectRow);
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getLong(1);
			}
			connection.commit();
			return id;
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public int count(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			int count = 0;
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			return 0;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return 0;
			}
		}
	}
     
}
