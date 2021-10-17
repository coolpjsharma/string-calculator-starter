package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringCalculator {

    public int add(String input) {
    	if(input.isEmpty())
        return 0;
    	else {
    		String[] numbers = number_extractor(input);
    		int result=0;
    		for(int i=0; i<numbers.length; i++ ) {
    			result +=Integer.parseInt(numbers[i]);
    		}
    		return result;
     	}
    	
    }
    
    private static String[] number_extractor(String input) {
    	if(input.startsWith("//")) {
    		Matcher m=Pattern.compile("//(.)\n(.*)").matcher(input);
    		m.matches();
    		String customdel = m.group(1);
    		String numbers = m.group(2);
    		return numbers.split(customdel);
    		}
    	else {
    	String[] numbers = input.split(",|\n");
    	return numbers;
    }
    }

}