package com.sepatype.util;

import static java.util.Map.entry;

import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class LongToWordUtilTest {
  private static final Map<Long, String> validMap = Map.ofEntries(
      entry(Long.MIN_VALUE, "Negative Nine Quintillion Two Hundred Twenty Three Quadrillion Three Hundred Seventy Two Trillion Thirty Six Billion Eight Hundred Fifty Four Million Seven Hundred Seventy Five Thousand Eight Hundred Seven"),
      entry(-2935174315119L, "Negative Two Trillion Nine Hundred Thirty Five Billion One Hundred Seventy Four Million Three Hundred Fifteen Thousand One Hundred Nineteen"),
      entry(-935174315119L,  "Negative Nine Hundred Thirty Five Billion One Hundred Seventy Four Million Three Hundred Fifteen Thousand One Hundred Nineteen"),
      entry(-35174315119L,   "Negative Thirty Five Billion One Hundred Seventy Four Million Three Hundred Fifteen Thousand One Hundred Nineteen"),
      entry(-15174315119L,   "Negative Fifteen Billion One Hundred Seventy Four Million Three Hundred Fifteen Thousand One Hundred Nineteen"),
      entry(-1174315119L,    "Negative One Billion One Hundred Seventy Four Million Three Hundred Fifteen Thousand One Hundred Nineteen"),
      entry(-1174315110L,    "Negative One Billion One Hundred Seventy Four Million Three Hundred Fifteen Thousand One Hundred Ten"),
      entry(-999999999L,     "Negative Nine Hundred Ninety Nine Million Nine Hundred Ninety Nine Thousand Nine Hundred Ninety Nine"),
      entry(-999999000L,     "Negative Nine Hundred Ninety Nine Million Nine Hundred Ninety Nine Thousand"),
      entry(-999000999L,     "Negative Nine Hundred Ninety Nine Million Nine Hundred Ninety Nine"),
      entry(-999000000L,     "Negative Nine Hundred Ninety Nine Million"),
      entry(-606606606L,     "Negative Six Hundred Six Million Six Hundred Six Thousand Six Hundred Six"),
      entry(-500500500L,     "Negative Five Hundred Million Five Hundred Thousand Five Hundred"),
      entry(-100100100L,     "Negative One Hundred Million One Hundred Thousand One Hundred"),
      entry(-5000000L,       "Negative Five Million"),
      entry(-4000000L,       "Negative Four Million"),
      entry(-2000000L,       "Negative Two Million"),
      entry(-1000000L,       "Negative One Million"),
      entry(-999999L,        "Negative Nine Hundred Ninety Nine Thousand Nine Hundred Ninety Nine"),
      entry(-999000L,        "Negative Nine Hundred Ninety Nine Thousand"),
      entry(-21000L,         "Negative Twenty One Thousand"),
      entry(-11000L,         "Negative Eleven Thousand"),
      entry(-5000L,          "Negative Five Thousand"),
      entry(-4000L,          "Negative Four Thousand"),
      entry(-2000L,          "Negative Two Thousand"),
      entry(-1000L,          "Negative One Thousand"),
      entry(-999L,           "Negative Nine Hundred Ninety Nine"),
      entry(-990L,           "Negative Nine Hundred Ninety"),
      entry(-919L,           "Negative Nine Hundred Nineteen"),
      entry(-909L,           "Negative Nine Hundred Nine"),
      entry(-900L,           "Negative Nine Hundred"),
      entry(-121L,           "Negative One Hundred Twenty One"),
      entry(-120L,           "Negative One Hundred Twenty"),
      entry(-111L,           "Negative One Hundred Eleven"),
      entry(-101L,           "Negative One Hundred One"),
      entry(-100L,           "Negative One Hundred"),
      entry(-99L,            "Negative Ninety Nine"),
      entry(-90L,            "Negative Ninety"),
      entry(-80L,            "Negative Eighty"),
      entry(-21L,            "Negative Twenty One"),
      entry(-20L,            "Negative Twenty"),
      entry(-19L,            "Negative Nineteen"),
      entry(-11L,            "Negative Eleven"),
      entry(-10L,            "Negative Ten"),
      entry(-9L,             "Negative Nine"),
      entry(-1L,             "Negative One"),
      entry(0L,             "Zero"),
      entry(1L,             "One"),
      entry(9L,             "Nine"),
      entry(10L,            "Ten"),
      entry(11L,            "Eleven"),
      entry(19L,            "Nineteen"),
      entry(20L,            "Twenty"),
      entry(21L,            "Twenty One"),
      entry(80L,            "Eighty"),
      entry(90L,            "Ninety"),
      entry(99L,            "Ninety Nine"),
      entry(100L,           "One Hundred"),
      entry(101L,           "One Hundred One"),
      entry(111L,           "One Hundred Eleven"),
      entry(120L,           "One Hundred Twenty"),
      entry(121L,           "One Hundred Twenty One"),
      entry(900L,           "Nine Hundred"),
      entry(909L,           "Nine Hundred Nine"),
      entry(919L,           "Nine Hundred Nineteen"),
      entry(990L,           "Nine Hundred Ninety"),
      entry(999L,           "Nine Hundred Ninety Nine"),
      entry(1000L,          "One Thousand"),
      entry(2000L,          "Two Thousand"),
      entry(4000L,          "Four Thousand"),
      entry(5000L,          "Five Thousand"),
      entry(11000L,         "Eleven Thousand"),
      entry(21000L,         "Twenty One Thousand"),
      entry(999000L,        "Nine Hundred Ninety Nine Thousand"),
      entry(999999L,        "Nine Hundred Ninety Nine Thousand Nine Hundred Ninety Nine"),
      entry(1000000L,       "One Million"),
      entry(2000000L,       "Two Million"),
      entry(4000000L,       "Four Million"),
      entry(5000000L,       "Five Million"),
      entry(100100100L,     "One Hundred Million One Hundred Thousand One Hundred"),
      entry(500500500L,     "Five Hundred Million Five Hundred Thousand Five Hundred"),
      entry(606606606L,     "Six Hundred Six Million Six Hundred Six Thousand Six Hundred Six"),
      entry(999000000L,     "Nine Hundred Ninety Nine Million"),
      entry(999000999L,     "Nine Hundred Ninety Nine Million Nine Hundred Ninety Nine"),
      entry(999999000L,     "Nine Hundred Ninety Nine Million Nine Hundred Ninety Nine Thousand"),
      entry(999999999L,     "Nine Hundred Ninety Nine Million Nine Hundred Ninety Nine Thousand Nine Hundred Ninety Nine"),
      entry(1174315110L,    "One Billion One Hundred Seventy Four Million Three Hundred Fifteen Thousand One Hundred Ten"),
      entry(1174315119L,    "One Billion One Hundred Seventy Four Million Three Hundred Fifteen Thousand One Hundred Nineteen"),
      entry(15174315119L,   "Fifteen Billion One Hundred Seventy Four Million Three Hundred Fifteen Thousand One Hundred Nineteen"),
      entry(35174315119L,   "Thirty Five Billion One Hundred Seventy Four Million Three Hundred Fifteen Thousand One Hundred Nineteen"),
      entry(935174315119L,  "Nine Hundred Thirty Five Billion One Hundred Seventy Four Million Three Hundred Fifteen Thousand One Hundred Nineteen"),
      entry(2935174315119L, "Two Trillion Nine Hundred Thirty Five Billion One Hundred Seventy Four Million Three Hundred Fifteen Thousand One Hundred Nineteen"),
      entry(Long.MAX_VALUE, "Nine Quintillion Two Hundred Twenty Three Quadrillion Three Hundred Seventy Two Trillion Thirty Six Billion Eight Hundred Fifty Four Million Seven Hundred Seventy Five Thousand Eight Hundred Seven")
  );


  @Test
  public void testLongToWords() {
    for (Map.Entry<Long,String> entry : validMap.entrySet()) {
      String word = LongToWordUtil.longToWords(entry.getKey());
      Assert.assertEquals(entry.getValue(), word);
    }
  }
}
