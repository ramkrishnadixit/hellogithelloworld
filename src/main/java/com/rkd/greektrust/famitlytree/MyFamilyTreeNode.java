package com.rkd.greektrust.famitlytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyFamilyTreeNode {
	private String person = null;
	private String spouse = null;
	private boolean isMale = false;
	private List<MyFamilyTreeNode> children = new ArrayList<MyFamilyTreeNode>();
	private MyFamilyTreeNode parent = null;

	public MyFamilyTreeNode(String person, String spouse, boolean isMale) {
		this.person = person;
		this.spouse = spouse;
		this.isMale = isMale;
	}

	public MyFamilyTreeNode() {
	}

	public void traverse(MyFamilyTreeNode node) {
		System.out.println("person " + node.getPerson());
		System.out.println("spouse " + node.getSpouse());
		List<MyFamilyTreeNode> children = node.getChildren();

		for (MyFamilyTreeNode child : children) {
			traverse(child);
		}

		System.out.println();
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public void setChildren(List<MyFamilyTreeNode> children) {
		this.children = children;
	}

	public MyFamilyTreeNode findNode(String name) {

		MyFamilyTreeNode result = null;
		if ((this.person != null && this.getPerson().equalsIgnoreCase(name))
				|| (this.getSpouse() != null && this.getSpouse().equalsIgnoreCase(name))) {
			result = this;
		} else {

			List<MyFamilyTreeNode> children = this.getChildren();
			if (children == null || children.size() == 0) {
				result = null;
			} else {
				for (MyFamilyTreeNode child : children) {
					result = child.findNode(name);
					if (result != null) {
						break;
					}
				}
			}

		}
		return result;

	}

	public void addChild(MyFamilyTreeNode child) {
		child.setParent(this);
		this.children.add(child);
	}

	public void addChild(String person, String spouse, boolean isMale) {
		MyFamilyTreeNode newChild = new MyFamilyTreeNode(person, spouse, isMale);
		this.addChild(newChild);
	}

	public void addChildren(List<MyFamilyTreeNode> list) {
		for (MyFamilyTreeNode t : list) {
			t.setParent(this);
		}
		this.children.addAll(list);
	}

	public List<MyFamilyTreeNode> getChildren() {
		return children;
	}

	public String getPerson() {
		return person;
	}

	public String getSpouse() {
		return spouse;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public void setSpouse(String spouse) {
		this.spouse = spouse;
	}

	private void setParent(MyFamilyTreeNode parent) {
		this.parent = parent;
	}

	public MyFamilyTreeNode getParent() {
		return parent;
	}

	public List<MyFamilyTreeNode> getRelationship(String name, String relationship) {

		List<MyFamilyTreeNode> list = new ArrayList<MyFamilyTreeNode>();
		MyFamilyTreeNode node = this.findNode(name);
		if (node != null) {
			if ("Paternal-Uncle".equalsIgnoreCase(relationship)) {
				list = getPaternalUncles(node, name);
			} else if ("Maternal-Uncle".equalsIgnoreCase(relationship)) {
				list = getMaternalUncles(node, name);
			} else if ("Paternal-Aunt".equalsIgnoreCase(relationship)) {
				list = getPaternalAunts(node, name);
			}

		}
		return list;

	}

	public List<MyFamilyTreeNode> getPaternalUncles(MyFamilyTreeNode node, String name) {
		List<MyFamilyTreeNode> list = new ArrayList<MyFamilyTreeNode>();
		if (node.getPerson().equalsIgnoreCase(name)) {
			MyFamilyTreeNode parent = node.getParent();
			if (parent.isMale()) {
				MyFamilyTreeNode grandParent = parent.getParent();
				if (grandParent != null && parent != null) {
					for (MyFamilyTreeNode child : grandParent.getChildren()) {
						if (child.isMale() == true && !(parent.getPerson().equalsIgnoreCase(child.getPerson()))) {
							list.add(child);
						}
					}
				}
			}
		}
		return list;
	}
	
	public List<MyFamilyTreeNode> getPaternalAunts(MyFamilyTreeNode node, String name) {
		List<MyFamilyTreeNode> list = new ArrayList<MyFamilyTreeNode>();
		if (node.getPerson().equalsIgnoreCase(name)) {
			MyFamilyTreeNode parent = node.getParent();
			if (parent.isMale()) {
				MyFamilyTreeNode grandParent = parent.getParent();
				if (grandParent != null && parent != null) {
					for (MyFamilyTreeNode child : grandParent.getChildren()) {
						if (!child.isMale() == true && !(parent.getPerson().equalsIgnoreCase(child.getPerson()))) {
							list.add(child);
						}
					}
				}
			}
		}
		return list;
	}


	public List<MyFamilyTreeNode> getMaternalUncles(MyFamilyTreeNode node, String name) {
		List<MyFamilyTreeNode> list = new ArrayList<MyFamilyTreeNode>();
		if (node.getPerson().equalsIgnoreCase(name)) {
			MyFamilyTreeNode parent = node.getParent();
			if (!parent.isMale()) {
				MyFamilyTreeNode grandParent = parent.getParent();
				if (grandParent != null) {
					for (MyFamilyTreeNode child : grandParent.getChildren()) {
						if (child.isMale() == true && !(parent.getPerson().equalsIgnoreCase(child.getPerson()))) {
							list.add(child);
						}
					}
				}
			}
		}
		return list;
	}
}
