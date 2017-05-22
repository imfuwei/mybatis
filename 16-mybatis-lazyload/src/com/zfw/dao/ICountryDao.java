package com.zfw.dao;

import com.zfw.beans.Country;

public interface ICountryDao {
	public Country selectCountryById(int id);
}
