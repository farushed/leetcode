// https://leetcode.com/problems/keys-and-rooms/
// Runtime 6 ms Beats 21.27%
// Memory 45.1 MB Beats 22.13%

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Integer> toVisit = new ArrayList();
        Set<Integer> visited = new HashSet();

        visited.add(0);
        toVisit.addAll(rooms.get(0));

        while (visited.size() < rooms.size() && !toVisit.isEmpty()) {
            int r = toVisit.remove(toVisit.size()-1);
            if (!visited.contains(r)) {
                visited.add(r);
                toVisit.addAll(rooms.get(r));
            }
        }

        return visited.size() == rooms.size();
    }
}
