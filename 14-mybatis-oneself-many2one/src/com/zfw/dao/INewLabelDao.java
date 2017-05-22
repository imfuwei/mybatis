package com.zfw.dao;

import java.util.List;
import java.util.Set;

import com.zfw.beans.NewLabel;

public interface INewLabelDao {
	List<NewLabel> selectNewLabelById(int pid);
}
