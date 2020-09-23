// 273. Integer to English Words
/*
    Intuition: We solve it in recursive way

    For num under 1000:
    case 1: num -> [1, 19], we directly read it from LESS_THAN_20
    case 2 num -> [20, 99], we read it from TENS and deal with remaining part in case 1
    case 3: num -> [100, 999], we read hundred in LESS_THAN_20 and deal with remaining part in case 2

    For num >= 1000:
    We deal with every 3 digits from right to left, and give it right weight by adding word in THOUSANDS
 */

public class L273_IntegerToEnglish {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder words = new StringBuilder();
        int index = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                words.insert(0, numToWords(num % 1000) + THOUSANDS[index] + " ");
            }
            num /= 1000;
            index++;
        }
        return words.toString().trim();
    }

    private String numToWords(int num) {
        if (num == 0) return "";
        else if (num < 20) return LESS_THAN_20[num] + " ";
        else if (num < 100) return TENS[num / 10] + " " + numToWords(num % 10);
        return LESS_THAN_20[num / 100] + " Hundred " + numToWords(num % 100);
    }
}