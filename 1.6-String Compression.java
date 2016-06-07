// Use StringBuilder to optimize the algorothm

String compress(String str){
    StringBuilder compressed = new StringBuilder();
    int countConsecutive = 0;
    for (int i = 0; i < str.length(); i++){
        countConsecutive++;
        //If next charater is different than current, append this char to result.
        if( i+1 >= str.length || str.charAt(i) != str.charAt(i+1)){
            compressed.append(str.charAt(i));
            compressed.append(countConsecutive);
            countConsecutive = 0;
        }
    }
    return compressed.length() < str.length() ? compressed.toString() : str;
}


// Optimized Algorithm: Check in advance, avoid to create a string that we never use, also initialize the StringBuilder to its necessary capacity up-front.

String compress(String str){
    /*check final length and return input string if it would be longer. */
    int finalLength = countCompression(str);
    if (finalLength >= str.length()) return str;
    
    StringBuilder compressed = new StringBuilder(finalLength); // initial capacity.
    int countConsecutive = 0;
    for (int i = 0; i < str.length(); i++){
        countConsecutive++;
        //If next charater is different than current, append this char to result.
        if( i+1 >= str.length || str.charAt(i) != str.charAt(i+1)){
            compressed.append(str.charAt(i));
            compressed.append(countConsecutive);
            countConsecutive = 0;
        }
    }
    return compressed.toString();
}

int countCompression(Sting str){
    int compressedLength =0;
    int countConsecutive = 0;
     for (int i = 0; i < str.length(); i++){
        countConsecutive++;
        
        if( i+1 >= str.length || str.charAt(i) != str.charAt(i+1)){
            compressedLength += 1 + String.valueOf(countConsecutive).length();   //int to String: 10 -> "10"
            countConsecutive = 0;
        }
    }
    return compressedLength;
}