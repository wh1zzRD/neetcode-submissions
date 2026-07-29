class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, Integer> map = new HashMap<>();
        int idx = 0;
        for (List<String> ticket : tickets) {
            if (!map.containsKey(ticket.get(0))) map.put(ticket.get(0), idx++);
            if (!map.containsKey(ticket.get(1))) map.put(ticket.get(1), idx++);
        }

        ArrayList<ArrayList<String>> adjList = new ArrayList<>();
        ArrayList<ArrayList<Boolean>> edgeUsed = new ArrayList<>();
        for (int i = 0; i < map.size(); i++) {
            adjList.add(new ArrayList<>());
            edgeUsed.add(new ArrayList<>());
        }
        for (List<String> ticket : tickets) {
            adjList.get(map.get(ticket.get(0))).add(ticket.get(1));
            edgeUsed.get(map.get(ticket.get(0))).add(false);
        }

        for (ArrayList<String> arr : adjList) arr.sort(Collections.reverseOrder());

        List<String> currPath = new ArrayList<>();
        List<String> circuit = new ArrayList<>();

        currPath.add("JFK");
        while (currPath.size() > 0) {
            String currNode = currPath.getLast();
            if (adjList.get(map.get(currNode)).size() > 0) {
                String nextNode = adjList.get(map.get(currNode)).remove(adjList.get(map.get(currNode)).size() - 1);
                currPath.add(nextNode);
            } else {
                circuit.add(currPath.getLast());
                currPath.remove(currPath.size() - 1);
            }
        }

        Collections.reverse(circuit);
        return circuit;
    }
}
