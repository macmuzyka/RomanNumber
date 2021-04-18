public class RomanConverter {

    // TODO: 3449 = 9[3] + 40[2] + 400[1] + 3000[0]
    //  3449 = MMM + CD + XL + IX
    //  3449 = XI + LX + DC + MMM and reverse

    /**
     * Idea of the algorithm is to go from the last number of the given digit (singles)
     * up to first (thousands, hundreds, or tens depending on a given digit)
     * then reversing the output for proper Roman number representation as shown in example above */

    private static final String ROMAN_ONE = "I";
    private static final String ROMAN_FIVE = "V";
    private static final String ROMAN_TEN = "X";
    private static final String ROMAN_FIFTY = "L";
    private static final String ROMAN_ONE_HUNDRED = "C";
    private static final String ROMAN_FIVE_HUNDRED = "D";
    private static final String ROMAN_ONE_THOUSAND = "M";
    private static final int ROMAN_MAX_CONVERTIBLE_NUMBER = 3999;
    private static final int ROMAN_MIN_CONVERTIBLE_NUMBER = 1;

    public String convertToRoman(final int input) {
        if (input > ROMAN_MAX_CONVERTIBLE_NUMBER) {
            throw new IllegalArgumentException("Roman Number too great to be converted!");
        } else if (input < ROMAN_MIN_CONVERTIBLE_NUMBER) {
            throw new IllegalArgumentException("Zero or negative number!");
        }

        final StringBuilder romanSymbolBuilder = new StringBuilder();
        final StringBuilder inputReverser = new StringBuilder();
        final String givenIntegers = "" + input;
        final String reversedIntegers = inputReverser.append(givenIntegers).reverse().toString();

        return buildSymbol(romanSymbolBuilder, reversedIntegers);
    }

    private String buildSymbol(final StringBuilder romanSymbol, final String reversedIntegers) {
        final int romanSize = reversedIntegers.length();

        final int singles = getSingles(reversedIntegers);
        getRomanOnes(romanSymbol, singles);

        if (romanSize > 1) {
            final int tens = getTens(reversedIntegers);
            getRomanTens(romanSymbol, tens);

            if (romanSize > 2) {
                final int hundreds = getHundreds(reversedIntegers);
                getRomanHundreds(romanSymbol, hundreds);

                if (romanSize > 3) {
                    final int thousands = getThousands(reversedIntegers);
                    getRomanThousands(romanSymbol, thousands);
                }
            }

            return romanSymbol.reverse().toString();
        }

        return romanSymbol.reverse().toString();
    }

    private int getSingles(final String reversedIntegers) {
        return Integer.parseInt(String.valueOf(reversedIntegers.charAt(0)));
    }

    private int getTens(final String reversedIntegers) {
        return Integer.parseInt(String.valueOf(reversedIntegers.charAt(1)));
    }

    private int getHundreds(final String reversedIntegers) {
        return Integer.parseInt(String.valueOf(reversedIntegers.charAt(2)));
    }

    private int getThousands(final String reversedIntegers) {
        return Integer.parseInt(String.valueOf(reversedIntegers.charAt(3)));
    }

    private void getRomanOnes(final StringBuilder romanSymbol, final int singles) {
        if (singles < 4) {
            romanSymbol.append(ROMAN_ONE.repeat(singles));
        } else if (singles == 4) {
            romanSymbol.append(ROMAN_FIVE);
            romanSymbol.append(ROMAN_ONE);
        } else if (singles == 5) {
            romanSymbol.append(ROMAN_FIVE);
        } else if (singles < 9) {
            final int retention = singles % 5;
            romanSymbol.append(ROMAN_ONE.repeat(retention));
            romanSymbol.append(ROMAN_FIVE);
        } else if (singles == 9) {
            romanSymbol.append(ROMAN_TEN);
            romanSymbol.append(ROMAN_ONE);
        }
    }

    private void getRomanTens(final StringBuilder romanSymbol, final int tens) {
        if (tens < 4) {
            romanSymbol.append(ROMAN_TEN.repeat(tens));
        } else if (tens == 4) {
            romanSymbol.append(ROMAN_FIFTY);
            romanSymbol.append(ROMAN_TEN);
        } else if (tens == 5) {
            romanSymbol.append(ROMAN_FIFTY);
        } else if (tens < 9) {
            final int retention = tens % 5;
            romanSymbol.append(ROMAN_TEN.repeat(retention));
            romanSymbol.append(ROMAN_FIFTY);
        } else if (tens == 9) {
            romanSymbol.append(ROMAN_ONE_HUNDRED);
            romanSymbol.append(ROMAN_TEN);
        }
    }

    private void getRomanHundreds(final StringBuilder romanSymbol, final int hundreds) {
        if (hundreds < 4) {
            romanSymbol.append(ROMAN_ONE_HUNDRED.repeat(hundreds));
        } else if (hundreds == 4) {
            romanSymbol.append(ROMAN_FIVE_HUNDRED);
            romanSymbol.append(ROMAN_ONE_HUNDRED);
        } else if (hundreds == 5) {
            romanSymbol.append(ROMAN_FIVE_HUNDRED);
        } else if (hundreds < 9) {
            final int retention = hundreds % 5;
            romanSymbol.append(ROMAN_ONE_HUNDRED.repeat(retention));
            romanSymbol.append(ROMAN_FIVE_HUNDRED);
        } else if (hundreds == 9) {
            romanSymbol.append(ROMAN_ONE_THOUSAND);
            romanSymbol.append(ROMAN_ONE_HUNDRED);
        }
    }

    private void getRomanThousands(final StringBuilder romanSymbol, final int thousands) {
        romanSymbol.append(ROMAN_ONE_THOUSAND.repeat(Math.max(0, thousands)));
    }
}

