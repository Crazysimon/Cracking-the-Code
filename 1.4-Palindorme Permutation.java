//Algorithm 1: A String can have no more than one character that is odd.
/*
use a hash table to count how many times each character appears then iterate it though make sure that no more than one character has an odd count.
*/

boolean isPermutationOfPalindrome(String phrase){
    int[] hashtable = buildCharFrequencyTable(phrase);
    return checkMaxOneOdd(hashtable);
    }
    
//count how many times each charactor appear.

int[] buildCharFrequencyTable(String phrase){
    int[] hashtable = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1 ];
    for (char c : phrase.toCharArray()){
        int x =getCharNumber(c);
        if (x != -1){
            hashtable[x]++;
        }
    }
    return hashtable;
}

int getCharNumber(Character c){
    int a = Character.getNumericValue('a');
    int z = Character.getNumericValue('z');
    int val = Character.getNumericValue(c);
    if (a <=val && val <= z){
        return val - a;
    }
    return -1;
}

boolean checkMaxOneOdd(int[] table){
    boolean foundOdd = false;
    for (int count : table){
        if (count %2 == 1){
            if(foundOdd){
                return false;
            }
        foundOdd = true;
        }
    }
    return true;
}




//Algorithm 2:optimize, check the odd number as we go along

boolean isPermutationOfPalindrome(String phrase){
    int countOdd = 0;
    int[] hashtable = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1 ];
    for (char c : phrase.toCharArray()){
        int x = getCharNumber(c);
        if (x != -1 ){
           hashtable[x]++;
           if (table[x]%2 == 1){
            countOdd++;
           }else{
            countOdd--;
           }
        }
    }
    return countOdd <= 1;
    
}

int getCharNumber(Character c){
    int a = Character.getNumericValue('a');
    int z = Character.getNumericValue('z');
    int val = Character.getNumericValue(c);
    if (a <=val && val <= z){
        return val - a;
    }
    return -1;
}