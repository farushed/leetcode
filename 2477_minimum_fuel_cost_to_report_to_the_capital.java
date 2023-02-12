// https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/
// Runtime 57 ms Beats 90.71%
// Memory 108.6 MB Beats 44.55%

class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length+1;
        List<Integer>[] graph = new List[n];
        for (int i=0; i<n; i++)
            graph[i] = new ArrayList<>();
        for (int[] road : roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }

        long[] ret = helper(-1, 0, graph, seats);
        return ret[0];
    }

    // array[0] = total fuel so far
    // array[1] = number of full cars
    // array[2] = people in a partially full car
    long[] helper(int from, int cur, List<Integer>[] graph, int seats) {
        long fuel = 0;
        int fullCars = 0;
        int partialCar = 1; // add a person at each step
        for (int nei : graph[cur]) {
            if (nei == from)
                continue;
            long[] ret = helper(cur, nei, graph, seats);
            fuel += ret[0] + ret[1] + (ret[2] > 0 ? 1 : 0);
            fullCars += ret[1];
            partialCar += ret[2];
        }
        while (partialCar > seats) {
            partialCar -= seats;
            fullCars++;
        }

        return new long[] {fuel, fullCars, partialCar};
    }
}
