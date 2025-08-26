/*
49. Group Anagrams

Given an array of strings strs, group the anagrams together. You can return the answer in any order.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]



Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
 */

class Solution {
    List<List<String>> ans;
    Map<String, List<String>> map = new HashMap<>();
    public List<List<String>> groupAnagrams(String[] strs) {
        for (String str : strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String newStr = new String(temp);

            if (!map.containsKey(newStr)) {
                map.put(newStr, new ArrayList<>());
                map.get(newStr).add(str);
            } else {
                map.get(newStr).add(str);
            }
        }

        ans = new ArrayList<>(map.values());
        return ans;
    }
}