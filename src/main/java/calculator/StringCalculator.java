package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.management.RuntimeErrorException;

class StringCalculator {



	public int add(String input) {
		if(input.isEmpty())
			return 0;
		if(input.startsWith("M")) {
			String[] numbers = input.split("M|,");
			int result=0;
			for(int i=1; i<numbers.length; i++ ) {
			
				result +=3*Integer.parseInt(numbers[i]);
				
			}
			return result;
		}
		else {
			String[] numbers = number_extractor(input);
			int result=0;
			StringBuilder negatives= new StringBuilder();
			for(int i=0; i<numbers.length; i++ ) {
				if(Integer.parseInt(numbers[i])<0)
					negatives.append(Integer.parseInt(numbers[i]));
			}
			//    		System.out.println(negatives.length());
			//    		System.out.println(negatives);
			if(negatives.length()==0) {
				for(int i=0; i<numbers.length; i++ ) {
					result +=Integer.parseInt(numbers[i]);
				}
				return result;
			}
			else {
				throw new RuntimeException("No negatives allowed and negative numbers are"+negatives);
			}
		}
	

	}

	private static String[] number_extractor(String input) {
		if(input.startsWith("M")) {
			Matcher m = Pattern.compile("M(.)").matcher(input);
			m.matches();
			String cust = m.group(1);
			String numbers = m.group(2);
			String[] number2 =numbers.split(",");
			return number2;

		}else if(input.startsWith("//")) {
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