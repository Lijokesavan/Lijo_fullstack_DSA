package com.greatlearning.Q2;

import java.util.ArrayList;

class FindLongestPath {

	
	static class Node {
		Node leftNode;
		Node rightNode;
		int nodeData;
	};

	
	static Node newNode(int nodeData) {
		Node temp = new Node();

		temp.nodeData = nodeData;
		temp.leftNode = null;
		temp.rightNode = null;

		return temp;
	}

	
	public static ArrayList<Integer> findLongestPath(Node root) {

		// If root is null means there
		// is no binary tree so
		// return a empty vector
		if (root == null) {
			ArrayList<Integer> output = new ArrayList<>();
			return output;
		}

		// Recursive call on root.rightNode
		ArrayList<Integer> rightNode = findLongestPath(root.rightNode);

		// Recursive call on root.leftNode
		ArrayList<Integer> leftNode = findLongestPath(root.leftNode);

		// Compare the size of the two ArrayList
		// and insert current node accordingly
		if (rightNode.size() < leftNode.size()) {
			leftNode.add(root.nodeData);
		} else {
			rightNode.add(root.nodeData);
		}

		// Return the appropriate ArrayList
		return (leftNode.size() > rightNode.size() ? leftNode : rightNode);
	}

	// Driver Code
	public static void main(String[] args) {
		Node root = newNode(100);
		root.leftNode = newNode(20);
		root.rightNode = newNode(130);
		root.leftNode.leftNode = newNode(10);
		root.leftNode.rightNode = newNode(50);
		root.rightNode.leftNode = newNode(110);
		root.rightNode.rightNode = newNode(140);
		root.leftNode.leftNode.leftNode = newNode(5);
		

		ArrayList<Integer> output = findLongestPath(root);
		int size = output.size();

		System.out.print(output.get(size - 1));
		for (int i = size - 2; i >= 0; i--) {
			System.out.print(" -> " + output.get(i));
		}
	}
}