package com.spr.service;

import java.util.List;

import com.spr.exception.ShopNotFound;
import com.spr.model.Shop;

public interface ShopService {
	
	Shop create(Shop shop);
	List<Shop> findAll();
	Shop findById(int id);
}
