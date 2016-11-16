package fr.humanbooster.ideanoval.dao;

import fr.humanbooster.ideanoval.business.Category;

import java.util.List;

/**
 * Created by Nea on 15/11/2016.
 */
public interface CategoryDao {

    public Category findCategoryById(int id);

    public List<Category> getAllCategories();
}
