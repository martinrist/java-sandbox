package com.martinrist.sandbox.interviews.nodeTraversal;

import java.util.HashSet;
import java.util.Set;


public class NodeTraversal {

	
	static class Node {
		
		public String name;
		private boolean visited = false;
		
		public Node(String _name) {
			this.name = _name;
		}
		
		public Set<Node> dependsOn = new HashSet<Node>();
		
		public void printOrder() {
			
			if (visited && !dependsOn.isEmpty()) {
				System.out.println("Found cycle!");
			}
			
			if (!visited) {
				visited = true;
				for (Node d : dependsOn) {
					d.printOrder();
				}
				System.out.println(name);
			}
		}

	}
	
	
	public static void main(String[] args) {
		
		Node nodeFoo = new Node("foo");
		Node nodeBar = new Node("bar");
		Node nodeBaz = new Node("baz");
		
		nodeFoo.dependsOn.add(nodeBar);
		nodeFoo.dependsOn.add(nodeBaz);
	    nodeBar.dependsOn.add(nodeBaz);
	    nodeBaz.dependsOn.add(nodeFoo);
	    
	    nodeFoo.printOrder();
	}
	


}
