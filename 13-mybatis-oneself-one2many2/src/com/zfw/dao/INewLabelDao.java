package com.zfw.dao;

import java.util.List;

import com.zfw.beans.NewLabel;

public interface INewLabelDao {
	List<NewLabel> selectNewLabelById(int id);
}
