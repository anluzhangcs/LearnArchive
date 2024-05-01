package dao.impl;

/**
 * @author: zhanghao
 * @date: 2021/11/3-17:17
 */

import bean.Book;
import dao.BookDao;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Description BookDao的接口
 */
public class BookDaoImpl implements BookDao {

    private static QueryRunner runner = new QueryRunner();

    @Override
    public int addBook(Book book) {
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into t_book(name,author,price,sales,stock,img_path) values(?,?,?,?,?,?)";
            return runner.update(conn, sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
}
        return -1;
    }

    @Override
    public int deleteBook(Integer id) {
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete from t_book where id = ?";
            return runner.update(conn, sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override
    public int updateBook(Book book) {
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "update t_book set name=?,author=?,price=?,sales=?,stock=?,img_path=? where id = ?";
            return runner.update(conn, sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(),book.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override
    public Book queryForOne(Integer id) {
        Connection conn = null;
        Book book = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select id,name,author,price,sales,stock,img_path imgPath from t_book where id=?";
            book = runner.query(conn, sql, new BeanHandler<>(Book.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return book;
    }

    @Override
    public List<Book> queryForList() {
        Connection conn = null;
        List<Book> bookList = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select id,name,author,price,sales,stock,img_path imgPath from t_book";
            bookList = runner.query(conn, sql, new BeanListHandler<>(Book.class));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return bookList;
    }

    @Override
    public int queryCount() {
        Connection conn = null;
        long count = 0;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select count(*) from t_book";
            count = (long)runner.query(conn, sql, new ScalarHandler<>());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return (int)count;

    }

    @Override
    public List<Book> queryItems(Integer begin, Integer pageSize) {
        Connection conn = null;
        List<Book> books = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select id,name,author,price,sales,stock,img_path imgPath from t_book limit ?,?";
            books = runner.query(conn, sql, new BeanListHandler<Book>(Book.class), begin, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return books;
    }


    @Override
    public Integer queryCountByPrice(Integer min, Integer max) {
        Connection conn = null;
        long count = 0;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select count(*) from t_book where price between ? and ?";
            count = (long)runner.query(conn, sql, new ScalarHandler<>(), min, max);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return (int)count;
    }

    @Override
    public List<Book> queryListByPrice(Integer min, Integer max, int begin, Integer pageSize) {
        Connection conn = null;
        List<Book> books = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select id,name,author,price,sales,stock,img_path imgPath from t_book where price between ? and ? order by price limit ?,?";
            books = runner.query(conn, sql, new BeanListHandler<Book>(Book.class),min,max,begin, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return books;
    }
}
