package org.pg.march.lc.string;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/
 */
public class RemoveSubFoldersFromFilesystem {

	public List<String> removeSubfolders(String[] folder) {
		TrieNodeTraverser trieTraverser = new TrieNodeTraverser();
		if (folder != null) {
			for (String path : folder) {
				trieTraverser.put(path);
			}
		}
		return trieTraverser.getAllPaths();
	}
	
	
	private static class TrieNodeTraverser{
		private TrieNode root;
		
		public void put(String folder) {
			String[] splitFolders = folder.substring(1).split("/");
			this.root = _put(root, splitFolders, 0, folder);
		}
		
		public List<String> getAllPaths(){
			List<String> paths = new ArrayList<>();
			_traverse(root, paths);
			return paths;
		}
		
		private void _traverse(TrieNode root, List<String> paths) {
			if(root == null) {
				return;
			}
			if(root.path != null) {
				paths.add(root.path);
			}
			_traverse(root.left, paths);
			_traverse(root.right, paths);
			_traverse(root.mid, paths);
		}
		
		private TrieNode _put(TrieNode root, String[] splitFolders, int pos, String value) {
			if (pos >= splitFolders.length)
				return null;
			if (root == null) {
				root = new TrieNode(splitFolders[pos]);
			}
			int compare = root.dir.compareTo(splitFolders[pos]);
			if (compare < 0) {
				root.left = _put(root.left, splitFolders, pos, value);
			} else if (compare > 0) {
				root.right = _put(root.right, splitFolders, pos, value);
			} else if (pos < splitFolders.length - 1 && root.path == null) {
				root.mid = _put(root.mid, splitFolders, pos + 1, value);
			} else if (pos == splitFolders.length - 1) {
				root.path = value;
				root.mid = null;
			}
			return root;
		}
		
	}
	
	private static class TrieNode {
		private String dir;
		private String path;
		private TrieNode mid;
		private TrieNode left;
		private TrieNode right;

		public TrieNode(String dir) {
			this.dir = dir;
		}
	}
}
