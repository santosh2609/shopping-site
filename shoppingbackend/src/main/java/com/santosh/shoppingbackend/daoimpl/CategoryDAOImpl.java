package com.santosh.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.santosh.shoppingbackend.dao.CategoryDAO;
import com.santosh.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	public static List<Category> categories = new ArrayList<Category>();
	static {
		Category category = new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("Television DESC");
		category.setImageURL("image1.png");
		Category category1 = new Category();
		category1.setId(2);
		category1.setName("Mobile");
		category1.setDescription("Mobile DESC");
		category1.setImageURL("image1.png");
		Category category2 = new Category();
		category2.setId(3);
		category2.setName("Laptop");
		category2.setDescription("Laptop DESC");
		category2.setImageURL("image1.png");
		Category category3 = new Category();
		category3.setId(4);
		category3.setName("PSP");
		category3.setDescription("PSP DESC");
		category3.setImageURL("image1.png");
		Category category4 = new Category();
		category4.setId(5);
		category4.setName("Ipod");
		category4.setDescription("Ipod DESC");
		category4.setImageURL("image1.png");
		
		
		categories.add(category);
		categories.add(category1);
		categories.add(category2);
		categories.add(category3);
		categories.add(category4);
	}
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}
	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub		
		for (Category category : categories) {
			if (category.getId() == id) {
				return category;
			}	
		}
		return null;
	}

}
