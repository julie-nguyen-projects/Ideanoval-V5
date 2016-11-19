package fr.humanbooster.ideanoval.dao.impl;

import fr.humanbooster.ideanoval.business.Category;
import fr.humanbooster.ideanoval.dao.CategoryDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Nea on 15/11/2016.
 */
@Repository
@Primary
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private SessionFactory sf;

    public CategoryDaoImpl() {
    }

    public CategoryDaoImpl(SessionFactory sessionFactory) {
    }

    @Override
    public Category findCategoryById(int id) {
        return sf.getCurrentSession().byId(Category.class).load(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return sf.getCurrentSession().createQuery("FROM Category").getResultList();
    }
}
