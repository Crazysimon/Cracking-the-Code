boolean IsRotation(String s1, String s2){
    int len = s1. length();
    /*check that s1 and s2 are equal length and not empty*/
    if(len == s2.length() && len > 0 ){
        String s1s1 = s1 + s1;
        return isSubstring(s1s1,s2);
    }
    return false;
}