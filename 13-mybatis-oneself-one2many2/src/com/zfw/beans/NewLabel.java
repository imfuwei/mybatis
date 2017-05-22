package com.zfw.beans;

import java.util.Set;
/*把当前类当作一方*/
public class NewLabel {
	private Integer id;
	private String name;
	/*指定子栏目，即指定多方*/
	private Set<NewLabel> chirdren;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<NewLabel> getNewLabels() {
		return chirdren;
	}

	public void setNewLabels(Set<NewLabel> chirdren) {
		this.chirdren = chirdren;
	}

	@Override
	public String toString() {
		return "NewLabel [id=" + id + ", name=" + name + ", newLabels=" + chirdren + "]";
	}
}
