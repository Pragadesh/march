package org.pg.march.lc.string;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.pg.march.util.CollectionUtilTest;

import com.google.common.collect.Lists;

public class RemoveSubFoldersFromFilesystemTest {

	private RemoveSubFoldersFromFilesystem removeSubFoldersFromFilesystem;

	@Before
	public void setup() {
		removeSubFoldersFromFilesystem = new RemoveSubFoldersFromFilesystem();
	}

	@Test
	public void testcase1() {
		String[] folder = { "/a", "/a/b", "/c/d", "/c/d/e", "/c/f" };
		List<String> filteredFolders = removeSubFoldersFromFilesystem.removeSubfolders(folder);
		List<String> expected = Lists.newArrayList("/a", "/c/d", "/c/f");
		CollectionUtilTest.assertIgnoreOrderList(expected, filteredFolders);
	}

	@Test
	public void testcase2() {
		String[] folder = { "/a", "/a/b/c", "/a/b/d" };
		List<String> filteredFolders = removeSubFoldersFromFilesystem.removeSubfolders(folder);
		List<String> expected = Lists.newArrayList("/a");
		CollectionUtilTest.assertIgnoreOrderList(expected, filteredFolders);
	}

	@Test
	public void testcase3() {
		String[] folder = { "/a/b/c", "/a/b/ca", "/a/b/d" };
		List<String> filteredFolders = removeSubFoldersFromFilesystem.removeSubfolders(folder);
		List<String> expected = Lists.newArrayList("/a/b/c", "/a/b/ca", "/a/b/d");
		CollectionUtilTest.assertIgnoreOrderList(expected, filteredFolders);
	}
}
