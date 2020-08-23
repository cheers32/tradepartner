package Q050_Q099;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q068ref {  // this is a good solution; the problem self is too complex
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        if(words.length==0) return list;
        if(words.length==1){
            list.add(lastLine(words,0,0,maxWidth));
            return list;
        }
        int start=0;
        int len=0;
        for(int i=0; i<words.length; i++){
            if(len+words[i].length()<=maxWidth){
                len+=words[i].length();
                len++; //space
            } else{
                len=words[i].length()+1;
                list.add(justify(words,start,i-1,maxWidth));
                start=i;
            }
        }
        list.add(lastLine(words,start,words.length-1,maxWidth));
        return list;
    }

    public String justify(String[] words, int i, int j, int maxLen){
        int count = j-i+1;
        int space = j-i;  //空出的位置个数
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for(int k=i; k<=j; k++){
            sum+=words[k].length();
        }
        int empty = maxLen-sum;
        int emptyLen = space!=0 ? empty/space : maxLen-words[i].length(); //每一个空的长度
        int extra = space!=0 ? empty-space*emptyLen : 0; //多出来的space
        for(int k=i; k<=j; k++){
            sb.append(words[k]);
            if(i==j || k!=j){
                for(int m=0; m<emptyLen; m++){
                    sb.append(" ");
                }
                if(extra>0){
                    sb.append(" ");
                    extra--;
                }
            }
        }
        return sb.toString();
    }

    public String lastLine(String[] words, int i, int j, int maxLen){
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while(i<j){
            sb.append(words[i]);
            sb.append(" ");
            idx+=words[i].length()+1;
            i++;
        }
        sb.append(words[i]);
        idx+=words[i].length();
        while(idx<maxLen){
            sb.append(" ");
            idx++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] input = new String[] {"This", "is", "an", "example", "of", "text", "justification."};
        System.out.println(new Q068ref().fullJustify(input, 16));
    }


//    public List<String> fullJustify(String[] words, int maxWidth) {
//        List<String> res = new ArrayList<>();
//        if(words == null || words.length==0)
//            return res;
//        List<String> wordLine = new ArrayList<>();
//        int spaceRem = maxWidth;
//        int wordLen = 0;
//        for(String w : words) {
//            if(w.length()>spaceRem) { // adjust if not fit
//                if(wordLine.size() == 0) // no word was inserted, then quit
//                    break;
//                int spaceNeeded = wordLine.size()-1;
//                int availableSpace = maxWidth - wordLen;
//                int spaceForEach = wordLine.size()==1?availableSpace:availableSpace/(wordLine.size()-1);
//                int extra = wordLine.size()==1?availableSpace:availableSpace%(wordLine.size()-1);
//                StringBuilder sb = new StringBuilder();
//                // apply spaces
//                for(int i=0; i<wordLine.size(); i++) {
//                    sb.append(wordLine.get(i));
//                    if(i!=wordLine.size()-1) {
//                        for(int k=0; k<spaceForEach; k++)
//                            sb.append(" ");
//                    }
//                    if(extra>0) {
//                        sb.append(" ");
//                        extra--;
//                    }
//                    int rem1 = maxWidth-sb.length();  // 注意这里，对于每一行最后需要再确认一次，因为可能不满
//                    for(int a=0; a<rem1; a++)
//                        sb.append(" ");
//                    res.add(sb.toString());
//                    wordLine.clear();
//                    spaceRem = maxWidth;
//                    wordLen = 0;
//                }
//            }
//            // add word to line
//            wordLine.add(w);
//            spaceRem-= words.length;
//            wordLen += w.length();
//            if(spaceRem > 0)
//                spaceRem-=1;
//        }
//        StringBuilder lastLine = new StringBuilder();
//        for(int i=0; i<wordLine.size(); i++) {
//            lastLine.append(wordLine.get(i));
//            if(i!=wordLine.size()-1)
//                lastLine.append(" ");
//        }
//        int rem = maxWidth - lastLine.length();
//        for(int i=0; i<rem; i++)
//            lastLine.append(" ");
//        res.add(lastLine.toString());
//        return res;
//    }


//    public List<String> fullJustify(String[] words, int maxWidth) {
//        List<String> res = new ArrayList<>();
//        if(words == null || words.length==0)
//            return res;
//        List<String> curLine = new ArrayList<>();
//        int curLength = 0;
//        for(int i=0; i<words.length; i++) {
//            int additional = curLine.size()==0 ? 0: 1;
//            if(curLength+additional+words[i].length()<=maxWidth) {
//                curLine.add(words[i]);
//                curLength += additional+words[i].length();
//            } else {
//                int numWords = curLine.size();
//                if(numWords == 1) {
//                    StringBuilder line = new StringBuilder();
//                    line.append(curLine.get(0));
//                    for(int a= curLength+1; a<=maxWidth; a++) {
//                        line.append(" ");
//                    }
//                    res.add(line.toString());
//                    curLine = new ArrayList<>();
//                    curLine.add(words[i]);
//                    curLength = words[i].length();
//                    continue;
//                }
//                int numSlots = numWords-1;
//                int totalLetters = curLength-numSlots;
//                int totalSpaces = maxWidth-totalLetters;
//
//                int div = totalSpaces / numSlots;
//                int rem = totalSpaces % numSlots;
//                StringBuilder line = new StringBuilder();
//                for(int a=0; a<curLine.size()-1; a++) {
//                    line.append(curLine.get(a));
//                    int numSpaces = a
//                }
//            }
//        }
//
//
//
//    }


}
