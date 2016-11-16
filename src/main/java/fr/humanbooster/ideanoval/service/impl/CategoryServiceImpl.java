package fr.humanbooster.ideanoval.service.impl;

import fr.humanbooster.ideanoval.business.Category;
import fr.humanbooster.ideanoval.dao.CategoryDao;
import fr.humanbooster.ideanoval.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Nea on 15/11/2016.
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao cd;

    public CategoryServiceImpl() {
    }

    @Override
    public Category findCategoryById(String id) {
        if (id == null) {
            return null;
        } else {
            Category category = cd.findCategoryById(Integer.parseInt(id));
            return category;
        }
    }

    @Override
    public List<Category> getAllCategories() {
        return cd.getAllCategories();
    }
}
