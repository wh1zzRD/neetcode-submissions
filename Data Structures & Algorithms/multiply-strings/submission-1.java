class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        ArrayList<ArrayList<Integer>> partialResults = new ArrayList<>();

        for (int i = num2.length() - 1; i >= 0; i--) {
            ArrayList<Integer> partialResult = new ArrayList<>();
            int b = num2.charAt(i) - '0';

            int carry = 0;
            for (int j = num1.length() - 1; j >= 0; j--) {
                int a = num1.charAt(j) - '0';
                partialResult.add((a * b + carry) % 10);
                carry = (a * b + carry) / 10;
            }

            while (carry > 0) {
                partialResult.add(carry  % 10);
                carry /= 10;
            }

            partialResults.add(partialResult);
        }
        
        for (ArrayList<Integer> p : partialResults) {
            Collections.reverse(p);
            //System.out.println(p.toString());
        }

        int[] indices = new int[partialResults.size()];
        for (int i = 0; i < partialResults.size(); i++) {
            indices[i] = partialResults.get(i).size() - 1 + i;
            //System.out.println(indices[i]);
        }

        int indicesValid = partialResults.size();

        String res = "";
        int carry = 0;
        while (indicesValid > 0) {
            int sum = 0;
            for (int idx = 0; idx < partialResults.size(); idx++) {
                if (indices[idx] < 0 || indices[idx] >= partialResults.get(idx).size()) {
                    indices[idx]--;
                    if (indices[idx] == -1) indicesValid--;
                    continue;
                }

                sum += partialResults.get(idx).get(indices[idx]);
                indices[idx]--;
                if (indices[idx] == -1) indicesValid--;
            }

            res = ((sum + carry) % 10) + res;
            carry = (sum + carry) / 10;
        }
        if (carry > 0) res = carry + res;
        return res;

        // 2 2 2
        // 2 2 2
        // 2 2 2
    }
}
