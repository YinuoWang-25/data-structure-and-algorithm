package todo;

public class GeneralizedAbbreviation {
    // 320. Generalized Abbreviation
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        String cur = "";
        help(res, word, 0, cur, 0);
        return res;
    }

    private void help(List<String> res, String word, int pos, String cur, int count){
        if(pos == word.length()){
            if(count > 0){
                cur += count;
            }
            res.add(cur);
        }
        else{
            help(res, word, pos + 1, cur, count + 1);
            if(count > 0){
                cur = cur + count + word.charAt(pos);
            }
            else{
                cur = cur + word.charAt(pos);
            }
            help(res, word, pos + 1, cur, 0);
        }
    }
}
