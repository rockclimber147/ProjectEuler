package Problems._0001To00025._0017_Number_Letter_Counts;

import Stats.RunInfo;

public class NumberLetterCounts {
    private static final int ONE = "one".length();
    private static final int TWO = "two".length();
    private static final int THREE = "three".length();
    private static final int FOUR = "four".length();
    private static final int FIVE = "five".length();
    private static final int SIX = "six".length();
    private static final int SEVEN = "seven".length();
    private static final int EIGHT = "eight".length();
    private static final int NINE = "nine".length();
    private static final int TEN = "ten".length();
    private static final int ELEVEN = "eleven".length();
    private static final int TWELVE = "twelve".length();
    private static final int THIRTEEN = "thirteen".length();
    private static final int FOURTEEN = "fourteen".length();
    private static final int FIFTEEN = "fifteen".length();
    private static final int SIXTEEN = "sixteen".length();
    private static final int SEVENTEEN = "seventeen".length();
    private static final int EIGHTEEN = "eighteen".length();
    private static final int NINETEEN = "nineteen".length();
    private static final int TWENTY = "twenty".length();
    private static final int THIRTY = "thirty".length();
    private static final int FORTY = "forty".length();
    private static final int FIFTY = "fifty".length();
    private static final int SIXTY = "sixty".length();
    private static final int SEVENTY = "seventy".length();
    private static final int EIGHTY = "eighty".length();
    private static final int NINETY = "ninety".length();
    private static final int HUNDRED = "hundred".length();
    private static final int AND = "and".length();
    private static final int ONE_THOUSAND = ONE + "thousand".length();

    public static void solution() {

        int oneToNine = ONE + TWO + THREE + FOUR + FIVE + SIX + SEVEN + EIGHT + NINE;
        int tenToNineteen = TEN + ELEVEN + TWELVE + THIRTEEN + FOURTEEN + FIFTEEN
                + SIXTEEN + SEVENTEEN + EIGHTEEN + NINETEEN;
        int twentyToNinety = TWENTY + THIRTY + FORTY + FIFTY + SIXTY + SEVENTY + EIGHTY + NINETY;

        int oneToNinetyNine = oneToNine * 9
                + tenToNineteen
                + (twentyToNinety * 10);

        int timesOneToNinetyNineIsUsed = oneToNinetyNine * 10;
        int timesHundredIsUsed = 999 - 100 + 1;
        int timesAndIsUsed = timesHundredIsUsed - 9;
        int hundredsPrefixes = oneToNine * 100;

        int oneToNineHundredAndNinetyNine = timesOneToNinetyNineIsUsed
                + timesHundredIsUsed * HUNDRED
                + timesAndIsUsed * AND
                + hundredsPrefixes;

        int solution = oneToNineHundredAndNinetyNine + ONE_THOUSAND;

        System.out.println(solution);
    }

    public static void main(String[] args) {
        RunInfo.executeWithInfo(NumberLetterCounts::solution);
    }
}
