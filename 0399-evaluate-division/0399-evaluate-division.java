import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UnionFind uf = new UnionFind();
        
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            double value = values[i];
            uf.union(equation.get(0), equation.get(1), value);
        }
        
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            results[i] = uf.getRatio(query.get(0), query.get(1));
        }
        
        return results;
    }
}

class UnionFind {
    private Map<String, String> parent;
    private Map<String, Double> ratio;
    
    public UnionFind() {
        parent = new HashMap<>();
        ratio = new HashMap<>();
    }
    
    public void union(String x, String y, double val) {
        String px = find(x);
        String py = find(y);
        parent.put(px, py);
        ratio.put(px, val * (ratio.get(y) / ratio.get(x)));
    }
    
    public String find(String x) {
        if (!parent.containsKey(x)) {
            parent.put(x, x);
            ratio.put(x, 1.0);
        }
        
        if (!x.equals(parent.get(x))) {
            String p = find(parent.get(x));
            ratio.put(x, ratio.get(x) * ratio.get(parent.get(x)));
            parent.put(x, p);
        }
        
        return parent.get(x);
    }
    
    public double getRatio(String x, String y) {
        if (!parent.containsKey(x) || !parent.containsKey(y)) {
            return -1.0;
        }
        
        String px = find(x);
        String py = find(y);
        
        if (!px.equals(py)) {
            return -1.0;
        }
        
        return ratio.get(x) / ratio.get(y);
    }
}