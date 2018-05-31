package edxLearnJava.Module2DataFlow.ModuleProject;

public class Crypto {

    public static void main(String[] args) {
        String encryptedString = encryptString("This is some \"really\" great. (Text)!?", 2, 2);
    }
    
    private static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for(; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if(result.length() < 26) {
            for(currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }
    
    
    public static String normalizeText(String original) {
        
        System.out.println(original);
        
        String copy = original.replaceAll("\"", "").replaceAll("\\.", "").replaceAll("\\!", "").replaceAll("\\?", "").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("\\s", "").toUpperCase();
        
//        System.out.println(copy);
        return copy;
    }
    
    public static String caesarify(String toEncrypt, int shiftKey) {
        String result = "";
        int len = toEncrypt.length();
        
        for (int i = 0; i < len; i++) {
            int c = (char) toEncrypt.charAt(i) + shiftKey;
            
            if (c < 65) {
                c += 26;
            } else if (c > 90) {
                c -= 26;
            }
            result += (char) c;
        }
//        System.out.println(result);
        return result;
    }
    
    public static String groupify(String toGroupify, int groupSize) {
        if (groupSize < 0) {
            return toGroupify;
        }
        String result = "";
        int len = toGroupify.length();
        
        for (int i = 0; i < len; i += groupSize) {
            int endIndex = i + groupSize;
            if (i < len && endIndex < len) {
                result += toGroupify.substring(i, endIndex) + " ";
            } else {
                int k = groupSize;
                
                while (k > 0) {
                    if (i < len) {
                        result += toGroupify.charAt(i);
                    } else {
                        result += (char) 120;
                    }
                    i++;
                    k--;
                }
            }
        }
        
        System.out.println(result);
        return result;
    }
    
    public static String encryptString(String toEncrypt, int shiftKey, int groupSize) {
        String toCaesar = normalizeText(toEncrypt);
        String toGroupify = caesarify(toCaesar, 2);
        
        return groupify(toGroupify, 2);
    }    
}











//public static String caesarify(String toEncrypt, int shiftKey) {
//String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//String shiftedAlphabet = shiftAlphabet(shiftKey);
//
//char[] caeser = new char[toEncrypt.length() + 1];
//int k = 0;
//
//for (int i = 0; i < toEncrypt.length(); i++) {
//  k = 0;
//  while (toEncrypt.charAt(i) != alphabet.charAt(k)) {
//      k++;
//  }
//  caeser[i] = shiftedAlphabet.charAt(k);
//}
//
//String caeserPost = String.valueOf(caeser);
//return caeserPost;
//}
