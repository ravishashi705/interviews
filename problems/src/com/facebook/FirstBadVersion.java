package com.facebook;
/**
 * You are a product manager and currently leading a team to develop a new product. 
 * Unfortunately, the latest version of your product fails the quality check. 
 * Since each version is developed based on the previous version, 
 * all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, 
which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. 
Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */
public class FirstBadVersion {
	
	// Runtime :  O(log N),  Space : O(1)
	
	public int firstBadVersion(int n) {
		return firstBadVersion(1, n); // good version starts with 1
	}

	public int firstBadVersion(int goodVersion, int badVersion) {
		while (goodVersion < badVersion) {
			int mid = goodVersion + (badVersion - goodVersion) / 2;
			if (isBadVersion(mid)) {
				badVersion = mid;
			} else {
				goodVersion = mid + 1;
			}
		}
		return goodVersion;
	}
}
