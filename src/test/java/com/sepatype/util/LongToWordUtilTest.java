package com.sepatype.util;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LongToWordUtilTest {
  private static final Map<Long, String> validMap = new HashMap<>();

  @BeforeClass
  public static void setUpClass() {
    validMap.put(Long.MIN_VALUE, "Negative nine quintillion two hundred twenty three quadrillion three hundred seventy two trillion thirty six billion eight hundred fifty four million seven hundred seventy five thousand eight hundred and seven");
    validMap.put(-2935174315119L, "Negative two trillion nine hundred thirty five billion one hundred seventy four million three hundred fifteen thousand one hundred and nineteen");
    validMap.put(-935174315119L,  "Negative nine hundred thirty five billion one hundred seventy four million three hundred fifteen thousand one hundred and nineteen");
    validMap.put(-35174315119L,   "Negative thirty five billion one hundred seventy four million three hundred fifteen thousand one hundred and nineteen");
    validMap.put(-15174315119L,   "Negative fifteen billion one hundred seventy four million three hundred fifteen thousand one hundred and nineteen");
    validMap.put(-1174315119L,    "Negative one billion one hundred seventy four million three hundred fifteen thousand one hundred and nineteen");
    validMap.put(-1174315110L,    "Negative one billion one hundred seventy four million three hundred fifteen thousand one hundred and ten");
    validMap.put(-999999999L,     "Negative nine hundred ninety nine million nine hundred ninety nine thousand nine hundred and ninety nine");
    validMap.put(-999999000L,     "Negative nine hundred ninety nine million nine hundred ninety nine thousand");
    validMap.put(-999000999L,     "Negative nine hundred ninety nine million nine hundred and ninety nine");
    validMap.put(-999000000L,     "Negative nine hundred ninety nine million");
    validMap.put(-606606606L,     "Negative six hundred six million six hundred six thousand six hundred and six");
    validMap.put(-500500500L,     "Negative five hundred million five hundred thousand five hundred");
    validMap.put(-100100100L,     "Negative one hundred million one hundred thousand one hundred");
    validMap.put(-5000000L,       "Negative five million");
    validMap.put(-4000000L,       "Negative four million");
    validMap.put(-2000000L,       "Negative two million");
    validMap.put(-1000000L,       "Negative one million");
    validMap.put(-999999L,        "Negative nine hundred ninety nine thousand nine hundred and ninety nine");
    validMap.put(-999000L,        "Negative nine hundred ninety nine thousand");
    validMap.put(-21000L,         "Negative twenty one thousand");
    validMap.put(-11000L,         "Negative eleven thousand");
    validMap.put(-5000L,          "Negative five thousand");
    validMap.put(-4000L,          "Negative four thousand");
    validMap.put(-2000L,          "Negative two thousand");
    validMap.put(-1000L,          "Negative one thousand");
    validMap.put(-999L,           "Negative nine hundred and ninety nine");
    validMap.put(-990L,           "Negative nine hundred and ninety");
    validMap.put(-919L,           "Negative nine hundred and nineteen");
    validMap.put(-909L,           "Negative nine hundred and nine");
    validMap.put(-900L,           "Negative nine hundred");
    validMap.put(-121L,           "Negative one hundred and twenty one");
    validMap.put(-120L,           "Negative one hundred and twenty");
    validMap.put(-111L,           "Negative one hundred and eleven");
    validMap.put(-101L,           "Negative one hundred and one");
    validMap.put(-100L,           "Negative one hundred");
    validMap.put(-99L,            "Negative ninety nine");
    validMap.put(-90L,            "Negative ninety");
    validMap.put(-80L,            "Negative eighty");
    validMap.put(-21L,            "Negative twenty one");
    validMap.put(-20L,            "Negative twenty");
    validMap.put(-19L,            "Negative nineteen");
    validMap.put(-11L,            "Negative eleven");
    validMap.put(-10L,            "Negative ten");
    validMap.put(-9L,             "Negative nine");
    validMap.put(-1L,             "Negative one");
    validMap.put(0L,             "Zero");
    validMap.put(1L,             "One");
    validMap.put(9L,             "Nine");
    validMap.put(10L,            "Ten");
    validMap.put(11L,            "Eleven");
    validMap.put(19L,            "Nineteen");
    validMap.put(20L,            "Twenty");
    validMap.put(21L,            "Twenty one");
    validMap.put(80L,            "Eighty");
    validMap.put(90L,            "Ninety");
    validMap.put(99L,            "Ninety nine");
    validMap.put(100L,           "One hundred");
    validMap.put(101L,           "One hundred and one");
    validMap.put(111L,           "One hundred and eleven");
    validMap.put(120L,           "One hundred and twenty");
    validMap.put(121L,           "One hundred and twenty one");
    validMap.put(900L,           "Nine hundred");
    validMap.put(909L,           "Nine hundred and nine");
    validMap.put(919L,           "Nine hundred and nineteen");
    validMap.put(990L,           "Nine hundred and ninety");
    validMap.put(999L,           "Nine hundred and ninety nine");
    validMap.put(1000L,          "One thousand");
    validMap.put(2000L,          "Two thousand");
    validMap.put(4000L,          "Four thousand");
    validMap.put(5000L,          "Five thousand");
    validMap.put(11000L,         "Eleven thousand");
    validMap.put(21000L,         "Twenty one thousand");
    validMap.put(999000L,        "Nine hundred ninety nine thousand");
    validMap.put(999999L,        "Nine hundred ninety nine thousand nine hundred and ninety nine");
    validMap.put(1000000L,       "One million");
    validMap.put(2000000L,       "Two million");
    validMap.put(4000000L,       "Four million");
    validMap.put(5000000L,       "Five million");
    validMap.put(100100100L,     "One hundred million one hundred thousand one hundred");
    validMap.put(500500500L,     "Five hundred million five hundred thousand five hundred");
    validMap.put(606606606L,     "Six hundred six million six hundred six thousand six hundred and six");
    validMap.put(999000000L,     "Nine hundred ninety nine million");
    validMap.put(999000999L,     "Nine hundred ninety nine million nine hundred and ninety nine");
    validMap.put(999999000L,     "Nine hundred ninety nine million nine hundred ninety nine thousand");
    validMap.put(999999999L,     "Nine hundred ninety nine million nine hundred ninety nine thousand nine hundred and ninety nine");
    validMap.put(1174315110L,    "One billion one hundred seventy four million three hundred fifteen thousand one hundred and ten");
    validMap.put(1174315119L,    "One billion one hundred seventy four million three hundred fifteen thousand one hundred and nineteen");
    validMap.put(15174315119L,   "Fifteen billion one hundred seventy four million three hundred fifteen thousand one hundred and nineteen");
    validMap.put(35174315119L,   "Thirty five billion one hundred seventy four million three hundred fifteen thousand one hundred and nineteen");
    validMap.put(935174315119L,  "Nine hundred thirty five billion one hundred seventy four million three hundred fifteen thousand one hundred and nineteen");
    validMap.put(2935174315119L, "Two trillion nine hundred thirty five billion one hundred seventy four million three hundred fifteen thousand one hundred and nineteen");
    validMap.put(Long.MAX_VALUE, "Nine quintillion two hundred twenty three quadrillion three hundred seventy two trillion thirty six billion eight hundred fifty four million seven hundred seventy five thousand eight hundred and seven");

  }


  @Test
  public void testLongToWords() {
    for (Map.Entry<Long,String> entry : validMap.entrySet()) {
      String word = LongToWordUtil.longToWords(entry.getKey());
      Assert.assertEquals(entry.getValue(), word);
    }
  }
}
