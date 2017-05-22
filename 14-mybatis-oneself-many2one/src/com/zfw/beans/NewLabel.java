package com.zfw.beans;

import java.util.Set;
/*把当前类当作多方*/
public class NewLabel {
	private Integer id;
	private String name;
	/*指定父栏目，即指定一方*/
	private NewLabel parent;

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

	@Override
	public String toString() {
		return "NewLabel [id=" + id + ", name=" + name + ", parent=" + parent + "]";
	}

	public NewLabel getParent() {
		return parent;
	}

	public void setParent(NewLabel parent) {
		this.parent = parent;
	}

}
