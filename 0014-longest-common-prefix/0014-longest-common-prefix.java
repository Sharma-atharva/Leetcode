class Solution {
    public String longestCommonPrefix(String[] strs) {
        


        StringBuilder resp = new StringBuilder();
        //ordenar el arreglo
        Arrays.sort(strs);
        String primeraPalabra = strs[0];
        String ultimaPalabra = strs[strs.length-1];
        for(int i=0;i<Math.min(primeraPalabra.length(),ultimaPalabra.length());i++){
            if(primeraPalabra.toLowerCase().charAt(i) != ultimaPalabra.toLowerCase().charAt(i) ){
                return resp.toString();
            }
            resp.append(primeraPalabra.charAt(i));
        }


        return resp.toString();
    }
}