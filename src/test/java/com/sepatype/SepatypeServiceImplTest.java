package com.sepatype;

import java.math.BigInteger;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SepatypeServiceImplTest {
  private static final SepatypeService service = new SepatypeServiceImpl();

  @Rule
  public ExpectedException expectedEx = ExpectedException.none();


  @Test
  public void testHandleInput() throws SepatypeValidationException {
    SepatypeValue result = service.handleInput("13123123123");
    Assert.assertEquals(13123123123L, result.getLongValue());
    Assert.assertEquals("Thirteen billion one hundred twenty three million one hundred twenty three thousand one hundred and twenty three", result.getWordValue());

    result = service.handleInput("0");
    Assert.assertEquals(0L, result.getLongValue());
    Assert.assertEquals("Zero", result.getWordValue());

    result = service.handleInput(String.valueOf(Long.MAX_VALUE));
    Assert.assertEquals(Long.MAX_VALUE, result.getLongValue());
    Assert.assertEquals("Nine quintillion two hundred twenty three quadrillion three hundred seventy two trillion thirty six billion eight hundred fifty four million seven hundred seventy five thousand eight hundred and seven", result.getWordValue());

    result = service.handleInput(String.valueOf(Long.MIN_VALUE));
    Assert.assertEquals(Long.MIN_VALUE, result.getLongValue());
    Assert.assertEquals("Negative nine quintillion two hundred twenty three quadrillion three hundred seventy two trillion thirty six billion eight hundred fifty four million seven hundred seventy five thousand eight hundred and seven", result.getWordValue());
  }

  @Test
  public void testValidateInput() throws SepatypeValidationException {
    long result = service.validateInput("13123123123");
    Assert.assertEquals(13123123123L, result);

    result = service.validateInput("0");
    Assert.assertEquals(0L, result);

    result = service.validateInput(String.valueOf(Long.MAX_VALUE));
    Assert.assertEquals(Long.MAX_VALUE, result);

    result = service.validateInput(String.valueOf(Long.MIN_VALUE));
    Assert.assertEquals(Long.MIN_VALUE, result);
  }

  @Test
  public void testValidateInputEmptyInput() throws SepatypeValidationException {
    expectedEx.expect(SepatypeValidationException.class);
    expectedEx.expectMessage(SepatypeConstants.EMPTY_INPUT);
    service.validateInput("");
  }

  @Test
  public void testValidateInputNull() throws SepatypeValidationException {
    expectedEx.expect(SepatypeValidationException.class);
    expectedEx.expectMessage(SepatypeConstants.EMPTY_INPUT);
    service.validateInput(null);
  }

  @Test
  public void testValidateInputLessThanLongMinValue() throws SepatypeValidationException {
    expectedEx.expect(SepatypeValidationException.class);
    expectedEx.expectMessage(SepatypeConstants.INVALID_INPUT);

    String input = BigInteger.valueOf(Long.MIN_VALUE)
        .subtract(BigInteger.valueOf(1L))
        .toString();

    service.validateInput(input);
  }

  @Test
  public void testValidateInputGreaterThanLongMaxValue() throws SepatypeValidationException {
    expectedEx.expect(SepatypeValidationException.class);
    expectedEx.expectMessage(SepatypeConstants.INVALID_INPUT);

    String input = BigInteger.valueOf(Long.MAX_VALUE)
        .add(BigInteger.valueOf(1L))
        .toString();

    service.validateInput(input);
  }

  @Test
  public void testValidateInputWord() throws SepatypeValidationException {
    expectedEx.expect(SepatypeValidationException.class);
    expectedEx.expectMessage(SepatypeConstants.INVALID_INPUT);
    service.validateInput("sepatype");
  }

}
