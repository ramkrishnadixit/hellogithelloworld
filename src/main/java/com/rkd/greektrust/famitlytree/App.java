package com.rkd.greektrust.famitlytree;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		MyFamilyTreeNode root = new App().populateShanFamilyHierarchy();
			
		List<MyFamilyTreeNode> results = root.getRelationship("Dritha", "Paternal-Aunt");

		for (MyFamilyTreeNode node : results) {
			System.out.println("person " + node.getPerson() + "  spouse " + node.getSpouse());
		}

	}
	
	public  MyFamilyTreeNode populateShanFamilyHierarchy(){
		
		MyFamilyTreeNode root = new MyFamilyTreeNode("Shan", "Anga", true);

		MyFamilyTreeNode chit = new MyFamilyTreeNode("Chit", "Amba", true);
		MyFamilyTreeNode ish = new MyFamilyTreeNode("Ish", null, true);
		MyFamilyTreeNode vich = new MyFamilyTreeNode("Vich", "Lika", true);
		MyFamilyTreeNode aras = new MyFamilyTreeNode("Aras", "Chitra", true);
		MyFamilyTreeNode satya = new MyFamilyTreeNode("Satya", "Vyan", false);

		root.addChild(chit);
		root.addChild(ish);
		root.addChild(vich);
		root.addChild(aras);
		root.addChild(satya);

		MyFamilyTreeNode dhritha = new MyFamilyTreeNode("Dritha", "Jaya", false);
		MyFamilyTreeNode thritha = new MyFamilyTreeNode("Thritha", null, false);
		MyFamilyTreeNode vhritha = new MyFamilyTreeNode("Vritha", null, true);

		chit.addChild(dhritha);
		chit.addChild(thritha);
		chit.addChild(vhritha);

		MyFamilyTreeNode yodhan = new MyFamilyTreeNode("Yodhan", null, true);
		dhritha.addChild(yodhan);

		MyFamilyTreeNode vila = new MyFamilyTreeNode("vila", null, false);
		MyFamilyTreeNode chika = new MyFamilyTreeNode("chika", null, false);

		vich.addChild(vila);
		vich.addChild(chika);

		MyFamilyTreeNode jnki = new MyFamilyTreeNode("Jnki", "Arit", false);
		MyFamilyTreeNode ahit = new MyFamilyTreeNode("Ahit", null, true);

		aras.addChild(jnki);
		aras.addChild(ahit);

		MyFamilyTreeNode laki = new MyFamilyTreeNode("Laki",null, true);
		MyFamilyTreeNode lavnya = new MyFamilyTreeNode("Lavnya",null, false);

		jnki.addChild(laki);
		jnki.addChild(lavnya);

		MyFamilyTreeNode asva = new MyFamilyTreeNode("Asva", "Satvy", true);
		MyFamilyTreeNode vyas = new MyFamilyTreeNode("Vyas", "Krpi", true);
		MyFamilyTreeNode atya = new MyFamilyTreeNode("Atya", null, false);

		satya.addChild(asva);
		satya.addChild(vyas);
		satya.addChild(atya);

		MyFamilyTreeNode vasa = new MyFamilyTreeNode("Vasa", null, true);
		asva.addChild(vasa);

		MyFamilyTreeNode kriya = new MyFamilyTreeNode("Kriya", null, true);
		MyFamilyTreeNode Krithi = new MyFamilyTreeNode("Krithi", null, false);
		vyas.addChild(kriya);
		vyas.addChild(Krithi);

		return root;
	}

}
