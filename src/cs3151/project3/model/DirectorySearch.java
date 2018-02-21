/**
 * 
 */
package cs3151.project3.model;

import java.io.File;
import java.util.ArrayList;

/**
 * Defines DiretorySearch Class
 * 
 * @author Corey Thornton
 *
 */
public class DirectorySearch {

	boolean isDirectorySelected;

	/**
	 * Descends directory tree utilizing a Queue
	 * 
	 * @precondition dir != null AND pathList != null AND pathList == empty
	 * @postcondition pathList.size += depth of directory tree
	 * 
	 * @param dir
	 *            the passed in initial directory
	 * @param pathList
	 *            the emptyList to be passed
	 * 
	 */
	public void directorySearch(File dir, ArrayList<String> pathList) {
		if (dir == null) {
			throw new IllegalArgumentException("No Directory Was Selected");
		}
		if (pathList == null) {
			throw new IllegalArgumentException("pathList Cannot Be Null");
		}
		if (pathList.size() != 0) {
			throw new IllegalArgumentException("pathList should be empty");
		}
		LinkedListQueue<File> queue = new LinkedListQueue<File>();
		queue.add(dir);
		while (!queue.isEmpty()) {
			createAllList(pathList, queue);
		}

	}

	/**
	 * Descends directory tree utilizing a Queue
	 * 
	 * @precondition dir != null AND pathList != null AND pathList == empty
	 * @postcondition pathList.size += depth of directory tree
	 * 
	 * @param dir
	 *            the passed in initial directory
	 * @param pathList
	 *            the emptyList to be passed
	 * 
	 */
	public void directorySearch(File dir, ArrayList<String> pathList, Boolean isDirectorySelected) {
		if (dir == null) {
			throw new IllegalArgumentException("No Directory Was Selected");
		}
		if (pathList == null) {
			throw new IllegalArgumentException("pathList Cannot Be Null");
		}
		if (pathList.size() != 0) {
			throw new IllegalArgumentException("pathList should be empty");
		}
		LinkedListQueue<File> queue = new LinkedListQueue<File>();
		queue.add(dir);
		if (isDirectorySelected == true) {
			while (!queue.isEmpty()) {
				createDirectoryList(pathList, queue);
			}
		}
		if (isDirectorySelected == false) {
			while (!queue.isEmpty()) {
				createFileList(pathList, queue);
			}
		}

	}

	private void createAllList(ArrayList<String> pathList, LinkedListQueue<File> queue) {
		File nextFile = queue.remove();
		
		if (nextFile.isDirectory()) {
			for (File currFile : nextFile.listFiles()) {
				if(currFile.isDirectory()) {
					queue.add(currFile);
				}
				pathList.add(currFile.getAbsolutePath());
				
				
				
			}
		}
		if (nextFile.isFile()) {
			pathList.add(nextFile.getAbsolutePath());
		}
	}

	private void createDirectoryList(ArrayList<String> pathList, LinkedListQueue<File> queue) {
		File nextFile = queue.remove();
		if (nextFile.isDirectory()) {
			for (File currFile : nextFile.listFiles()) {
				if(currFile.isDirectory()) {
				queue.add(currFile);
				pathList.add(currFile.getAbsolutePath());
				}
			}
		}
	}

	private void createFileList(ArrayList<String> pathList, LinkedListQueue<File> queue) {
		File nextFile = queue.remove();
		if (nextFile.isDirectory()) {
			for (File currFile : nextFile.listFiles()) {
				queue.add(currFile);
			}

		} else if (nextFile.isFile()) {
			pathList.add(nextFile.getAbsolutePath());
		}
	}

	/**
	 * Makes a new list from from the passed in list matching the specified pattern
	 * 
	 * @precondition pathList != null
	 * @postcondition none
	 * 
	 * @param pattern
	 *            specified pattern
	 * @param pathList
	 *            populated directory and file list
	 * @return new list that adheres to pattern
	 */
	public ArrayList<String> patternMatch(String pattern, ArrayList<String> pathList) {
		if (pathList == null) {
			throw new IllegalArgumentException("pathList cannot be null");
		}
		ArrayList<String> patternList = new ArrayList<String>();
		for (String currString : pathList) {
			if (currString.toLowerCase().contains(pattern)) {
				patternList.add(currString);
			}
		}
		return patternList;

	}

}
