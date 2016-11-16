package fr.humanbooster.ideanoval.service;

import fr.humanbooster.ideanoval.business.Category;

import java.util.List;

/**
 * Created by Nea on 15/11/2016.
 */
public interface CategoryService {

    public Category findCategoryById(String idCategory);

    public List<Category> getAllCategories();
}
