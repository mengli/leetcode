Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:

If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:

Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
Example 2:

Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.

class Solution {
    
    public List<String> findItinerary(String[][] tickets) {
        Set<String> set = new HashSet<>();
        int col = tickets.length;
        for (int i = 0; i < col; i++) {
            set.add(tickets[i][0]);
            set.add(tickets[i][1]);
        }
        String[] airports = set.toArray(new String[0]);
        Arrays.sort(airports);
        Map<String, Integer> indexs = new HashMap<>();
        for (int i = 0; i < airports.length; i++) {
            indexs.put(airports[i], i);
        }
        int[][] m = new int[set.size()][set.size()];
        for (int i = 0; i < col; i++) {
            m[indexs.get(tickets[i][0])][indexs.get(tickets[i][1])] += 1;
        }
        List<String> sol = new ArrayList<>();
        sol.add("JFK");
        find(m, "JFK", sol, indexs, airports, tickets.length);
        return sol;
    }

    private boolean find(
        int[][] m, String airport, List<String> sol, Map<String, Integer> indexs, String[] airports, int count) {
        if (count == 0) return true;
        int row = indexs.get(airport);
        for (int i = 0; i < m.length; i++) {
            if (m[row][i] > 0) {
                m[row][i] -= 1;
                sol.add(airports[i]);
                boolean ret = find(m, airports[i], sol, indexs, airports, count - 1);
                if (ret) {
                    return true;
                }
                sol.remove(sol.size() - 1);
                m[row][i] += 1;
            }
        }
        return false;
    }
}