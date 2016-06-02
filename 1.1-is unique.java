//The String is ASCII or Unicode? 

//algorithm 1
boolean isUniqueChars(string str){
    if(str.length() >128)
        return false;
    boolean[] char_set = new boolean[128];
    for (i = 0; i < str.length(); i++){
        int val = str.charAt(i);
        if (char_set[val])   // this char has already existed in String.
            return false;
        char_set[val]=true;
    }
    return true;

}


//algorithm 2
boolean isUniqueChars(string str){
    int checker = 0;
    for (int i = 0; i < str.length(); i++){
        int val = str.charAt(i) - 'a';
        if ((checker & (1 << val)) > 0){
            return false
        }
        checker |= (1<<val);
    }
    return true;

}