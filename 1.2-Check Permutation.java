// Whether the permutation is case sensitive? If whitespace is significant?

// We assume case sensitive and whitespace is significant!   "God    " is not permutation to "dog".

//Algorithm 1 : sorting the strings first, than see if they are same after sorting.

String sort(String str){
    char[] content = str.toCharArray();
    java.util.Arrays.sort(content);
    return new String(content);
}

boolean permutation(String s1, String s2){
    if (s1.length() != s2.length()){
        return false;
    }
    return sort(s1).equals(sort(s2));
}

//Algorithm 2: check if the two strings have same charactor counts.

boolean permutation(String s1, String s2){
    if (s1.length() != s2.length()){
        return false;
    }
    
    int[] letters = new int[128];  
    char[] s1_array = s1.toCharArray();
    for (char c : s1_array){ //count number of each char in s1
        letters[c] ++;
    }
    /*
     for (int i = 0; i < s1.length(); i ++){
	    	int c = (int) s1.charAt(i);
	        letters[c] ++;
	    }
     */

    for (int i = 0; i < s2.length(); i ++){
        int c = (int) s2.charAt(i);
        letters[c] --;
        if(letters[c] < 0){
            return false;
        }
    }
    return true;
}